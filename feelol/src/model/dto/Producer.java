/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dto;

/**
 *
 * @author USER
 */
public class Producer {
    private int Producerid;
    private String Name;
    private String description;

    public Producer() {
    }

    public int getProducerid() {
        return Producerid;
    }

    public void setProducerid(int Producerid) {
        this.Producerid = Producerid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Producer{" + "Producerid=" + Producerid + ", Name=" + Name + ", description=" + description + '}';
    }
    
            
    
}
