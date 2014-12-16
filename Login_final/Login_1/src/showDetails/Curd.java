package showDetails;

import general.Upload_shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.ServletActionContext;

import tb.UploadAction;

import login.Login;

import javax.servlet.ServletException;

public class Curd {

	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	private String str1;

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
	public String getAllCurd() throws Exception {
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

	public String getAllCurds() throws Exception {
		List list = new ArrayList();
		// System.out.println(Upload_shop.filename);
		String sql = "select * from " + Upload_shop.filename;
		System.out.println("-------111hello-------");
		try {
			rs = executeQuery(sql);
			while (rs.next()) {
				Curd temp = new Curd();
				temp.setstr1(rs.getString(1));
				list.add(temp);
				// System.out.println(temp.getbaobeiname());
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

	public String getAllCurds1() throws Exception {
		List list = new ArrayList();
		String sql = "select * from " + Upload_shop.filename_amazon;
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
				+ Upload_shop.filename
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

	/*
	 * 删除学生
	 */
	public String delete() throws Exception {
		String sql = "delete from " + Upload_shop.filename + " where store='"
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
	public String delete_amazon() throws Exception {
		String sql = "delete from " + Upload_shop.filename_amazon + " where name='"
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

	public String delete1() throws Exception {
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
		String sql = "delete from " + Upload_shop.filename
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
		String sql = "select * from " + Upload_shop.filename
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
					"jdbc:mysql://localhost:3306/Users", "root", "18746073828");
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
