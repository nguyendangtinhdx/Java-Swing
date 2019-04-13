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
import utils.DBConnect;

/**
 *
 * @author USER
 */
public class InvoicedetailDAO {

    private final String SQLREADALL = "SELECT * FROM INVOICEDETAIL";
    private final String SQLCREATE = "INSERT INTO INVOICEDETAIL VALUES (?,?,?,?)";
    private final String SQLUPDATE = "UPDATE INVOICEDETAIL SET INVOICEDETAILID = ?, PRODUCTID = ?, INVOICEID = ?,QUANTITY =?";
    private final String SQLDELETE = "DELETE FROM INVOICEDETAIL WHERE INVOICEDETAILID = ?";
    private final Connection con;

    public InvoicedetailDAO() {
        con = new DBConnect().getCon();
    }

    public Invoicedetail create(Invoicedetail a) {
        try {
            PreparedStatement pr = con.prepareStatement(SQLCREATE);
            pr.setInt(1, a.getInvoicedetailid());
            pr.setInt(2, a.getProductid());
            pr.setInt(3, a.getInvoiceid());
            pr.setInt(4, a.getQuantity());
            pr.execute();
            return a;

        } catch (SQLException ex) {
            Logger.getLogger(InvoicedetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Invoicedetail> readAll() {
        List<Invoicedetail> list = new ArrayList<>();
        try {
            Statement a = con.createStatement();
            ResultSet rs = a.executeQuery(SQLREADALL);
            if(rs!=null){
                while(rs.next())
                {
                    Invoicedetail in = new Invoicedetail();
                    in.setInvoicedetailid(rs.getInt(1));
                    in.setProductid(rs.getInt(2));
                    in.setInvoiceid(rs.getInt(3));
                    in.setQuantity(rs.getInt(4));
                    list.add(in);
                    
                }
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(InvoicedetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
    public boolean update(Invoicedetail in)
    {
        try {
            PreparedStatement pr = con.prepareStatement(SQLUPDATE);
            pr.setInt(1,in.getInvoicedetailid());
            pr.setInt(2,in.getProductid());
            pr.setInt(3,in.getInvoiceid());
            pr.setInt(4,in.getQuantity());
            pr.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(InvoicedetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean delete(int Invoicedetail){
        PreparedStatement pr;
        try {
            pr = con.prepareStatement(SQLDELETE);
            pr.setInt(1, Invoicedetail);
            pr.execute();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(InvoicedetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

}
