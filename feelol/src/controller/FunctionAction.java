/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.dao.FunctionDAO;
import model.dto.Function;

/**
 *
 * @author BVMT
 */
public class FunctionAction {
    FunctionDAO dao = null;
    public FunctionAction(){
     dao = new FunctionDAO(); 
    } 
    public Function create(Function func)
    {
    return dao.create(func);
    }
    public List<Function> readAll(){
    return dao.readAll();
    }
     public boolean update(Function fun){
     return dao.update(fun);
     }
     
     public boolean delete(int FuncId){
         return dao.delete(FuncId);
     }
}
