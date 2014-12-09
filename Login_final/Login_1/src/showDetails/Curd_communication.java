package showDetails;

import general_communication.UploadC;

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

public class Curd_communication {
 
 private Connection con;
 private Statement stmt;
 private ResultSet rs;
 private String str1;
 
 private String ordernumber;
 private String date;
 private String pricesum;
 private String baobeiname;
 private String price;
 private String quantity;
 HttpServletRequest request=ServletActionContext.getRequest();
 String Str1 = request.getParameter("str1");
 String Ordernumber = request.getParameter("ordernumber");
 String Date = request.getParameter("date");
 String Pricesum = request.getParameter("pricesum");
 String Baobeiname = request.getParameter("baobeiname");
 String Price = request.getParameter("price");
 //String oldbaobeiname = request.getParameter("oldbaobeiname");
 String Quantity = request.getParameter("quantity");
 /*
  * 获取所有学生信息
  */
 public String getAllCurds() throws Exception {
	  List list = new ArrayList();
	  System.out.println(UploadC.filename);
	  System.out.println(UploadC.filename);
	  System.out.println(UploadC.filename);
	  System.out.println(UploadC.filename);
	  System.out.println(UploadC.filename);
	  String sql = "select * from "+UploadC.filename;
	  System.out.println("-------hello-------");
	  try{
	   rs = executeQuery(sql);
	   while(rs.next()){
	    Curd_communication temp = new Curd_communication();
	    temp.setstr1(rs.getString(1));
	   
	    list.add(temp);
	    //System.out.println(temp.getbaobeiname());
	   }
	  }catch(Exception e){
	   System.out.println(e.toString());
	  }finally{
	   close();
	  }
	  HttpServletRequest request=ServletActionContext.getRequest();
	  request.setAttribute("Curdlist",list);
	  return "success_communication";
	 }
 
 
 
 
 /*
  * 添加学生
  */
 public String add() throws UnsupportedEncodingException{
  String sql = "insert into "+UploadC.filename+"(ordernumber,date,pricesum,baobeiname,price,quantity) values('"+Ordernumber+"','"+Date+"','"+Pricesum+"','"+trans(Baobeiname)+"','"+Price+"','"+Quantity+ "')";
  try{
   executeUpdate(sql);
   getAllCurds();
  }catch(Exception e){
   System.out.println(e.toString());
  }finally{
   close();
  }
  return "success_communication";
 }
 
 /*
  * 删除学生
  */
 public String delete() throws Exception {
	 System.out.println(UploadC.filename);
  String sql = "delete from "+UploadC.filename+" where store='"+trans(Str1)+"'";
  try{
   int n=executeUpdate(sql);
   System.out.println("--------------"+n);
   getAllCurds();
  }catch(Exception e){
   System.out.println(e.toString());
  }finally{
   close();
  }
  return "success_communication";
 }
 
 /*
  * 修改学生
  */
 public String edit()throws Exception{
  //String sql="update "+UploadC.filename+" set ordernumber='"+Ordernumber+"',date='"+Date+"',baobeiname='"+Baobeiname+"',pricesum='"+Pricesum+"',price='"+Price+"',quantity='"+Quantity+"' where baobeiname='"+trans(Baobeiname)+"'";
	 String sql = "delete from "+UploadC.filename+" where baobeiname='"+trans(Baobeiname)+"'";
	 String sql1 = "insert into "+UploadC.filename+"(ordernumber,date,pricesum,baobeiname,price,quantity) values('"+Ordernumber+"','"+Date+"','"+Pricesum+"','"+trans(Baobeiname)+"','"+Price+"','"+Quantity+ "')";
	 
	 try{ 
   executeUpdate(sql);
   executeUpdate(sql1);
   getAllCurds();
  }catch(Exception e){
   System.out.println(e.toString());
  }finally{
   close();
  }
  return "success_communication";
 }
 
 /*
  * 根据学号查询学生
  */
 public String search()throws Exception{
  List list = new ArrayList();
  String sql = "select * from "+UploadC.filename+" where baobeiname='"+trans(Baobeiname)+"'";
  try{
   rs = executeQuery(sql);
   if(rs.next()){
    Curd_communication temp = new Curd_communication();
    temp.setordernumber(rs.getString(1));
    temp.setdate(rs.getString(2));
    temp.setpricesum(rs.getString(3));
    temp.setbaobeiname(rs.getString(4));
    temp.setprice(rs.getString(5));
    temp.setquantity(rs.getString(6));
    list.add(temp);
   }
  }catch(Exception e){
   System.out.println(e.toString());
  }finally{
   close();
  }
  HttpServletRequest request=ServletActionContext.getRequest();
  request.setAttribute("Curdlist",list);
  return "success_communication";
 }
 
 /*
  * 执行更新等操作
  */
 public int executeUpdate(String sql)throws SQLException,ClassNotFoundException{
  return getStatement().executeUpdate(sql);
 }
 
 /*
  * 关闭对象
  */
 public void close(){
  if(rs!=null)
   try{rs.close();}catch(Exception e){}
  if(stmt!=null)
   try{stmt.close();}catch(Exception e){}
  if(con!=null)
   try{con.close();}catch(Exception e){}
 }
 
 /*
  * 执行有结果集返回的查询
  */
 public ResultSet executeQuery(String sql) throws SQLException,ClassNotFoundException{
  return getStatement().executeQuery(sql);
 }
 
 /*
  * 获取语句对象
  */
 public Statement getStatement() throws SQLException,ClassNotFoundException{
  if(stmt==null){
   stmt = getConnection().createStatement();
  }
  return stmt;
 }
 
 /*
  * 获取连接
  */
 public Connection getConnection() throws SQLException,ClassNotFoundException{
  if(con==null){
   Class.forName("com.mysql.jdbc.Driver");
   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Users", "root", "18746073828");
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

 public String getpricesum() {
  return pricesum;
 }

 public void setpricesum(String pricesum) {
  this.pricesum = pricesum;
 }
 public String getbaobeiname() {
	  return baobeiname;
	 }
 
public void setbaobeiname(String baobeiname)  {
	this.baobeiname = baobeiname; 
}
public String getstr1() {
	  return str1;
	 }

	 public void setstr1(String str1) {
	  this.str1 = str1;
	 }

public String trans(String baobeiname) throws UnsupportedEncodingException {
	String baobeiname1 = new String( baobeiname.getBytes("ISO8859-1"),"utf-8"); 
	return baobeiname1;
}

public String getprice() {
	 return price;
}

public void setprice(String price) {
	 this.price = price;
	}
public String getquantity() {
	  return quantity;
	 }

 public void setquantity(String quantity) {
	  this.quantity = quantity;
	 }
 public static void main(String[] args){
  Curd_communication Curd = new Curd_communication();
 }
}
