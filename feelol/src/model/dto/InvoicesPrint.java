/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dto;

import java.util.Date;

/**
 *
 * @author USER
 */
public class InvoicesPrint{
    Date datesell;
    String username;
    String namep;
    float price;
    int quantity;

    public InvoicesPrint() {
    }

    public InvoicesPrint(Date datesell, String username, String namep, float price, int quantity) {
        this.datesell = datesell;
        this.username = username;
        this.namep = namep;
        this.price = price;
        this.quantity = quantity;
    }

    public Date getDatesell() {
        return datesell;
    }

    public void setDatesell(Date datesell) {
        this.datesell = datesell;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNamep() {
        return namep;
    }

    public void setNamep(String namep) {
        this.namep = namep;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
