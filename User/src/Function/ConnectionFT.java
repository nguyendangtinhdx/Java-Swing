/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nguyen Dang Tinh
 */
public class ConnectionFT {
    private static Connection con;
    public static Connection getConnection(){
        try {
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //    con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;user=sa;password=55555;database=QuanLyUser");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=QuanLyUser","sa","55555");
        
        } catch (Exception ex) {
        //    System.out.println("Kết nối bị lỗi");
        Logger.getLogger(ConnectionFT.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        return con;
    }
    // connect
    public void Close()
    {
        if(con!=null)
        try {
            if(!con.isClosed())
                con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFT.class.getName()).log(Level.SEVERE, null, ex);
        }
        con=null;
    }
}
