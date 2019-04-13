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
import model.dto.Function;
import model.dto.Role;
import utils.DBConnect;

/**
 *
 * @author BVMT
 */
public class RoleDAO {

    private final String SQLCREATE = "INSERT INTO role VALUES(?)";
    private final String SQLREADFUNCTION = "SELECT        Role.RoleId, [Function].FunctionName, [Function].FunctionId, [Function].Description\n"
            + "FROM            FeeAccount INNER JOIN\n"
            + "                         Role ON FeeAccount.RoleId = Role.RoleId INNER JOIN\n"
            + "                         RoleFunction ON Role.RoleId = RoleFunction.RoleId INNER JOIN\n"
            + "                         [Function] ON RoleFunction.FunctionId = [Function].FunctionId\n"
            + "WHERE        (Role.RoleId = ?)";
    private String SQLREADALL = "";
    private String SQLUPDATE = "";
    private String SQLDELETE = "";
    private Connection con = null;

    public RoleDAO() {
        con = new DBConnect().getCon();
    }

    public Role create(Role role) {

        try {
            PreparedStatement pr = con.prepareStatement(SQLCREATE, Statement.RETURN_GENERATED_KEYS);
            pr.setString(1, role.getRoleName());
            pr.execute();
            ResultSet rs = pr.getGeneratedKeys();
            int generateedKey = 0;
            if (rs.next()) {
                generateedKey = rs.getInt(1);
            }
            return role;
        } catch (SQLException ex) {
            Logger.getLogger(FunctionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Role> readAll() {
        String s = "SELECT * FROM role";
        List<Role> list = new ArrayList<Role>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(s);
            if (rs != null) {

                while (rs.next()) {
                    Role role = new Role();
                    role.setRoleId(rs.getInt(1));
                    role.setRoleName(rs.getString(2));
                    list.add(role);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Function.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
    public List<Function> readAllFunction(int roleid) {
        List<Function> list = new ArrayList<Function>();
        try {
            PreparedStatement pr = con.prepareStatement(SQLREADFUNCTION);
            pr.setInt(1, roleid);
            ResultSet rs = pr.executeQuery();
            if (rs != null) {

                while (rs.next()) {
                    Function f = new Function();
                    f.setFuntionId(rs.getInt(1));
                    f.setFuntionName(rs.getString(2));
                    f.setDescription(rs.getString(3));
                    list.add(f);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Function.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
    public boolean update(Role role) {
        try {
            String s = "UPDATE role SET roleName = ? WHERE roleId = ?";
            PreparedStatement pr = con.prepareStatement(s);

            pr.setString(1, role.getRoleName());
            pr.setInt(2, role.getRoleId());
            pr.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FunctionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean delete(int roleId) {
        try {
            String s = "delete from role where roleId ='" + roleId + "'";
            Statement st = con.createStatement();
            st.execute(s);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FunctionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
