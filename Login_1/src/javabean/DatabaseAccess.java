/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javabean;

import java.sql.*;

/**
 *
 * @author e
 */
public class DatabaseAccess {
    private Connection conn = null;
    private Statement stm = null;
    private ResultSet rs = null;

     public DatabaseAccess () {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/operation?user=root&password=angel99627");
            stm = conn.createStatement();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public boolean perform(String sql) {
        boolean b = false;
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
        try {
            stm.executeUpdate(sql);
            b = true;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return b;
    }
    
    public ResultSet query(String sql) {
        try {
            rs = stm.executeQuery(sql);
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
