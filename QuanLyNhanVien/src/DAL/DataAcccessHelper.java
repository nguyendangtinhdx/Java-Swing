/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nguyen Dang Tinh
 */
public class DataAcccessHelper {
    protected Connection con;
    String HostName = "localhost";
    String port = "1433";
    String dbName = "QuanLyNhanVien";
    String user = "sa";
    String pass = "55555";
    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String URL = "jdbc:sqlserver://DESKTOP-FK24324\\SQLEXPRESS:1433;databaseName=QuanLyNhanVien";
    
    public void getConnect(){
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(URL,user,pass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataAcccessHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DataAcccessHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void getClose(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataAcccessHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
