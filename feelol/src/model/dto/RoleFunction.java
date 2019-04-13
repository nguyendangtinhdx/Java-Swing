/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dto;

import java.io.Serializable;

/**
 *
 * @author BVMT
 */
public class RoleFunction implements Serializable{
    private int iD;
    private int roleID;
    private int funtionID;

    public RoleFunction() {
    }

    public RoleFunction(int iD, int roleID, int funtionID) {
        this.iD = iD;
        this.roleID = roleID;
        this.funtionID = funtionID;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public int getFuntionID() {
        return funtionID;
    }

    public void setFuntionID(int funtionID) {
        this.funtionID = funtionID;
    }
    
    
    
}
