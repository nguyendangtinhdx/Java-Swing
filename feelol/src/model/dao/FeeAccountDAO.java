/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dto.FeeAccount;
import utils.DBConnect;

/**
 *
 * @author BVMT
 */
public class FeeAccountDAO {

    private final String SQLCREATE = "insert into feeaccount values(?,?,?)";
    private final String SQLREADALL = "select * from feeaccount";
    private final String SQLREADBYUSERNAME = "select * from feeaccount WHERE USERNAME = ?";
    private final String SQLUPDATE = "update feeaccount set roleid = ? , Username =?, password = ?";
    private final String SQLDELETE = "delete from feeaccount where AccountId = ?";
    private final Connection con;

    public FeeAccountDAO() {
        con = new DBConnect().getCon();
    }
    
    public FeeAccount create(FeeAccount fee) {
        try {
            PreparedStatement pr = con.prepareStatement(SQLCREATE, Statement.RETURN_GENERATED_KEYS);
            pr.setInt(1, fee.getRoleId());
            pr.setString(2, fee.getUsername());
            pr.setString(3, fee.getPassword());
            pr.execute();
            ResultSet rs = pr.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
            return fee;
        } catch (SQLException ex) {
            Logger.getLogger(FeeAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public List<FeeAccount> readAll() {
        String s = "SELECT * FROM feeaccount";
        List<FeeAccount> list = new ArrayList<FeeAccount>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(s);
            if (rs != null) {
                
                while (rs.next()) {
                    FeeAccount fee = new FeeAccount();
                    fee.setAccountId(rs.getInt(1));
                    fee.setRoleId(rs.getInt(2));
                    fee.setUsername(rs.getString(3));
                    fee.setPassword(rs.getString(4));
                    list.add(fee);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FeeAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }

    public FeeAccount readByUsername(String username) {
        try {
            PreparedStatement st = con.prepareStatement(SQLREADBYUSERNAME);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if (rs != null) {
                if (rs.next()) {
                    FeeAccount fee = new FeeAccount();
                    fee.setAccountId(rs.getInt(1));
                    fee.setRoleId(rs.getInt(2));
                    fee.setUsername(rs.getString(3));
                    fee.setPassword(rs.getString(4));
                    return fee;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FeeAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    public boolean update(FeeAccount fee) {
        try {
            String s = "UPDATE feeaccount SET roleid = ?,Username = ?, password = ? WHERE accountId = ?";
            PreparedStatement pr = con.prepareStatement(s);
            pr.setInt(4, fee.getAccountId());
            pr.setInt(1, fee.getRoleId());
            pr.setString(2, fee.getUsername());
            pr.setString(3, fee.getPassword());
            pr.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FeeAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean delete(String AcId) {
        try {
            String s = "delete from feeaccount where AccountId ='" + AcId + "'";
            Statement st = con.createStatement();
            st.execute(s);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FeeAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }
}
