package model;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import cn.edu.hfut.dmic.webcollector.crawler.BreadthCrawler;
import cn.edu.hfut.dmic.webcollector.model.Page;

public class FromTaobao extends BreadthCrawler {

	/* visit�������Ʒ���ÿ��ҳ��ʱ������еĲ��� */
	@Override
	public void visit(Page page) {
		try {
			FileWriter out = new FileWriter("E://RESULT.txt", true);
			Elements orders = page.getDoc().select("tbody");
			for (Element order : orders) {
				// ��ȡ������
				Elements ordernumber1 = order.select("div[class=summary]")
						.select("span[class=number last-item]").select("em");
				String ordernumber =ordernumber1.text();
				out.write(ordernumber + "\r\n");
				// ��ȡ��������
				Elements date1 = order.select("div[class=summary]").select(
						"span[class=dealtime]");
				String date = date1.text();
				out.write(date + "\r\n");
				// ��ȡ�����ܼ�
				Elements pricesum1 = order.select("p").select(
						"em[class=real-price special-num]");
				String pricesum = pricesum1.text();
				out.write(pricesum + "\r\n");
				Elements baobeis = order.select("tr:has(div[class=desc])");
				// ��ȡÿ����Ʒ������
				for (Element baobei1 : baobeis) {
					String baobeiname =  baobei1
							.select("div[class=desc]")
							.select("p[class=baobei-name]")
							.select("a[data-point-url=http://gm.mmstat.com/listbought.2.6]")
							.text();
					out.write(baobeiname + "\r\n");
					// ��ȡÿ����Ʒ�ļ۸�
					String price = baobei1.select("td[class=price]")
							.select("i[class=special-num]").text();
					out.write(price + "\r\n");
					// ��ȡÿ����Ʒ������
					String quantity = baobei1.select("td[class=quantity]").text();
					out.write(quantity + "\r\n");
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