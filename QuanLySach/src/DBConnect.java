
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
//import jdk.nashorn.internal.ir.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nguyen Dang Tinh
 */
public class DBConnect {
    Connection con;
    public DBConnect(){
        String stringCon = "jdbc:sqlserver://DESKTOP-FK24324\\SQLEXPRESS:1433;databaseName=QuanLySach";
        try {
            con = DriverManager.getConnection(stringCon,"sa","55555");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //  ham lay du lieu trong bang DB
    public ResultSet getData(String stringSQL){
        // doi tuong se chua ket qua tra ve tu sql
        ResultSet rs = null;
        // tao duong dan ket noi
        try {
            Statement state = con.createStatement();
            rs = state.executeQuery(stringSQL);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    // ham Insert
    public int ExecuteSQLInsert(String[] stringSQL){
        int rowsInserted = 0;
        String sql = "INSERT INTO Sach(MaSach,TenSach,TheLoai,NXB,SoTrang,GiaTien) VALUES(?,?,?,?,?,?) ";
        PreparedStatement statement;
        try {
            statement = con.prepareStatement(sql);
            statement.setString(1,stringSQL[0]);
            statement.setString(2,stringSQL[1]);
            statement.setString(3,stringSQL[2]);
            statement.setString(4,stringSQL[3]);
            statement.setString(5,stringSQL[4]);
            statement.setString(6,stringSQL[5]);
                    
            rowsInserted = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rowsInserted;
    }
    
    // ham Update 
    public int ExecuteSQLUpdate(String[] stringSQL){
        int rowsInserted = 0;
        String sql = " UPDATE Sach SET TenSach=?,TheLoai=?,NXB=?,SoTrang=?,GiaTien=? WHERE MaSach=?  ";
        PreparedStatement statement;
        try {
            statement = con.prepareStatement(sql);
            statement.setString(1,stringSQL[0]);
            statement.setString(2,stringSQL[1]);
            statement.setString(3,stringSQL[2]);
            statement.setString(4,stringSQL[3]);
            statement.setString(5,stringSQL[4]);
            statement.setString(6,stringSQL[5]);
                    
            rowsInserted = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rowsInserted;
    }
    
    // ham Delete
    public int ExecuteSQLDelete(String[] stringSQL){
        int rowsInserted = 0;
        String sql = "DELETE FROM Sach WHERE MaSach=? ";
        PreparedStatement statement;
        try {
            statement = con.prepareStatement(sql);
            statement.setString(1,stringSQL[0]);
              
            rowsInserted = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rowsInserted;
    }
}
