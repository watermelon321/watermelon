package register;

import javabean.DatabaseAccess;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import java.util.regex.*; 

@SuppressWarnings("serial")
public class Register extends ActionSupport{
	 HttpServletRequest request = ServletActionContext.getRequest();
	public static String username;
    public boolean isValid(String username, String password) {
        boolean isValid = false;
        DatabaseAccess db = new DatabaseAccess();
        String sql = "select * from users where username='" + username + "' and password='" + password + "'";
        db.query(sql);
        if (db.next()) {
            isValid = true;
        }
        db.close();

        return isValid;
    }

    public boolean isExist(String username) {
        boolean isExist = false;
        DatabaseAccess db = new DatabaseAccess();
        String sql = "select * from users where username='" + username + "'";
        db.query(sql);
        if (db.next()) {
            isExist = true;
        }

        db.close();

        return isExist;
    }

    public String add() {
    	boolean insert_tmp,exist_tmp_n=false;
        DatabaseAccess db = new DatabaseAccess();  
        Pattern pt = Pattern.compile("^[0-9a-zA-Z_]+$");
        username = request.getParameter("username");
        System.out.println(username);
        String password = request.getParameter("Password");
        String re_password = request.getParameter("re_Password");
        exist_tmp_n = isExist(username);
        Matcher mt = pt.matcher(username);
        if(!mt.matches()){
        	return "fail_remain";
        }
        else if (!password.equals(re_password))
        {
        	return "fail_remain";
        }
        else if(password.length()<7||re_password.length()<7)
        {
        	return "fail_remain";
        }
        else if (exist_tmp_n == true)
        {
        	return "fail";
        }
        else
        {
        String sql = "insert into users(username,password) values('" + username + "','" + password +  "')";
        String newsql="create table "+username+"history(English varchar(150),Chinese varchar(150))";
        insert_tmp = db.perform(sql);
        db.createTable(newsql);//每个用户建history表
        db.close();
        if (insert_tmp == true && exist_tmp_n == false)
        	return "success";
        else
        	return "fail";   
        }
    }
}
