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
import model.dto.Invoicedetail;
import model.dto.Invoices;
import utils.DBConnect;

/**
 *
 * @author USER
 */
public class InvoicesDAO {

    private String SQLREADALL = "SELECT * FROM INVOICES";
    private String SQLCREATE = "INSERT INTO INVOICES VALUES (?,?,?,?)";
    private String SQLUPDATE = "UPDATE INVOICES SET INVOICEID =?, PRODUCTID = ?, ACCOUNTID = ?, DATESELL= ?";
    private String SQLDELETE = "DELETE FROM INVOICES WHERE INVOICEID =?";
    private Connection con;

    public InvoicesDAO() {
        con = new DBConnect().getCon();
    }

    java.sql.Date convert(java.util.Date d) {
        return new java.sql.Date(d.getTime());
    }

    public Invoices create(Invoices a) {
        try {
            PreparedStatement pr = con.prepareStatement(SQLCREATE);
            pr.setInt(1, a.getInvoiceid());
            pr.setInt(2, a.getProductid());
            pr.setInt(3, a.getAccountid());
            pr.setDate(4, convert(a.getDatesell()));
            pr.execute();
            return a;

        } catch (SQLException ex) {
            Logger.getLogger(InvoicedetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Invoices> readAll() {
        List<Invoices> list = new ArrayList<>();
        try {
            Statement a = con.createStatement();
            ResultSet rs = a.executeQuery(SQLREADALL);
            if (rs != null) {
                while (rs.next()) {
                    Invoices b = new Invoices();
                    b.setInvoiceid(rs.getInt(1));
                    b.setProductid(rs.getInt(2));
                    b.setAccountid(rs.getInt(3));
                    b.setDatesell(rs.getDate(4));
                    list.add(b);
                }
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(InvoicesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean update(Invoices a) {
        try {
            PreparedStatement pr = con.prepareStatement(SQLUPDATE);
            pr.setInt(1, a.getInvoiceid());
            pr.setInt(2, a.getProductid());
            pr.setInt(3, a.getAccountid());
            pr.setDate(4, convert(a.getDatesell()));
            pr.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(InvoicesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean delete(int invoiceid) {
        try {
            PreparedStatement pr = con.prepareStatement(SQLDELETE);
            pr.setInt(1, invoiceid);
            pr.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(InvoicesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;

    }
}
