/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dto.InvoicesPrint;
import utils.DBConnect;

/**
 *
 * @author USER
 */
public class InvocesPrintDAO {

    Connection con = null;
    String sql = "SELECT        Invoices.datesell, FeeAccount.Username, Products.name, Products.price, invoicedetail.quantity\n"
            + "FROM            FeeAccount INNER JOIN\n"
            + "                         Invoices ON FeeAccount.AccountId = Invoices.accountid INNER JOIN\n"
            + "                         Products ON Invoices.productid = Products.productid INNER JOIN\n"
            + "                         invoicedetail ON Invoices.invoiceid = invoicedetail.invoiceid AND Products.productid = invoicedetail.productid"
            +" WHERE FeeAccount.AccountId=?";

    public InvocesPrintDAO() {
        con = new DBConnect().getCon();
    }
    public List<InvoicesPrint> readByUserid(int accountid){
        List<InvoicesPrint> list = new ArrayList<>();
        try {
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setInt(1, accountid);
            ResultSet rs = pr.executeQuery();
            while(rs.next()){
                InvoicesPrint i = new InvoicesPrint(rs.getDate(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getInt(5));
                list.add(i);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(InvocesPrintDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
