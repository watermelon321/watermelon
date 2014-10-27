package model;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import cn.edu.hfut.dmic.webcollector.crawler.BreadthCrawler;
import cn.edu.hfut.dmic.webcollector.model.Page;

public class FromCMCC extends BreadthCrawler {

	/* visit函数定制访问每个页面时所需进行的操作 */
	@Override
	public void visit(Page page) {
		// String question_regex = "^http://www.zhihu.com/question/[0-9]+";
		try {
			FileWriter out = new FileWriter("RESULT.txt", true);
			// if (Pattern.matches(question_regex, page.getUrl())) {
			// out.write("正在抽取" + page.getUrl());
			/* 抽取标题 */
			// String title = page.getDoc().title();
			// out.write(title+"\r\n");
			/* 抽取提问内容 */
			String baobeiname = page.getDoc().select("div[class=wf_table_wc]")
					.select("table[class=wf_tab3]").select("tbody")
					.text();
			out.write(baobeiname + "\r\n");
			String price = page.getDoc().select("td[class=price]").select("i[class=special-num]").text();
			out.write(price + "\r\n");
			String quantity = page.getDoc().select("td[class=quantity]").text();
			out.write(quantity + "\r\n");
			String date = page.getDoc().select("div[class=summary]")
					.select("span[class=dealtime]").text();
			out.write(date + "\r\n");
			String ordernumber = page.getDoc().select("div[class=summary]")
					.select("span[class=number last-item]").select("em").text();
			out.write(ordernumber + "\r\n");
			// }
			out.close();
		}

		catch (FileNotFoundException e) {
			System.out.println("文件不存在！");
		} catch (IOException e) {
			System.out.println("输入流异常！");
		}

	}

	public static void main(String[] args) throws Exception {
		FromCMCC crawler = new FromCMCC();
		crawler.addSeed("http://acer-pc:8080/MyWeb/upload/baobei.htm");
		crawler.addRegex("http://acer-pc:8080/MyWeb/upload/baobei.htm");
		crawler.start(1);
	}
}