package login;

import java.sql.ResultSet;
import java.sql.SQLException;

import javabean.DatabaseAccess;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class Login {
	static HttpServletRequest request = ServletActionContext.getRequest();
	public static String username;
	public String login() {
		DatabaseAccess db = new DatabaseAccess();
		String pass_tmp=null;
		username = request.getParameter("username");
		System.out.println(username);
		request.setAttribute("name",username);
		String password = request.getParameter("Password");
		System.out.println(password);
		try {
			String sql = "select * from users where username='" + username
					+ "'";
			ResultSet rs = db.query_user(sql);
			if (rs.next()) {
				pass_tmp = rs.getString("password");
				System.out.println(pass_tmp);
			}
			else 
				return "fail_non";
		} catch (SQLException e) {
			System.out.println("��ѯ����ʧ��");
		}
		if(password.equals(pass_tmp))
		return "success";
		else
			return "fail";
	}
}
