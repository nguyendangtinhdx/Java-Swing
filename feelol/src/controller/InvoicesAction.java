/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.dao.InvoicesDAO;
import model.dto.Invoices;

/**
 *
 * @author USER
 */
public class InvoicesAction {

    InvoicesDAO dao;

    public InvoicesAction() {
        dao = new InvoicesDAO();
    }

    public Invoices create(Invoices a) {
        return dao.create(a);
    }
    public List<Invoices> readAll(){
        return dao.readAll();
    }
    public boolean update(Invoices a){
        return dao.update(a);
    }
    public boolean delete(int in){
        return dao.delete(in);
    }
    
    

}
