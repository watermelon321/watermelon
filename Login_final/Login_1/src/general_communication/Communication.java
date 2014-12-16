package general_communication;

import general_communication.UploadC;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javabean.DatabaseAccess;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cn.edu.hfut.dmic.webcollector.crawler.BreadthCrawler;
import cn.edu.hfut.dmic.webcollector.model.Page;

public class Communication extends BreadthCrawler {

	/* visit�������Ʒ���ÿ��ҳ��ʱ������еĲ��� */
	@Override
	public void visit(Page page) {
		DatabaseAccess db = new DatabaseAccess();
		try {
			FileWriter out = new FileWriter("RESULT.txt", false);
			Elements tables = page.getDoc().select("table:matches([0-9]{1,2}[:][0-9]{1,2}[:][0-9]{1,2})");
			String str;
			String sql ="";
			char space = 160;
			int lceq1 = 0;// �������Ƿ񶼵���1��lceq1=1��ʾ�е���1��lceq1=2��ʾ������������1
			for (Element table : tables) {
				Elements tbodys = table.select("tbody");
				for (Element tbody : tbodys) {
					Elements trs = tbody.select("tr");
					if (trs.size() == 1)
						lceq1 = 1;
					for (Element tr : trs) {
						String stringtmp = "";
						Elements tds = tr.select("td");
						if(tr.text().contains("�ϼ�"))
							continue;
						if (tds.size() == 1 && lceq1 == 1) {
							lceq1 = 2;
							break;
						}
						for (Element td : tds) {
							str = td.text();
							if(str.contains("�����˵�"))
								continue;
							str = str.replace(space, ' ');
							out.write(str + "	");
							stringtmp=stringtmp+str;
							str = "";
						}
						if(!stringtmp.equals(""))
						{sql = "insert into "+UploadC.filename+"(store) values('" + stringtmp
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
			out.close();
		} catch (FileNotFoundException e) {
			System.out.println("�ļ������ڣ�");
		} catch (IOException e) {
			System.out.println("�������쳣��");
		}
	}
	public static void main(String[] args) throws Exception {
		Communication crawler = new Communication();
		crawler.addSeed("http://acer-pc:8080/MyWeb/upload/CMCC_speaking.htm");
		crawler.addRegex("http://acer-pc:8080/MyWeb/upload/CMCC_speaking.htm");
		crawler.start(1);
	}
}