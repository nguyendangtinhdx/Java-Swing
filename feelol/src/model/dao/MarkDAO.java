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
import model.dto.Mark;
import utils.DBConnect;

/**
 *
 * @author BVMT
 */
public class MarkDAO {

    private final String SQLCREATE = "insert into mark values(?,?,?)";
    private final String SQLREADALL = "select * from mark";
    private final String SQLREADBYUSERNAME = "select * from mark WHERE USERNAME = ?";
    private final String SQLUPDATE = "UPDATE Mark SET courseID = ?,mark = ?, accountID = ? WHERE MarkID = ?";
    private final String SQLDELETE = "delete from mark where MarkId =?";
    private final Connection con;

    public MarkDAO() {
        con = new DBConnect().getCon();
    }

    public Mark create(Mark mark) {
        try {
            PreparedStatement pr = con.prepareStatement(SQLCREATE, Statement.RETURN_GENERATED_KEYS);
            pr.setInt(1, mark.getCourseID());
            pr.setFloat(2, mark.getMark());
            pr.setInt(3, mark.getAccountID());
            pr.execute();
            ResultSet rs = pr.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
            return mark;
        } catch (SQLException ex) {
            Logger.getLogger(FeeAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public List<Mark> readAll() {
        List<Mark> list = new ArrayList<Mark>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQLREADALL);
            if (rs != null) {
                while (rs.next()) {
                    Mark mark = new Mark();
                    mark.setMarkID(rs.getInt(1));
                    mark.setCourseID(rs.getInt(2));
                    mark.setMark(rs.getFloat(3));
                    mark.setAccountID(rs.getInt(4));
                    list.add(mark);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mark.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public boolean update(Mark mark) {
        try {
            PreparedStatement pr = con.prepareStatement(SQLUPDATE);
            pr.setInt(1, mark.getCourseID());
            pr.setInt(2, mark.getAccountID());
            pr.setFloat(3, mark.getMark());
            pr.setInt(4, mark.getMarkID());
            pr.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FunctionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean delete(int MarkId) {
        try {
            String s = "delete from mark where MarkId ='" + MarkId + "'";
            Statement st = con.createStatement();
            st.execute(s);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FeeAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }

}
