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
public class Invoices {
    private int  invoiceid;
    private int productid;
    private int accountid;
    private Date datesell;

    public Invoices() {
    }

    public int getInvoiceid() {
        return invoiceid;
    }

    public void setInvoiceid(int invoiceid) {
        this.invoiceid = invoiceid;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public int getAccountid() {
        return accountid;
    }

    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }

    public Date getDatesell() {
        return datesell;
    }

    public void setDatesell(Date datesell) {
        this.datesell = datesell;
    }

    @Override
    public String toString() {
        return "Invoices{" + "invoiceid=" + invoiceid + ", productid=" + productid + ", accountid=" + accountid + ", datesell=" + datesell + '}';
    }
    
}
