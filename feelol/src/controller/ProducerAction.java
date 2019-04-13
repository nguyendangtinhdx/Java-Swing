/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.dao.ProducerDAO;
import model.dto.Producer;

/**
 *
 * @author USER
 */
public class ProducerAction {
    ProducerDAO dao;
    public ProducerAction(){
    dao = new ProducerDAO();
    }
    public List<Producer> readALl(){
        return dao.readAll();
    }
    public Producer create(Producer a){
        return dao.create(a);
    }
    public boolean update(Producer a){
        return dao.update(a);
    }
    public boolean delete(int i){
        return dao.delete(i);
    }
    
    
}
