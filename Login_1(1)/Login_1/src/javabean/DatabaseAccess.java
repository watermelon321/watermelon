/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javabean;
import register.Register;
import login.Login;
import java.sql.*;

import com.sun.org.apache.bcel.internal.generic.RETURN;
/**
 *
 * @author e
 */
public class DatabaseAccess {
    private Connection conn = null;
    private Statement stm = null;
    private ResultSet rs = null;
     
     public void DBAccess(){
    	 try {
             Class.forName("com.mysql.jdbc.Driver");
             conn=DriverManager.getConnection("jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_wmgetinfo?user=w0n0llomwl&password=h5m4yl3w055zihh10li002w3yji345x355x4yiji");
             stm = conn.createStatement();
             } catch (Exception e) {
             System.out.println(e.toString());
         }
     }
     

    public boolean perform(String sql) {
        boolean b = false;
        DBAccess();
        try {
        	stm.execute(sql);
            b = true;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return b;
    }

    public boolean createTable(String sql) {
        boolean b = false;
        DBAccess();
        try {
        	stm.executeUpdate(sql);
            b = true;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return b;
    }
   
    
    public ResultSet query(String sql) {
    	DBAccess();
        try {
        	if(Login.username!=null)rs = stm.executeQuery(sql);
            else rs = stm.executeQuery(sql);
          
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return rs;
    }
   

    public boolean next() {
        boolean b = false;
        try {
            if (rs.next()) {
                b = true;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return b;
    }

    public void close() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
}
