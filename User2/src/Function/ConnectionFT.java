/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Nguyen Dang Tinh
 */
public class ConnectionFT {
    private static Connection con;
    public static Connection getConnection(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           // con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;user=sa;password=55555;database=QuanLyUser");
            con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-FK24324\\SQLEXPRESS:1433;databaseName=QuanLyUser;user=sa;password=55555");

        } catch (Exception e) {
            System.out.println("Kết nối bị lỗi ");
        }
        return con;
    }
}

