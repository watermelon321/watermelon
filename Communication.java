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

	/* visit函数定制访问每个页面时所需进行的操作 */
	@Override
	public void visit(Page page) {
		DatabaseAccess db = new DatabaseAccess();
		try {
			FileWriter out = new FileWriter("RESULT.txt", false);
			Elements tables = page.getDoc().select("table:matches([0-9]{1,2}[:][0-9]{1,2}[:][0-9]{1,2})");
			String str;
			String sql ="";
			char space = 160;
			int lceq1 = 0;// 行列数是否都等于1，lceq1=1表示行等于1，lceq1=2表示行列数都等于1
			for (Element table : tables) {
				Elements tbodys = table.select("tbody");
				for (Element tbody : tbodys) {
					Elements trs = tbody.select("tr");
					if (trs.size() == 1)
						lceq1 = 1;
					for (Element tr : trs) {
						String stringtmp = "";
						int j=0;
						Elements tds = tr.select("td");
						if(tr.text().contains("合计"))
							continue;
						if (tds.size() == 1 && lceq1 == 1) {
							lceq1 = 2;
							break;
						}
						for (Element td : tds) {
							str = td.text();
							if(str.contains("计入账单"))
								continue;
							str = str.replace(space, ' ');
							out.write(str + "	");
							j++;
							//stringtmp=stringtmp+str1;
							String temp = String.valueOf(j);
							temp+="aaa";
							if(j==1){
								stringtmp=str;
								sql = "insert into "+UploadC.filename+"("+temp+") values('" + str
									+ "')";}
							
							else sql = "update "+UploadC.filename+" set "+temp+"='" + str
									+ "' where 1aaa='"
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
			System.out.println("文件不存在！");
		} catch (IOException e) {
			System.out.println("输入流异常！");
		}
	}
}
