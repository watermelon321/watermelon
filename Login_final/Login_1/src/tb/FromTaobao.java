package tb;


import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javabean.DatabaseAccess;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cn.edu.hfut.dmic.webcollector.crawler.BreadthCrawler;
import cn.edu.hfut.dmic.webcollector.model.Page;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import login.Login;

public class FromTaobao extends BreadthCrawler {
	DatabaseAccess db = new DatabaseAccess();
	/* visit函数定制访问每个页面时所需进行的操作 */
	@Override
	public void visit(Page page) {
		try {
			FileWriter out = new FileWriter("E://RESULT.txt", true);
			Elements orders = page.getDoc().select("tbody");
			for (Element order : orders) {
				// 读取订单号
				Elements ordernumber1 = order.select("div[class=summary]")
						.select("span[class=number last-item]").select("em");
				String ordernumber =ordernumber1.text();
				out.write(ordernumber + "\r\n");
				// 读取订单日期
				Elements date1 = order.select("div[class=summary]").select(
						"span[class=dealtime]");
				String date = date1.text();
				out.write(date + "\r\n");
				// 读取订单总价
				Elements pricesum1 = order.select("p").select(
						"em[class=real-price special-num]");
				String pricesum = pricesum1.text();
				out.write(pricesum + "\r\n");
				Elements baobeis = order.select("tr:has(div[class=desc])");
				// 读取每件商品的名字
				for (Element baobei1 : baobeis) {
					String baobeiname =  baobei1
							.select("div[class=desc]")
							.select("p[class=baobei-name]")
							.select("a[data-point-url=http://gm.mmstat.com/listbought.2.6]")
							.text();
					//baobeiname=new String(baobeiname.getBytes("utf-8"),"ISO8859-1");
					out.write(baobeiname + "\r\n");
					// 读取每件商品的价格
					String price = baobei1.select("td[class=price]")
							.select("i[class=special-num]").text();
					out.write(price + "\r\n");
					System.out.println(baobeiname+"\n");
					// 读取每件商品的数量
					String quantity = baobei1.select("td[class=quantity]").text();
					out.write(quantity + "\r\n");
					out.write("\r\n");
                    String sql = "insert into "+Login.username+"(tordernumber,tdate,tpricesum,tbaobeiname,tprice,tquantity) values('" + ordernumber + "','" + date + "','" + pricesum + "','" + baobeiname + "','" + price + "','" + quantity  +  "')";
                    //System.out.println(Register.username);
                    		db.perform(sql);
                    	
				}
				
				out.write("\r\n\r\n");
			}
			out.close();
			db.close();
		} catch (FileNotFoundException e) {
			System.out.println("文件不存在！");
		} catch (IOException e) {
			System.out.println("输入流异常！");
		}
	}
	
}