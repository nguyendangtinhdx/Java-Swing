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
public class Function implements Serializable{
    private int funtionId;
    private String funtionName;
    private String description;

    public Function() {
    }

    public Function(int funtionId, String funtionName, String description) {
        this.funtionId = funtionId;
        this.funtionName = funtionName;
        this.description = description;
    }

    public int getFuntionId() {
        return funtionId;
    }

    public void setFuntionId(int funtionId) {
        this.funtionId = funtionId;
    }

    public String getFuntionName() {
        return funtionName;
    }

    public void setFuntionName(String funtionName) {
        this.funtionName = funtionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
}
