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
	private String str13;
	private String str14;
	private String str15;
	private int judg;
	static private int judge;
	
    static public String historyname;
	HttpServletRequest request = ServletActionContext.getRequest();
	String Str1 = request.getParameter("str1");
	String search = request.getParameter("searchname");
	public String search_history() throws Exception {
		String sql = "select * from "+Login.username+"history where Chinese='" + trans(Str1) + "'";
		try {
			rs = executeQuery(sql);
			rs.next();
			historyname=rs.getString(1);
			getAllCurd(historyname);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			close();
		}
		
		return "success";
	}
	
	public String getAllHistory() throws Exception {//history的输出表名
		List list = new ArrayList();
		String sql = "select * from "+Login.username+"history";
		// System.out.println("-------hello-------");
		try {
			rs = executeQuery(sql);
			while (rs.next()) {
				Curd temp = new Curd();
				temp.setstr1(rs.getString(2));
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

	
	public String getAllCurd(String historyname) throws Exception {//history的输出表单
		List list = new ArrayList();
		judge=0;
		String sql = "select * from "+historyname;
		try {
			rs = executeQuery(sql);
			while (rs.next()) {
				judg=0;
				Curd temp = new Curd();
			    String STR=rs.getString(1);
				if(STR!=null&&!STR.equals("col"))judg++;
				temp.setstr1(STR);
				if(rs.getString(2)!=null&&!rs.getString(2).equals("")&&!STR.equals("col1"))judg=2;
				temp.setstr2(rs.getString(2));
				if(rs.getString(3)!=null&&!rs.getString(3).equals("")&&!STR.equals("col1"))judg=3;
				temp.setstr3(rs.getString(3));
				if(rs.getString(4)!=null&&!rs.getString(4).equals("")&&!STR.equals("col1"))judg=4;
				temp.setstr4(rs.getString(4));
				if(rs.getString(5)!=null&&!rs.getString(5).equals("")&&!STR.equals("col1"))judg=5;
				temp.setstr5(rs.getString(5));
				if(rs.getString(6)!=null&&!rs.getString(6).equals("")&&!STR.equals("col1"))judg=6;
				temp.setstr6(rs.getString(6));
				if(rs.getString(7)!=null&&!rs.getString(7).equals("")&&!STR.equals("col1"))judg=7;
				temp.setstr7(rs.getString(7));
				if(rs.getString(8)!=null&&!rs.getString(8).equals("")&&!STR.equals("col1"))judg=8;
			    temp.setstr8(rs.getString(8));
				if(rs.getString(9)!=null&&!rs.getString(9).equals("")&&!STR.equals("col1"))judg=9;
				temp.setstr9(rs.getString(9));
				if(rs.getString(10)!=null&&!rs.getString(10).equals("")&&!STR.equals("col1"))judg=10;
				temp.setstr10(rs.getString(10));
				if(rs.getString(11)!=null&&!rs.getString(11).equals("")&&!STR.equals("col1"))judg=11;
				temp.setstr11(rs.getString(11));
				if(rs.getString(12)!=null&&!rs.getString(12).equals("")&&!STR.equals("col1"))judg=12;
				temp.setstr12(rs.getString(12));
				if(rs.getString(13)!=null&&!rs.getString(13).equals("")&&!STR.equals("col1"))judg=13;
				temp.setstr13(rs.getString(13));
				if(rs.getString(14)!=null&&!rs.getString(14).equals("")&&!STR.equals("col1"))judg=14;
				temp.setstr14(rs.getString(14));
				if(rs.getString(15)!=null&&!rs.getString(15).equals("")&&!STR.equals("col1")){judg=15;
				System.out.println("aaaaaaaaaaaaaaaaaaa "+rs.getString(15));}
				temp.setstr15(rs.getString(15));
				list.add(temp);
				if(judge<judg)judge=judg;
			}
			
			rs = executeQuery(sql);
			rs.next();
			System.out.println("============="+rs.getString(judge));
			judge=Integer.parseInt(rs.getString(judge));
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			close();
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("Curdlist", list);
		request.setAttribute("judge", judge);
		System.out.println("============="+judge);
		return "success";
	}

	public String getAllCurds() throws Exception {//shopping_list的输出
		List list = new ArrayList();
		judge=0;
		String sql = "select * from " + Upload_shop.newnametmp;
		System.out.println("-------111hello-------");
		try {
			rs = executeQuery(sql);
			while (rs.next()) {
				judg=0;
				Curd temp = new Curd();
			    String STR=rs.getString(1);
				if(STR!=null&&!STR.equals("col"))judg++;
				temp.setstr1(STR);
				if(rs.getString(2)!=null&&!rs.getString(2).equals("")&&!STR.equals("col1"))judg=2;
				temp.setstr2(rs.getString(2));
				if(rs.getString(3)!=null&&!rs.getString(3).equals("")&&!STR.equals("col1"))judg=3;
				temp.setstr3(rs.getString(3));
				if(rs.getString(4)!=null&&!rs.getString(4).equals("")&&!STR.equals("col1"))judg=4;
				temp.setstr4(rs.getString(4));
				if(rs.getString(5)!=null&&!rs.getString(5).equals("")&&!STR.equals("col1"))judg=5;
				temp.setstr5(rs.getString(5));
				if(rs.getString(6)!=null&&!rs.getString(6).equals("")&&!STR.equals("col1"))judg=6;
				temp.setstr6(rs.getString(6));
				if(rs.getString(7)!=null&&!rs.getString(7).equals("")&&!STR.equals("col1"))judg=7;
				temp.setstr7(rs.getString(7));
				if(rs.getString(8)!=null&&!rs.getString(8).equals("")&&!STR.equals("col1"))judg=8;
			    temp.setstr8(rs.getString(8));
				if(rs.getString(9)!=null&&!rs.getString(9).equals("")&&!STR.equals("col1"))judg=9;
				temp.setstr9(rs.getString(9));
				if(rs.getString(10)!=null&&!rs.getString(10).equals("")&&!STR.equals("col1"))judg=10;
				temp.setstr10(rs.getString(10));
				if(rs.getString(11)!=null&&!rs.getString(11).equals("")&&!STR.equals("col1"))judg=11;
				temp.setstr11(rs.getString(11));
				if(rs.getString(12)!=null&&!rs.getString(12).equals("")&&!STR.equals("col1"))judg=12;
				temp.setstr12(rs.getString(12));
				if(rs.getString(13)!=null&&!rs.getString(13).equals("")&&!STR.equals("col1"))judg=13;
				temp.setstr13(rs.getString(13));
				if(rs.getString(14)!=null&&!rs.getString(14).equals("")&&!STR.equals("col1"))judg=14;
				temp.setstr14(rs.getString(14));
				if(rs.getString(15)!=null&&!rs.getString(15).equals("")&&!STR.equals("col1")){judg=15;
				System.out.println("aaaaaaaaaaaaaaaaaaa "+rs.getString(15));}
				temp.setstr15(rs.getString(15));
				list.add(temp);
				if(judge<judg)judge=judg;
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			close();
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("Curdlist", list);
		request.setAttribute("judge", judge);
		System.out.println("============="+judge);
		return "success";
	}

	
	public String delete_colhis() throws Exception {//删除历史列
		//alter table 表名 drop column 列名;
		String tmp="";
		try {
			//int n = executeUpdate(sql);
			tmp=Str1.replace("col", "");
			String col_name=tmp+"aaa";
			System.out.println("--------------" + historyname);
		    String sql1 = "alter table " + historyname + " drop column "+col_name;
		    executeUpdate(sql1);
			getAllCurd_hiscol(historyname);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			close();
		}
		return "success";
	}
	public String getAllCurd_hiscol(String historyname) throws Exception {//删除历史列完成的输出
		List list = new ArrayList();
		// System.out.println(Upload_shop.filename);
		String sql = "select * from " + historyname;
		System.out.println("-------111hello-------");
		try {
			rs = executeQuery(sql);
			while (rs.next()) {
				Curd temp = new Curd();
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
				temp.setstr11(rs.getString(11));
				temp.setstr12(rs.getString(12));
				temp.setstr13(rs.getString(13));
				temp.setstr14(rs.getString(14));
				temp.setstr15(rs.getString(15));
				list.add(temp);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			close();
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("Curdlist", list);
		request.setAttribute("judge", judge);
		System.out.println("============="+judge);
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
			getAllCurd_col();
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			close();
		}
		return "success";
	}
	public String getAllCurd_col() throws Exception {//删除列完成的输出
		List list = new ArrayList();
		// System.out.println(Upload_shop.filename);
		String sql = "select * from " + Upload_shop.newnametmp;
		System.out.println("-------111hello-------");
		try {
			rs = executeQuery(sql);
			while (rs.next()) {
				Curd temp = new Curd();
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
				temp.setstr11(rs.getString(11));
				temp.setstr12(rs.getString(12));
				temp.setstr13(rs.getString(13));
				temp.setstr14(rs.getString(14));
				temp.setstr15(rs.getString(15));
				list.add(temp);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			close();
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("Curdlist", list);
		request.setAttribute("judge", judge);
		System.out.println("============="+judge);
		return "success";
	}
	public String delete_hisrow() throws Exception {//删除历史记录行
		String sql = "delete from " + historyname + " where 1aaa='"
				+ trans(Str1) + "'";
		try {
			int n = executeUpdate(sql);
			System.out.println("--------------" + n);
			getAllCurd_hiscol(historyname);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			close();
		}
		return "success";
	}
	public String delete() throws Exception {//删除行
		String sql = "delete from " + Upload_shop.newnametmp + " where 1aaa='"
				+ trans(Str1) + "'";
		try {
			int n = executeUpdate(sql);
			System.out.println("--------------" + n);
			getAllCurd_col();
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			close();
		}
		return "success";
	}
	public String delete_history() throws Exception {//删除历史记录的表单
		String sql = "select * from "+Login.username+"history where Chinese='" + trans(Str1) + "'";
		String sql1 = "delete from "+Login.username+"history where Chinese='"
				+ trans(Str1) + "'";
		try {rs = executeQuery(sql);
		    rs.next();
		    String sql2 = "drop table "+rs.getString(1);
			int n = executeUpdate(sql1);
			executeUpdate(sql2);
			getAllHistory();
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			close();
		}
		return "success";
	}

	/*
	 * 查询
	 */
	public String search() throws Exception {
		List list = new ArrayList();
		int judge_his=0;
		try {
			String [] str = new String[]{"","","","","","","","","","","","","","","","","","","",""};
			String sql = "select * from " + Upload_shop.newnametmp;
			 rs = executeQuery(sql);
			 while (rs.next()) {
					judg=0;					
				    String STR=rs.getString(1);
					if(STR!=null&&!STR.equals("col"))judg++;					
					if(rs.getString(2)!=null&&!rs.getString(2).equals("")&&!STR.equals("col1"))judg++;				
					if(rs.getString(3)!=null&&!rs.getString(3).equals("")&&!STR.equals("col1"))judg++;				
					if(rs.getString(4)!=null&&!rs.getString(4).equals("")&&!STR.equals("col1"))judg++;				
					if(rs.getString(5)!=null&&!rs.getString(5).equals("")&&!STR.equals("col1"))judg++;				
					if(rs.getString(6)!=null&&!rs.getString(6).equals("")&&!STR.equals("col1"))judg++;				
					if(rs.getString(7)!=null&&!rs.getString(7).equals("")&&!STR.equals("col1"))judg++;				
					if(rs.getString(8)!=null&&!rs.getString(8).equals("")&&!STR.equals("col1"))judg++;				    
					if(rs.getString(9)!=null&&!rs.getString(9).equals("")&&!STR.equals("col1"))judg++;					
					if(rs.getString(10)!=null&&!rs.getString(10).equals("")&&!STR.equals("col1"))judg++;				
					if(rs.getString(11)!=null&&!rs.getString(11).equals("")&&!STR.equals("col1"))judg++;					
					if(rs.getString(12)!=null&&!rs.getString(12).equals("")&&!STR.equals("col1"))judg++;					
					if(rs.getString(13)!=null&&!rs.getString(13).equals("")&&!STR.equals("col1"))judg++;				
					if(rs.getString(14)!=null&&!rs.getString(14).equals("")&&!STR.equals("col1"))judg++;					
					if(rs.getString(15)!=null&&!rs.getString(15).equals("")&&!STR.equals("col1")){judg++;
					System.out.println("aaaaaaaaaaaaaaaaaaa "+rs.getString(15));}			
					if(judge_his<judg)judge_his=judg;
				}
			 rs = executeQuery(sql);
			 rs.next();
			 String sql1 = "select * from " +Upload_shop.newnametmp+ " where concat(1aaa";
			 for(int i=2;i<=judge_his;i++){
				 if(!rs.getString(i).equals("")&&rs.getString(i)!=null)
					 sql1=sql1+","+String.valueOf(rs.getString(i))+"aaa";
			 }
			 
			sql1=sql1+") like'%" + trans(search) + "%'";
			 System.out.println(sql1);
		    rs = executeQuery(sql1);
		    
			    while (rs.next()) {
			    	Curd temp = new Curd();
			    	System.out.println(rs.getString(1));
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
					temp.setstr11(rs.getString(11));
					temp.setstr12(rs.getString(12));
					temp.setstr13(rs.getString(13));
					temp.setstr14(rs.getString(14));
					temp.setstr15(rs.getString(15));
				   list.add(temp);
				  
			    }
			//}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			close();
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("Curdlist", list);
		return "success";
	}

	
	public String search_his() throws Exception {//历史表单的查询
		List list = new ArrayList();
		int judge_his=0;
		try {
			String [] str = new String[]{"","","","","","","","","","","","","","","","","","","",""};
			String sql = "select * from " + historyname;
			 rs = executeQuery(sql);
			 while (rs.next()) {
					judg=0;					
				    String STR=rs.getString(1);
					if(STR!=null&&!STR.equals("col"))judg++;					
					if(rs.getString(2)!=null&&!rs.getString(2).equals("")&&!STR.equals("col1"))judg++;				
					if(rs.getString(3)!=null&&!rs.getString(3).equals("")&&!STR.equals("col1"))judg++;				
					if(rs.getString(4)!=null&&!rs.getString(4).equals("")&&!STR.equals("col1"))judg++;				
					if(rs.getString(5)!=null&&!rs.getString(5).equals("")&&!STR.equals("col1"))judg++;				
					if(rs.getString(6)!=null&&!rs.getString(6).equals("")&&!STR.equals("col1"))judg++;				
					if(rs.getString(7)!=null&&!rs.getString(7).equals("")&&!STR.equals("col1"))judg++;				
					if(rs.getString(8)!=null&&!rs.getString(8).equals("")&&!STR.equals("col1"))judg++;				    
					if(rs.getString(9)!=null&&!rs.getString(9).equals("")&&!STR.equals("col1"))judg++;					
					if(rs.getString(10)!=null&&!rs.getString(10).equals("")&&!STR.equals("col1"))judg++;				
					if(rs.getString(11)!=null&&!rs.getString(11).equals("")&&!STR.equals("col1"))judg++;					
					if(rs.getString(12)!=null&&!rs.getString(12).equals("")&&!STR.equals("col1"))judg++;					
					if(rs.getString(13)!=null&&!rs.getString(13).equals("")&&!STR.equals("col1"))judg++;				
					if(rs.getString(14)!=null&&!rs.getString(14).equals("")&&!STR.equals("col1"))judg++;					
					if(rs.getString(15)!=null&&!rs.getString(15).equals("")&&!STR.equals("col1")){judg++;
					System.out.println("aaaaaaaaaaaaaaaaaaa "+rs.getString(15));}			
					if(judge_his<judg)judge_his=judg;
				}
			 rs = executeQuery(sql);
			 rs.next();
			 String sql1 = "select * from " +historyname+ " where concat(1aaa";
			 for(int i=2;i<=judge_his;i++){
				 if(!rs.getString(i).equals("")&&rs.getString(i)!=null)
					 sql1=sql1+","+String.valueOf(rs.getString(i))+"aaa";
			 }
			 
			sql1=sql1+") like'%" + trans(search) + "%'";
			 System.out.println(sql1);
		    rs = executeQuery(sql1);
		    
			    while (rs.next()) {
			    	Curd temp = new Curd();
			    	System.out.println(rs.getString(1));
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
					temp.setstr11(rs.getString(11));
					temp.setstr12(rs.getString(12));
					temp.setstr13(rs.getString(13));
					temp.setstr14(rs.getString(14));
					temp.setstr15(rs.getString(15));
				   list.add(temp);
				  
			    }
			//}
			
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
					"jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_wmgetinfo?user=w0n0llomwl&password=h5m4yl3w055zihh10li002w3yji345x355x4yiji");
		}
		return con;
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
	public String getstr13() {
		return str13;
	}

	public void setstr13(String str13) {
		this.str13 = str13;
	}
	public String getstr14() {
		return str14;
	}

	public void setstr14(String str14) {
		this.str14 = str14;
	}
	public String getstr15() {
		return str15;
	}

	public void setstr15(String str15) {
		this.str15 = str15;
	}
	public String trans(String baobeiname) throws UnsupportedEncodingException {
		String baobeiname1 = new String(baobeiname.getBytes("ISO8859-1"),
				"utf-8");
		return baobeiname1;
	}

	public static void main(String[] args) {
		Curd Curd = new Curd();
	}
}
