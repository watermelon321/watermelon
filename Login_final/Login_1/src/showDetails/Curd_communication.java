package showDetails;

import general_communication.UploadC;

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
public class Curd_communication {
 
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
	
	  String sql = "select * from "+UploadC.filename;
	  System.out.println("-------hello-------");
	  try{
	   rs = executeQuery(sql);
	   while(rs.next()){
	    Curd_communication temp = new Curd_communication();
	    temp.setstr1(rs.getString(1));
		temp.setstr2(rs.getString(2));
		temp.setstr3(rs.getString(3));
		temp.setstr4(rs.getString(4));
		temp.setstr5(rs.getString(5));
		temp.setstr6(rs.getString(6));
		temp.setstr7(rs.getString(7));
		temp.setstr8(rs.getString(8));
		temp.setstr9(rs.getString(9));
		temp.setstr10(rs.getString(10));
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
  String sql = "delete from "+UploadC.filename+" where 1aaa='"+trans(Str1)+"'";
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
   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/operation?user=root&password=angel99627");
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
