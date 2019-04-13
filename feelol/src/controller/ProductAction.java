/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.dao.ProductDAO;
import model.dto.Product;

/**
 *
 * @author USER
 */
public class ProductAction {
    ProductDAO dao = null;

    public ProductAction() {
        dao = new ProductDAO();
    }
    public List<Product> readAll(){
        return dao.readAll();
    }
    public Product create(Product a){
        return dao.create(a);
        
    }
    public boolean update(Product b){
        return dao.update(b);
    }
    public boolean delete(int productid)
    {
        return dao.delete(productid);
    }
}
