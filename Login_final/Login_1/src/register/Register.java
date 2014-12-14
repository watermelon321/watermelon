package register;

import javabean.DatabaseAccess;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class Register extends ActionSupport{
	static HttpServletRequest request = ServletActionContext.getRequest();
	public static String username;
    public boolean isValid(String username, String password) {
        boolean isValid = false;
        DatabaseAccess db = new DatabaseAccess();
        String sql = "select * from users where username='" + username + "' and password='" + password + "'";
        db.query_user(sql);
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
        db.query_user(sql);
        if (db.next()) {
            isExist = true;
        }

        db.close();

        return isExist;
    }

    public String add() {
    	boolean insert_tmp,exist_tmp_n=false;
        DatabaseAccess db = new DatabaseAccess();     
        username = request.getParameter("username");
        System.out.println(username);
        String password = request.getParameter("Password");
        exist_tmp_n = isExist(username);
        if (exist_tmp_n == true)
        	return "fail";
        else
        {
        String sql = "insert into users(username,password) values('" + username + "','" + password +  "')";
        String newdb = "create database "+username;
        String newsql="create table history(English varchar(150),Chinese varchar(150))";
        insert_tmp = db.perform_user(sql);
        db.createTable_user(newdb);//建数据库
        db.createTable_his(newsql);//每个用户建history表
        db.close();
        if (insert_tmp == true && exist_tmp_n == false)
        	return "success";
        else
        	return "fail";   
        }
    }
}
