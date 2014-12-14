/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javabean;
import register.Register;
import login.Login;
import java.sql.*;

/**
 *
 * @author e
 */
public class DatabaseAccess {
    private Connection conn = null;
    private Connection conn_user = null;
    private Statement stm = null;
    private Connection conn_his = null;
    private Statement stm_his = null;
    private ResultSet rs = null;
    private Statement stm_user = null;
     public void DBAccess_user () {
         try {
             Class.forName("com.mysql.jdbc.Driver");
             conn_user=DriverManager.getConnection("jdbc:mysql://localhost:3306/operation?user=root&password=angel99627");
             //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+Login.username+"?user=root&password=angel99627");
             stm_user=conn_user.createStatement();
             //stm = conn.createStatement();
             
         } catch (Exception e) {
             System.out.println(e.toString());
         }
     }
     public void DBAccess(){
    	 try {
             Class.forName("com.mysql.jdbc.Driver");
             //conn_user=DriverManager.getConnection("jdbc:mysql://localhost:3306/operation?user=root&password=angel99627");
             conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+Login.username+"?user=root&password=angel99627");
             //stm_user=conn_user.createStatement();
             stm = conn.createStatement();
             
         } catch (Exception e) {
             System.out.println(e.toString());
         }
     }
     public void DBAccess_his(){
    	 try {
             Class.forName("com.mysql.jdbc.Driver");
             //conn_user=DriverManager.getConnection("jdbc:mysql://localhost:3306/operation?user=root&password=angel99627");
             conn_his = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+Register.username+"?user=root&password=angel99627");
             //stm_user=conn_user.createStatement();
             stm_his = conn_his.createStatement();
             
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
    public boolean perform_user(String sql) {
        boolean b = false;
        DBAccess_user();
        try {
            stm_user.execute(sql);
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
    public boolean createTable_his(String sql) {
        boolean b = false;
        DBAccess_his();
        try {
            stm_his.executeUpdate(sql);
            b = true;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return b;
    }
    public boolean createTable_user(String sql) {
        boolean b = false;
        DBAccess_user();
        try {
            stm_user.executeUpdate(sql);
            b = true;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return b;
    }
    
    public ResultSet query(String sql) {
    	DBAccess();
        try {
            rs = stm.executeQuery(sql);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return rs;
    }
    public ResultSet query_user(String sql) {
    	DBAccess_user();
        try {
            rs = stm_user.executeQuery(sql);
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
