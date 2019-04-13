/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.dao.InvoicedetailDAO;
import model.dto.Invoicedetail;

/**
 *
 * @author USER
 */
public class InvoicedetailAction {
    InvoicedetailDAO dao = null;
    public InvoicedetailAction(){
        dao = new InvoicedetailDAO();
    }
    public Invoicedetail create(Invoicedetail in){
        return dao.create(in);
    }
    public List<Invoicedetail> readAll(){
        return dao.readAll();
    }
    public boolean update(Invoicedetail a){
        return dao.update(a);
    }
    public boolean delete(int a){
        return dao.delete(a);
    }
    
    
    
}
