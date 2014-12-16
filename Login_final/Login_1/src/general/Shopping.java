package general;

import java.awt.List;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import showDetails.Curd;
import javabean.DatabaseAccess;

import login.Login;
import showDetails.Curd;
import tb.UploadAction;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cn.edu.hfut.dmic.webcollector.crawler.BreadthCrawler;
import cn.edu.hfut.dmic.webcollector.model.Page;

public class Shopping extends BreadthCrawler {
	public static boolean amazonflag = false;
	char space = 160;
	
	/* visit�������Ʒ���ÿ��ҳ��ʱ������еĲ��� */
	@Override
	public void visit(Page page) {
		DatabaseAccess db = new DatabaseAccess();
		
		try {
			
			FileWriter out = new FileWriter("D://RESULT.txt", false);
			String str;
			String sql ="";
			int lceq1 = 0;// �������Ƿ񶼵���1��lceq1=1��ʾ�е���1��lceq1=2��ʾ������������1
			Document doc = page.getDoc();
			Elements tables = doc
					.select("table:contains(������),table:contains(�������)");
			
			if (tables.size() != 0)// ��table��ǩ�Ķ������
			{System.out.println("-------taobao-------");
			
				for (Element table : tables) {
					Elements tbodys = table.select("tbody");
					ArrayList<String> orderinfo = null;
					for (Element tbody : tbodys) {
						int l = 0;
						if (tbody.hasClass("order-status"))// ���˲�����tbody
							continue;
						Elements trs = tbody.select("tr");
						if (trs.size() == 1)
							lceq1 = 1;
						for (Element tr : trs) {
							if(tr.text().contains("������")||tr.text().contains("�������")){
								orderinfo = new ArrayList<String>() ;
								l=0;
							}
							l++;
							int j = 0;
							String stringtmp = "";
							Elements tds = tr.select("td");
							if (tds.size() == 1 && lceq1 == 1) {
								lceq1 = 2;
								break;
							}
							
							for (Element td : tds) {
								str = td.text();
								if (str.contains("�鿴") || str.contains("����")
										|| str.contains("����")
										|| str.contains("�ۺ�")
										|| str.contains("�����Ƿ���̨")
										|| str.contains("ʧЧ")
										|| str.contains("����")
										|| str.contains("ɾ��")
										|| str.contains("Ͷ��")
										|| str.contains("����")
										|| str.contains("�˻���"))
									continue;
								if (str.length() != 0) {
									str = str.replace(space, ' ');
									out.write(str + "	");
									
									if (l == 1)
										orderinfo.add(str);
									else {
										if (j == 0) {
											for (String str1 : orderinfo) {
												j++;
												stringtmp=stringtmp+str1;
												String temp = String.valueOf(j);
											}
										}
										j++;
										stringtmp=stringtmp+str;
										String temp = String.valueOf(j);
									}
									
								} else {
									Elements img = td.select("img");
									for (Element img1 : img) {
										str = img1.attr("title");
										out.write(str + "	");
										str = "";
									}
								}
								str = "";
							}
							if(!stringtmp.equals(""))
							{sql = "insert into "+Upload_shop.filename+"(store) values('" + stringtmp
									+ "')";
							
							db.perform(sql);}
							out.write("\r\n");
						}
						if (lceq1 == 2) {
							lceq1 = 0;
							continue;
						}
						out.write("\r\n");
					}
					out.write("\r\n\r\n");
				}
				db.close();
				
			} else {
				str = doc.text();
				amazonflag = false;
				if (str.contains("������ѷ"))
					amazonflag = true;// �ж���������ѷ��վ��
				else 
					amazonflag= false;
				Elements divs = doc
						.select("div:contains(������):matches([0-9]{4}[��|\\-|/][0-9]{1,2}[��|\\-|/][0-9]{1,2}),"
								+ "div:contains(����):contains(�������):matches([0-9]{4}[��|\\-|/][0-9]{1,2}[��|\\-|/][0-9]{1,2})");
				for (Element div : divs) {
					str = div.text();
					String str1 = "�������";
					if (!str.contains(str1))
						str1 = "������";
					// ͳ�ƶ�����/������ų��ֵĴ���
					int count = 0;
					int start = 0;
					while (str.indexOf(str1, start) >= 0
							&& start < str.length()) {
						count++;
						start = str.indexOf(str1, start) + str1.length();
					}
					if (count == 1) {// ѡ�а�������������div
						// a-fixed-left-grid-col a-col-right
						if (amazonflag == true)
							AmazonCrawler(div, out);
						else
							FindMindivs(div, out);
					}
				}
			}
			out.close();

		} catch (FileNotFoundException e) {
			System.out.println("�ļ������ڣ�");
		} catch (IOException e) {
			System.out.println("�������쳣��");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void AmazonCrawler(Element div, FileWriter out) throws Exception {
		// ѡ�񶩵���
		
		DatabaseAccess db = new DatabaseAccess();
		String sql="";
		Upload_shop.filename_amazon = Upload_shop.filenametmp.substring(1,4)+"aaa";
		String newsql = "create table "+Upload_shop.filename_amazon+"(ordernumber varchar(50)," +
				"date varchar(50)," +
				"price varchar(50),buyer varchar(50)," +
				"shipmentStatus varchar(50),name varchar(50)," +
				"author varchar(50),seller varchar(50))";
		
		db.createTable(newsql);
		String ordernumber = div
				.select("div[class=a-fixed-right-grid-col actions a-col-right]")
				.select("div[class=a-row a-size-mini]").text();// ��ȡ������
		out.write(ordernumber + "	");
		String date = div.select("div[class=a-column a-span3]").text();// ��ȡ��������
		out.write(date + "	");
		String price = div.select("div[class=a-column a-span2]").text();
		out.write(price + "	");
		String buyer = div.select(
				"div[class=a-column a-span7 recipient a-span-last]").text();
		out.write(buyer + "	");
		System.out.println(buyer);
		Elements shipment = div
				.select("div[class=a-box shipment shipment-is-delivered]");
		out.write("\r\n");
		for (Element shipment1 : shipment) {// ����һ�������µ�ÿһ������
			String shipmentStatus = shipment1.select(
					"div[style=margin-right:220px; padding-right:6px]").text();
			out.write(shipmentStatus + "	");
			System.out.println(shipmentStatus);
			out.write("\r\n");
			Elements product = shipment1
					.select("div[class=a-fixed-left-grid-col a-col-right]");
			for (Element product1 : product) {
				String name = product1.select("a.a-link-normal").text();
				out.write(name + "	");
				String author = product1.select("span[class=a-size-small]")
						.text();
				out.write(author + "	");
				String seller = product1.select(
						"span[class=a-size-small a-color-secondary]").text();
				out.write(seller + "	");
				System.out.println(Upload_shop.filename_amazon);
				String sql_amazon = "insert into "+Upload_shop.filename_amazon+"(ordernumber,date,price,buyer,shipmentStatus,name,author,seller) values('"
				+ordernumber+"','"+date+"','"+price+"','"+buyer+"','"+shipmentStatus+"','"+name+"','"
				+author+"','"+ seller + "')";
				db.perform(sql_amazon);
				out.write("\r\n");
			}
			out.write("\r\n");
		}
		out.write("\r\n\r\n");
		db.close();
		
	}

	public ArrayList<String> FindMindivs(Element div, FileWriter out)
			throws IOException {
		Elements divs = div.children();
		ArrayList<String> usedstr = new ArrayList<String>();
		String str = null;
		if (divs.size() == 0) {
			str = "";
			return usedstr;
		} else {
			int j = 0;
			for (Element div1 : divs) {
				if (div1.tagName() != "div")
					continue;
				usedstr.addAll(FindMindivs(div1, out));
				str = div1.text();
				for (int i = 0; usedstr != null && i < usedstr.size(); i++) {
					if (usedstr.get(i).equals(" ")) {
						usedstr.remove(i);
						i--;
					}
					str = str.replace(usedstr.get(i), "");
				}
				str = str.replace(space, ' ');
				out.write(str + "	");
				j++;
				String sql = "insert into biao(" + j
						+ ") values('" + str + "')";
				if (str.length() != 0)
					usedstr.add(str);
			}
			out.write("\r\n");
		}
	
		return usedstr;
	}
}