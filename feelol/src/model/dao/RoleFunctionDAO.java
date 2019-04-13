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
import model.dto.RoleFunction;
import utils.DBConnect;

/**
 *
 * @author BVMT
 */
public class RoleFunctionDAO {

    private final String SQLCREATE = "insert into rolefunction values(?,?,?)";
    private final String SQLREADALL = "select * from feeaccount";
    private final String SQLUPDATE = "update feeaccount set roleid = ? , Username =?, password = ?";
    private final String SQLDELETE = "delete from feeaccount where AccountId = ?";
    private final Connection con;

    public RoleFunctionDAO() {
        con = new DBConnect().getCon();
    }

    public RoleFunction create(RoleFunction rolfun) {
        try {
            PreparedStatement pr = con.prepareStatement(SQLCREATE);
            pr.setInt(1, rolfun.getiD());
            pr.setInt(2, rolfun.getRoleID());
            pr.setInt(3, rolfun.getFuntionID());
            pr.execute();
            return rolfun;
        } catch (SQLException ex) {
            Logger.getLogger(FeeAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public List<RoleFunction> readAll() {
        String s = "SELECT * FROM RoleFunction";
        List<RoleFunction> list = new ArrayList<RoleFunction>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(s);
            if (rs != null) {

                while (rs.next()) {
                    RoleFunction rolfun = new RoleFunction();
                    rolfun.setiD(rs.getInt(1));
                    rolfun.setRoleID(rs.getInt(2));
                    rolfun.setFuntionID(rs.getInt(3));
                    list.add(rolfun);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FeeAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public boolean update(RoleFunction rolfun) {
        try {
            String s = "UPDATE rolefunction SET roleid = ?,functionid = ? WHERE id = ?";
            PreparedStatement pr = con.prepareStatement(s);
            pr.setInt(1, rolfun.getiD());
            pr.setInt(3, rolfun.getRoleID());
            pr.setInt(2, rolfun.getFuntionID());
            pr.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FeeAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean delete(int id) {
        try {
            String s = "delete from RoleFunction where Id ='" + id + "'";
            Statement st = con.createStatement();
            st.execute(s);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FeeAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }
}
