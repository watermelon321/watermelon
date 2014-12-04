package register;

import javabean.DatabaseAccess;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class Register extends ActionSupport{
	static HttpServletRequest request = ServletActionContext.getRequest();
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
        String username = request.getParameter("username");
        System.out.println(username);
        String password = request.getParameter("Password");
        exist_tmp_n = isExist(username);
        if (exist_tmp_n == true)
        	return "fail";
        else
        {
        String sql = "insert into users(username,password) values('" + username + "','" + password +  "')";
        String newsql = "create table "+username+"(tordernumber varchar(60),"+"tdate varchar(60),"+"tpricesum varchar(60),"+"tbaobeiname varchar(60),"+"tprice varchar(60),"+"tquantity varchar(60))";
        insert_tmp = db.perform(sql);
        db.createTable(newsql);
        db.close();
        if (insert_tmp == true && exist_tmp_n == false)
        	return "success";
        else
        	return "fail";   
        }
    }
}
