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
import model.dto.Product;
import utils.DBConnect;

/**
 *
 * @author USER
 */
public class ProductDAO {
    private String SQLREADALL = "SELECT * FROM PRODUCTS";
    private String SQLCREATE = "INSERT INTO PRODUCTS VALUES (?,?,?,?,?)";
    private String SQLUPDATE = "UPDATE PRODUCTS SET PRODUCTID = ?,NAME = ?, PRODUCERID = ?,PRICE = ?,QUANTITY = ?";
    private String SQLDELETE = "DELETE FROM PRODUCT WHERE PRODUCTID = ?";
    Connection con;
    public ProductDAO(){
        con =new DBConnect().getCon();
    }
    public List<Product> readAll(){
        List<Product> list = new ArrayList<>();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(SQLREADALL);
            if(rs!=null){
                while(rs.next()){
                    Product p = new Product();
                    p.setProductid(rs.getInt(1));
                    p.setName(rs.getString(2));
                    p.setProducerid(rs.getInt(3));
                    p.setPrice(rs.getFloat(4));
                    p.setQuantity(rs.getInt(5));
                    list.add(p);
                }
            }
                return list;
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    public Product create(Product a){
        try {
            PreparedStatement pr = con.prepareStatement(SQLCREATE);
            pr.setInt(1,a.getProductid());
            pr.setString(2,a.getName());
            pr.setInt(3,a.getProducerid());
            pr.setFloat(4,a.getPrice());
            pr.setInt(5,a.getQuantity());
            pr.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public boolean update(Product a){
            try {
            PreparedStatement pr = con.prepareStatement(SQLCREATE);
            pr.setInt(1,a.getProductid());
            pr.setString(2,a.getName());
            pr.setInt(3,a.getProducerid());
            pr.setFloat(4,a.getPrice());
            pr.setInt(5,a.getQuantity());
            pr.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean delete(int Productid){
        try {
            PreparedStatement pr = con.prepareStatement(SQLDELETE);
            pr.setInt(1, Productid);
            pr.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }
}
