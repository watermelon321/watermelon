package general_score;

import general.Upload_shop;
import general_score.UploadS;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javabean.DatabaseAccess;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cn.edu.hfut.dmic.webcollector.crawler.BreadthCrawler;
import cn.edu.hfut.dmic.webcollector.model.Page;

public class Score extends BreadthCrawler {

	/* visit�������Ʒ���ÿ��ҳ��ʱ������еĲ��� */
	@Override
	public void visit(Page page) {
		DatabaseAccess db = new DatabaseAccess();
		try {
			FileWriter out = new FileWriter("RESULT.txt", false);
			Elements tables = page.getDoc().select("table:matches([0-9]{4})");
			String str;
			char space = 160;
			int lceq1 = 0;// �������Ƿ񶼵���1��lceq1=1��ʾ�е���1��lceq1=2��ʾ������������1
			String sql="";
			for (Element table : tables) {
				Elements tbodys = table.select("tbody");
				for (Element tbody : tbodys) {
					Elements trs = tbody.select("tr");
					if (trs.size() == 1)
						lceq1 = 1;
					for (Element tr : trs) {
						String stringtmp = "";
						int j = 0;
						Elements tds = tr.select("td");
						if (tds.size() == 1 && lceq1 == 1) {
							lceq1 = 2;
							break;
						}
						for (Element td : tds) {
							str = td.text();
							str = str.replace(space, ' ');
							out.write(str + "	");
							j++;
							//stringtmp=stringtmp+str1;
							String temp = String.valueOf(j);
							temp+="aaa";
							/*if(j==1){
								stringtmp=str;
								sql = "insert into "+UploadS.filename+"("+temp+") values('" + str
									+ "')";}
							else*/
							if(j==2){stringtmp=str;
							sql = "insert into "+UploadS.filename+"("+temp+") values('" + str
									+ "')";}
							
							else sql = "update "+UploadS.filename+" set "+temp+"='" + str
									+ "' where 2aaa='"
											+ stringtmp + "'";
							//UPDATE `operation`.`curd` SET `baobeiname`='as' WHERE `ordernumber`='23';
							db.perform(sql);
							str = "";
						}
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
	
}