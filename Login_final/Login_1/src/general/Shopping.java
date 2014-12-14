package general;

import general_communication.UploadC;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javabean.DatabaseAccess;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cn.edu.hfut.dmic.webcollector.crawler.BreadthCrawler;
import cn.edu.hfut.dmic.webcollector.model.Page;

public class Shopping extends BreadthCrawler {
	char space = 160;
	int j = 1;
	int dbline = 0;

	/* visit函数定制访问每个页面时所需进行的操作 */
	@Override
	public void visit(Page page) {
		try {
			DatabaseAccess db = new DatabaseAccess();
			FileWriter out = new FileWriter("D://RESULT.txt", false);
			String str = "";
			String sql = "";
			boolean divvalid = false;// div标签是否有效
			int lceq1 = 0;// 行列数是否都等于1，lceq1=1表示行等于1，lceq1=2表示行列数都等于1

			Document doc = page.getDoc();
			Elements tables = doc
					.select("table:contains(订单号),table:contains(订单编号)");
			boolean jdflag = false;// 商品名是像京东一样是图片格式时
			if (tables.size() != 0 && !tables.text().contains("交易号"))// 有table标签的订单表格
			{
				for (Element table : tables) {
					lceq1 = 0;
					Elements tbodys = table.select("tbody");
					ArrayList<String> orderinfo = null;// 共有的订单信息，如订单号、订单日期
					ArrayList<String> commodityinfo = null;// 每个商品自己的信息
					ArrayList<String> jdcommodityname = null;// 当商品名是京东的图片格式时
					for (Element tbody : tbodys) {
						int l = 0;// 记录是每个订单的第几行，从1开始
						if (tbody.hasClass("order-status"))// 过滤不存数tbody
							continue;
						Elements trs = tbody.select("tr");
						if (trs.size() == 1)
							lceq1 = 1;
						for (Element tr : trs) {
							if (tr.text().contains("订单号")
									|| tr.text().contains("订单编号")) {
								orderinfo = new ArrayList<String>();
								commodityinfo = new ArrayList<String>();
								jdcommodityname = new ArrayList<String>();
								l = 0;

							} else
								j = 1;
							l++;
							Elements tds = tr.select("td");
							if (tds.size() == 1 && lceq1 == 1) {
								lceq1 = 2;
								break;
							}
							int tdindex = -1;// 记录是第几个td，从0开始
							for (Element td : tds) {
								tdindex++;
								// 如果td中有span，只把共有订单信息的td用span分开
								Elements spans = td.select("span");
								if (l == 1 && spans.size() != 0) {
									for (Element span : spans) {
										str = span.text();
										if (str.length() != 0) {
											str = str.replace(space, ' ');
											if (str.contains("查看")
													|| str.contains("评论")
													|| str.contains("详情")
													|| str.contains("售后")
													|| str.contains("电器城服务台")
													|| str.contains("失效")
													|| str.contains("分享")
													|| str.contains("删除")
													|| str.contains("投诉")
													|| str.contains("旺旺")
													|| str.contains("退货")
													|| str.contains("退换货"))
												continue;
											orderinfo.add(str);
										}
									}
									str = td.text();
									str = str.replace(" ", "");
									for (String str1 : orderinfo) {
										str = str.replace(str1, "");
									}
									if (!str.contains("旺旺"))
										orderinfo.add(str);
								} else
									str = td.text();
								if (str.contains("查看") || str.contains("评论")
										|| str.contains("详情")
										|| str.contains("售后")
										|| str.contains("电器城服务台")
										|| str.contains("失效")
										|| str.contains("分享")
										|| str.contains("删除")
										|| str.contains("投诉")
										|| str.contains("旺旺")
										|| str.contains("退货")
										|| str.contains("退换货"))
									continue;
								if (str.length() != 0) {
									str = str.replace(space, ' ');
									if (l == 1 && spans.size() == 0) {
										orderinfo.add(str);
									} else if (l == 2) {
										commodityinfo.add(str);
									} else if (l > 2) {
										commodityinfo.set(tdindex, str);
									}
								} else {
									Elements img = td.select("img");
									if (img.size() == 1) {
										for (Element img1 : img) {
											str = img1.attr("title");
											if (l == 2) {
												commodityinfo.add(str);
											} else if (l > 2) {
												commodityinfo.set(tdindex, str);
											}
											str = "";
										}
									} else if (img.size() > 1) {// 处理京东一类
										jdflag = true;
										for (Element img1 : img) {
											str = img1.attr("title");
											if (l >= 2) {
												jdcommodityname.add(str);
											}
											str = "";
										}
									}
								}
								str = "";
							}
							if (jdflag == true) {
								if (l > 1) {
									
									for (String str1 : jdcommodityname) {
										dbline++;
										if (j == 1) {
											sql = "insert into "
													+ Upload_shop.newnametmp
													+ "(1aaa) values('"
													+ String.valueOf(dbline)
													+ "')";
											db.perform(sql);
										}
										for (String str2 : orderinfo) {
											if (str2.length() > 0) {
												j++;
												String temp = String.valueOf(j);
												temp += "aaa";
												out.write(str2 + "	");
												sql = "update "
														+ Upload_shop.newnametmp
														+ " set "
														+ temp
														+ "='"
														+ str2
														+ "' where 1aaa='"
														+ String.valueOf(dbline)
														+ "'";
												db.perform(sql);
											}
										}
										if (str1.length() > 0) {
											j++;
											String temp = String.valueOf(j);
											temp += "aaa";
											out.write(str1 + "	");
											sql = "update "
													+ Upload_shop.newnametmp
													+ " set " + temp + "='"
													+ str1 + "' where 1aaa='"
													+ String.valueOf(dbline)
													+ "'";
											db.perform(sql);
										}
										for (String str2 : commodityinfo) {
											if (str2.length() > 0) {
												j++;
												String temp = String.valueOf(j);
												temp += "aaa";
												out.write(str2 + "	");
												sql = "update "
														+ Upload_shop.newnametmp
														+ " set "
														+ temp
														+ "='"
														+ str2
														+ "' where 1aaa='"
														+ String.valueOf(dbline)
														+ "'";
												db.perform(sql);
											}
										}
										out.write("\r\n");
									}
									jdflag = false;
								}
								db.close();
							} else {
								if (l > 1) {
									dbline++;
									if (j == 1) {
										sql = "insert into "
												+ Upload_shop.newnametmp
												+ "(1aaa) values('"
												+ String.valueOf(dbline) + "')";
										db.perform(sql);
									}
									for (String str1 : orderinfo) {
										if (str1.length() > 0) {
											j++;
											String temp = String.valueOf(j);
											temp += "aaa";
											out.write(str1 + "	");
											sql = "update "
													+ Upload_shop.newnametmp
													+ " set " + temp + "='"
													+ str1+ "' where 1aaa='"
													+ String.valueOf(dbline)
													+ "'";
											db.perform(sql);
										}
									}
									for (String str1 : commodityinfo) {
										if (str1.length() > 0) {
											j++;
											String temp = String.valueOf(j);
											temp += "aaa";
											out.write(str1 + "	");
											sql = "update "
													+ Upload_shop.newnametmp
													+ " set " + temp + "='"
													+ str1 + "' where 1aaa='"
													+ String.valueOf(dbline)
													+ "'";
											db.perform(sql);
										}
									}
								}
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
			} else {
				str = doc.text();
				boolean amazonflag = false;
				if (str.contains("的亚马逊"))
					amazonflag = true;// 判断是在亚马逊网站下
				Elements divs = doc
						.select("div:contains(查看):contains(订单号):matches([0-9]{4}[年|\\-|/][0-9]{1,2}[月|\\-|/][0-9]{1,2}),"
								+ "div:contains(卖家):contains(订单编号):matches([0-9]{4}[年|\\-|/][0-9]{1,2}[月|\\-|/][0-9]{1,2})");
				if (divs.size() != 0) {
					for (Element div : divs) {
						str = div.text();
						String str1 = "订单编号";
						dbline = 0;
						if (!str.contains(str1))
							str1 = "订单号";
						// 统计订单号/订单编号出现的次数
						int count = 0;
						int start = 0;
						while (str.indexOf(str1, start) >= 0
								&& start < str.length()) {
							count++;
							start = str.indexOf(str1, start) + str1.length();
						}
						if (count == 1) {// 选中包含整个订单的div
							// a-fixed-left-grid-col a-col-right
							divvalid = true;
							j = 1;
							dbline++;
							if (amazonflag == true)
								AmazonCrawler(div, out);
							else
								FindMindivs(div, out);// 抽取嵌套的div标签中的内容
							Elements divtables = div.select("table");// 订单的div标签中含有table标签
							if (divtables.size() > 0) {
								for (Element table : divtables) {
									Elements tbodys = table.select("tbody");
									for (Element tbody : tbodys) {
										if (tbody.hasClass("order-status"))// 过滤不存数tbody
											continue;
										Elements trs = tbody.select("tr");
										for (Element tr : trs) {
											Elements tds = tr.select("td");
											for (Element td : tds) {
												str = td.text();
												if (str.contains("查看")
														|| str.contains("评论")
														|| str.contains("详情")
														|| str.contains("售后")
														|| str.contains("电器城服务台")
														|| str.contains("失效")
														|| str.contains("分享")
														|| str.contains("删除")
														|| str.contains("投诉")
														|| str.contains("旺旺"))
													continue;
												if (str.length() != 0) {
													str = str.replace(space,
															' ');
													j++;
													String temp = String
															.valueOf(j);
													temp += "aaa";
													out.write(str + "	");
													sql = "update "
															+ Upload_shop.newnametmp
															+ " set "
															+ temp
															+ "='"
															+ str
															+ "' where 1aaa='"
															+ String.valueOf(dbline)
															+ "'";
													db.perform(sql);
												} else {
													Elements img = td
															.select("img");
													for (Element img1 : img) {
														str = img1
																.attr("title");
														j++;
														String temp = String
																.valueOf(j);
														temp += "aaa";
														out.write(str + "	");
														sql = "update "
																+ Upload_shop.newnametmp
																+ " set "
																+ temp
																+ "='"
																+ str
																+ "' where 1aaa='"
																+ String.valueOf(dbline)
																+ "'";
														db.perform(sql);
														str = "";
													}
												}
												str = "";
											}
											out.write("\r\n");
										}
										out.write("\r\n");
									}
								}
							}
						}
					}
				}

				if (divvalid == false) {
					tables = doc.select("table");
					if (tables.size() != 0)// 有table标签的订单表格
					{
						for (Element table : tables) {
							Elements tbodys = table.select("tbody");
							for (Element tbody : tbodys) {
								dbline = 0;
								if (tbody.hasClass("order-status"))// 过滤不存数tbody
									continue;
								Elements trs = tbody.select("tr");
								if (trs.size() == 1)
									lceq1 = 1;
								for (Element tr : trs) {
									dbline++;
									j = 1;
									Elements tds = tr.select("td");
									if (tds.size() == 1 && lceq1 == 1) {
										lceq1 = 2;
										break;
									}
									for (Element td : tds) {
										str = td.text();
										if (str.contains("查看")
												|| str.contains("评论")
												|| str.contains("详情")
												|| str.contains("售后")
												|| str.contains("电器城服务台")
												|| str.contains("失效")
												|| str.contains("分享")
												|| str.contains("删除")
												|| str.contains("投诉")
												|| str.contains("旺旺"))
											continue;
										if (str.length() != 0) {
											str = str.replace(space, ' ');
											if (j == 1) {
												sql = "insert into "
														+ Upload_shop.newnametmp
														+ "(1aaa) values('"
														+ String.valueOf(dbline)
														+ "')";
												db.perform(sql);
											}
											out.write(str + "	");
											j++;
											String temp = String.valueOf(j);
											temp += "aaa";
											out.write(str + "	");
											sql = "update "
													+ Upload_shop.newnametmp
													+ " set "
													+ temp
													+ "='"
													+ str
													+ "' where 1aaa='"
													+ String.valueOf(dbline)
													+ "'";
											db.perform(sql);
										} else {
											Elements img = td.select("img");
											for (Element img1 : img) {
												str = img1.attr("title");
												out.write(str + "	");
												j++;
												String temp = String.valueOf(j);
												temp += "aaa";
												out.write(str + "	");
												sql = "update "
														+ Upload_shop.newnametmp
														+ " set "
														+ temp
														+ "='"
														+ str
														+ "' where 1aaa='"
														+ String.valueOf(dbline)
														+ "'";
												db.perform(sql);
												str = "";
											}
										}
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
					}
				}

			}
			db.close();
			out.close();
		} catch (FileNotFoundException e) {
			System.out.println("文件不存在！");
		} catch (IOException e) {
			System.out.println("输入流异常！");
		}
	}

	private void AmazonCrawler(Element div, FileWriter out) throws IOException {
		// 选择订单号
		DatabaseAccess db = new DatabaseAccess();
		String ordernumber = div
				.select("div[class=a-fixed-right-grid-col actions a-col-right]")
				.select("div[class=a-row a-size-mini]").text();// 抽取订单号
		out.write(ordernumber + "	");
		System.out.println(ordernumber);
		String date = div.select("div[class=a-column a-span3]").text();// 抽取订单日期
		out.write(date + "	");
		String price = div.select("div[class=a-column a-span2]").text();
		out.write(price + "	");
		String buyer = div.select(
				"div[class=a-column a-span7 recipient a-span-last]").text();
		out.write(buyer + "	");
		Elements shipment = div
				.select("div[class=a-box shipment shipment-is-delivered]");
		out.write("\r\n");
		for (Element shipment1 : shipment) {// 对于一个订单下的每一次配送
			String shipmentStatus = shipment1.select(
					"div[style=margin-right:220px; padding-right:6px]").text();
			out.write(shipmentStatus + "	");
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
				String sql_amazon = "insert into " + Upload_shop.newnametmp
						+ "(1aaa,2aaa,3aaa,4aaa,5aaa,6aaa,7aaa,8aaa) values('"
						+ ordernumber + "','" + date + "','" + price + "','"
						+ buyer + "','" + shipmentStatus + "','" + name + "','"
						+ author + "','" + seller + "')";
				db.perform(sql_amazon);
				out.write("\r\n");
			}
			out.write("\r\n");
		}
		out.write("\r\n\r\n");
	}

	public ArrayList<String> FindMindivs(Element div, FileWriter out)
			throws IOException {
		Elements divs = div.children();
		DatabaseAccess db = new DatabaseAccess();
		String sql = "";
		ArrayList<String> usedstr = new ArrayList<String>();
		String str = null;
		if (divs.size() == 0) {
			str = "";
			return usedstr;
		} else {
			for (Element div1 : divs) {
				String stringtmp = "";
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
				if (!(str.contains("查看") || str.contains("评论")
						|| str.contains("详情") || str.contains("售后")
						|| str.contains("电器城服务台") || str.contains("失效")
						|| str.contains("分享") || str.contains("删除")
						|| str.contains("投诉") || str.contains("旺旺")
						|| str.contains("退货") || str.contains("退换货")))
					out.write(str + "	");
				str = str.replace(space, ' ');
				if (j == 1) {
					sql = "insert into " + Upload_shop.newnametmp
							+ "(1aaa) values('" + String.valueOf(dbline) + "')";
					db.perform(sql);
					j++;
					String temp = String.valueOf(j);
					temp += "aaa";
					out.write(str + "	");
					sql = "update " + Upload_shop.newnametmp + " set " + temp
							+ "='" + str + "' where 1aaa='"
							+ String.valueOf(dbline) + "'";
					db.perform(sql);
				}
				j++;
				String temp = String.valueOf(j);
				temp += "aaa";
				out.write(str + "	");
				sql = "update " + Upload_shop.newnametmp + " set " + temp
						+ "='" + str + "' where 1aaa='"
						+ String.valueOf(dbline) + "'";
				db.perform(sql);
				if (str.length() != 0)
					usedstr.add(str);
			}
			out.write("\r\n");

		}
		return usedstr;
	}
}