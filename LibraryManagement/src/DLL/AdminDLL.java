/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import DAL.AdminDAL;

/**
 *
 * @author Nguyen Dang Tinh
 */
public class AdminDLL {
    AdminDAL dal = new AdminDAL();
    public boolean getLogin(String u, String p){
        return dal.getLogin(u,p);
    }
}
