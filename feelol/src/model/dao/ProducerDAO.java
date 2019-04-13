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
import model.dto.Producer;
import utils.DBConnect;

/**
 *
 * @author USER
 */
public class ProducerDAO {

    private String SQLREADALL = "SELECT * FROM PRODUCERS";
    private String SQLCREATE = "INSERT INTO PRODUCERS VALUES (?,?,?)";
    private String SQLUPDATE = "UPDATE PRODUCER SET PRODUCERID =? , NAME = ?, DESCRIPTION = ?";
    private String SQLDELETE = "DELETE FROM PRODUCER WHERE PRODUCERID =?";
    private Connection con;

    public ProducerDAO() {
        con = new DBConnect().getCon();
    }

    public List<Producer> readAll() {
        List<Producer> list = new ArrayList<>();
        Statement a;
        try {
            a = con.createStatement();
            ResultSet rs = a.executeQuery(SQLREADALL);
            if (rs != null) {
                while (rs.next()) {
                    Producer b = new Producer();
                    b.setProducerid(rs.getInt(1));
                    b.setName(rs.getString(2));
                    b.setDescription(rs.getString(3));
                    list.add(b);
                }
            }
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(ProducerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public Producer create(Producer a) {
        try {
            PreparedStatement pr = con.prepareStatement(SQLCREATE);
            pr.setInt(1, a.getProducerid());
            pr.setString(2, a.getName());
            pr.setString(3, a.getDescription());
            pr.execute();
            return a;
        } catch (SQLException ex) {
            Logger.getLogger(ProducerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean update(Producer a) {
        try {
            PreparedStatement pr = con.prepareStatement(SQLUPDATE);
            pr.setInt(1, a.getProducerid());
            pr.setString(2, a.getName());
            pr.setString(3, a.getDescription());
            pr.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProducerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean delete(int producerid) {
        try {
            PreparedStatement pr = con.prepareStatement(SQLDELETE);
            pr.setInt(1, producerid);
            pr.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProducerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

}
