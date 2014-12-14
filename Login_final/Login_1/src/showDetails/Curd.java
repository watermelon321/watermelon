package showDetails;

import general.Upload_shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import login.Login;

public class Curd {

	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	private String str1;
	private String str2;
	private String str3;
	private String str4;
	private String str5;
	private String str6;
	private String str7;
	private String str8;
	private String str9;
	private String str10;
	private String str11;
	private String str12;
	private int judg;
	private int judge;
	private String ordernumber;
	private String date;
	private String price;
	private String name;
	private String author;
	private String buyer;
	private String seller;
	private String shipmentStatus;

	private String tordernumber;
	private String tdate;
	private String tpricesum;
	private String tbaobeiname;
	private String tprice;
	private String tquantity;

	HttpServletRequest request = ServletActionContext.getRequest();
	String Str1 = request.getParameter("str1");
	String Name = request.getParameter("name");
	String Date = request.getParameter("date");
	String Pricesum = request.getParameter("pricesum");
	String Baobeiname = request.getParameter("tbaobeiname");
	String Price = request.getParameter("price");
	// String oldbaobeiname = request.getParameter("oldbaobeiname");
	String Quantity = request.getParameter("quantity");

	/*
	 * 获取所有学生信息
	 */
	public String getAllCurd() throws Exception {//淘宝的输出
		List list = new ArrayList();
		String sql = "select * from " + Login.username;
		// System.out.println("-------hello-------");
		try {
			rs = executeQuery(sql);
			while (rs.next()) {
				Curd temp = new Curd();
				temp.settordernumber(rs.getString(1));
				temp.settdate(rs.getString(2));
				temp.settpricesum(rs.getString(3));
				temp.settbaobeiname(rs.getString(4));
				temp.settprice(rs.getString(5));
				temp.settquantity(rs.getString(6));
				list.add(temp);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			close();
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("Curdlist", list);
		return "success";
	}

	public String getAllCurds() throws Exception {//shopping_list的输出
		List list = new ArrayList();
		judge=0;
		// System.out.println(Upload_shop.filename);
		String sql = "select * from " + Upload_shop.newnametmp;
		System.out.println("-------111hello-------");
		try {
			rs = executeQuery(sql);
			while (rs.next()) {judg=0;
				Curd temp = new Curd();
			    String STR=rs.getString(1);
				if(STR!=null&&!STR.equals("col"))judg++;
				temp.setstr1(STR);
				if(rs.getString(2)!=null&&!STR.equals("col1"))judg++;
				temp.setstr2(rs.getString(2));
				if(rs.getString(3)!=null&&!STR.equals("col1"))judg++;
				temp.setstr3(rs.getString(3));
				if(rs.getString(4)!=null&&!STR.equals("col1"))judg++;
				temp.setstr4(rs.getString(4));
				if(rs.getString(5)!=null&&!STR.equals("col1"))judg++;
				temp.setstr5(rs.getString(5));
				if(rs.getString(6)!=null&&!STR.equals("col1"))judg++;
				temp.setstr6(rs.getString(6));
				if(rs.getString(7)!=null&&!STR.equals("col1"))judg++;
				temp.setstr7(rs.getString(7));
				if(rs.getString(8)!=null&&!STR.equals("col1"))judg++;
			    temp.setstr8(rs.getString(8));
				if(rs.getString(9)!=null&&!STR.equals("col1"))judg++;
				temp.setstr9(rs.getString(9));
				if(rs.getString(10)!=null&&!STR.equals("col1"))judg++;
				temp.setstr10(rs.getString(10));
				if(rs.getString(11)!=null&&!STR.equals("col1"))judg++;
				temp.setstr11(rs.getString(11));
				if(rs.getString(12)!=null&&!STR.equals("col1"))judg++;
				temp.setstr12(rs.getString(12));
				list.add(temp);
				if(judge<judg)judge=judg;
				
			}
			} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			close();
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("judge", judge);
		request.setAttribute("Curdlist", list);System.out.println("=================="+judge);
		return "success";
	}

	public String getAllCurds1() throws Exception {//亚马逊的输出
		List list = new ArrayList();
		String sql = "select * from " + Upload_shop.newnametmp;
		System.out.println("-------hello-------");
		try {
			rs = executeQuery(sql);
			while (rs.next()) {
				Curd temp = new Curd();
				temp.setordernumber(rs.getString(1));
				temp.setdate(rs.getString(2));
				temp.setprice(rs.getString(3));
				temp.setbuyer(rs.getString(4));
				temp.setshipmentStatus(rs.getString(5));
				temp.setname(rs.getString(6));
				temp.setauthor(rs.getString(7));
				temp.setseller(rs.getString(8));
				list.add(temp);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			close();
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("Curdlist", list);
		return "success_amazon";
	}

	
	
	
	
	/*
	 * 添加学生
	 */
	public String add() throws UnsupportedEncodingException {
		String sql = "insert into "
				+ Upload_shop.newnametmp
				+ "(ordernumber,date,pricesum,baobeiname,price,quantity) values('"
				+ ordernumber + "','" + Date + "','" + Pricesum + "','"
				+ trans(Baobeiname) + "','" + Price + "','" + Quantity + "')";
		try {
			executeUpdate(sql);
			getAllCurds();
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			close();
		}
		return "success";
	}

	
	public String delete_col() throws Exception {//删除列
		String sql = "select * from " + Upload_shop.newnametmp;
		
		
		//alter table 表名 drop column 列名;
		String tmp="";
		try {
			//int n = executeUpdate(sql);
			tmp=Str1.replace("col", "");
			String col_name=tmp+"aaa";
			System.out.println("--------------" + col_name);
		    String sql1 = "alter table " + Upload_shop.newnametmp + " drop column "+col_name;
		    executeUpdate(sql1);
			getAllCurds();
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			close();
		}
		return "success";
	}
	
	public String delete() throws Exception {//删除shopping_list
		String sql = "delete from " + Upload_shop.newnametmp + " where 1aaa='"
				+ trans(Str1) + "'";
		try {
			int n = executeUpdate(sql);
			System.out.println("--------------" + n);
			getAllCurds();
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			close();
		}
		return "success";
	}
	public String delete_amazon() throws Exception {//删除亚马逊
		String sql = "delete from " + Upload_shop.newnametmp + " where name='"
				+ trans(Name) + "'";
		try {
			int n = executeUpdate(sql);
			System.out.println("--------------" + n);
			getAllCurds1();
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			close();
		}
		return "success";
	}

	public String delete1() throws Exception {//删除淘宝
		String sql = "delete from " + Login.username + " where tbaobeiname='"
				+ trans(Baobeiname) + "'";
		try {
			int n = executeUpdate(sql);
			System.out.println("--------------" + n);
			getAllCurd();
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			close();
		}
		return "success";
	}

	/*
	 * 修改学生
	 */
	public String edit() throws Exception {
		// String
		// sql="update "+Upload_shop.filename+" set ordernumber='"+Ordernumber+"',date='"+Date+"',baobeiname='"+Baobeiname+"',pricesum='"+Pricesum+"',price='"+Price+"',quantity='"+Quantity+"' where baobeiname='"+trans(Baobeiname)+"'";
		String sql = "delete from " + Upload_shop.newnametmp
				+ " where baobeiname='" + trans(Baobeiname) + "'";
		String sql1 = "insert into "
				+ Upload_shop.filename
				+ "(ordernumber,date,pricesum,baobeiname,price,quantity) values('"
				+ ordernumber + "','" + Date + "','" + Pricesum + "','"
				+ trans(Baobeiname) + "','" + Price + "','" + Quantity + "')";

		try {
			executeUpdate(sql);
			executeUpdate(sql1);
			getAllCurds();
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			close();
		}
		return "success";
	}

	/*
	 * 根据学号查询学生
	 */
	public String search() throws Exception {
		List list = new ArrayList();
		String sql = "select * from " + Upload_shop.newnametmp
				+ " where baobeiname='" + trans(Baobeiname) + "'";
		try {
			rs = executeQuery(sql);
			if (rs.next()) {
				Curd temp = new Curd();
				temp.setordernumber(rs.getString(1));
				temp.setdate(rs.getString(2));
				temp.setprice(rs.getString(3));
				temp.setname(rs.getString(4));
				temp.setprice(rs.getString(5));
				temp.setquantity(rs.getString(6));
				list.add(temp);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			close();
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("Curdlist", list);
		return "success";
	}

	void setquantity(String string) {
		// TODO Auto-generated method stub

	}

	/*
	 * 执行更新等操作
	 */
	public int executeUpdate(String sql) throws SQLException,
			ClassNotFoundException {
		return getStatement().executeUpdate(sql);
	}

	/*
	 * 关闭对象
	 */
	public void close() {
		if (rs != null)
			try {
				rs.close();
			} catch (Exception e) {
			}
		if (stmt != null)
			try {
				stmt.close();
			} catch (Exception e) {
			}
		if (con != null)
			try {
				con.close();
			} catch (Exception e) {
			}
	}

	/*
	 * 执行有结果集返回的查询
	 */
	public ResultSet executeQuery(String sql) throws SQLException,
			ClassNotFoundException {
		return getStatement().executeQuery(sql);
	}
	

	/*
	 * 获取语句对象
	 */
	public Statement getStatement() throws SQLException, ClassNotFoundException {
		if (stmt == null) {
			stmt = getConnection().createStatement();
		}
		return stmt;
	}

	/*
	 * 获取连接
	 */
	public Connection getConnection() throws SQLException,
			ClassNotFoundException {
		if (con == null) {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/"+Login.username+"?user=root&password=angel99627");
		}
		return con;
	}

	public String getordernumber() {
		return ordernumber;
	}

	public void setordernumber(String ordernumber) {
		this.ordernumber = ordernumber;
	}

	public String getdate() {
		return date;
	}

	public void setdate(String date) {
		this.date = date;
	}

	public String getprice() {
		return price;
	}

	public void setprice(String price) {
		this.price = price;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getstr1() {
		return str1;
	}

	public void setstr1(String str1) {
		this.str1 = str1;
	}
	public String getstr2() {
		return str2;
	}

	public void setstr2(String str2) {
		this.str2 = str2;
	}
	public String getstr3() {
		return str3;
	}

	public void setstr3(String str3) {
		this.str3 = str3;
	}
	public String getstr4() {
		return str4;
	}

	public void setstr4(String str4) {
		this.str4 = str4;
	}
	public String getstr5() {
		return str5;
	}

	public void setstr5(String str5) {
		this.str5 = str5;
	}
	public String getstr6() {
		return str6;
	}

	public void setstr6(String str6) {
		this.str6 = str6;
	}
	public String getstr7() {
		return str7;
	}

	public void setstr7(String str7) {
		this.str7 = str7;
	}
	public String getstr8() {
		return str8;
	}

	public void setstr8(String str8) {
		this.str8 = str8;
	}
	public String getstr9() {
		return str9;
	}

	public void setstr9(String str9) {
		this.str9 = str9;
	}
	public String getstr10() {
		return str10;
	}

	public void setstr10(String str10) {
		this.str10 = str10;
	}
	public String getstr11() {
		return str11;
	}

	public void setstr11(String str11) {
		this.str11 = str11;
	}
	public String getstr12() {
		return str12;
	}

	public void setstr12(String str12) {
		this.str12 = str12;
	}

	public String trans(String baobeiname) throws UnsupportedEncodingException {
		String baobeiname1 = new String(baobeiname.getBytes("ISO8859-1"),
				"utf-8");
		return baobeiname1;
	}

	public String getshipmentStatus() {
		return shipmentStatus;
	}

	public void setshipmentStatus(String shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}

	public String getseller() {
		return seller;
	}

	public void setbuyer(String buyer) {
		this.buyer = buyer;
	}

	public String getbuyer() {
		return buyer;
	}

	public void setauthor(String author) {
		this.author = author;
	}

	public String getauthor() {
		return author;
	}

	public void setseller(String seller) {
		this.seller = seller;
	}

	public String gettordernumber() {
		return tordernumber;
	}

	public void settordernumber(String tordernumber) {
		this.tordernumber = tordernumber;
	}

	public String gettdate() {
		return tdate;
	}

	public void settdate(String tdate) {
		this.tdate = tdate;
	}

	public String gettpricesum() {
		return tpricesum;
	}

	public void settpricesum(String tpricesum) {
		this.tpricesum = tpricesum;
	}

	public String gettbaobeiname() {
		return tbaobeiname;
	}

	public void settbaobeiname(String tbaobeiname) {
		this.tbaobeiname = tbaobeiname;
	}

	public String gettprice() {
		return tprice;
	}

	public void settprice(String tprice) {
		this.tprice = tprice;
	}

	public String gettquantity() {
		return tquantity;
	}

	public void settquantity(String tquantity) {
		this.tquantity = tquantity;
	}

	public static void main(String[] args) {
		Curd Curd = new Curd();
	}
}
