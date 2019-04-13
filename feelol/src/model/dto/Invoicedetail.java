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
public class Invoicedetail {
    private int invoicedetailid;
    private int productid;
    private int invoiceid;
    private int quantity;

    public Invoicedetail(int invoicedetailid, int productid, int invoiceid, int quantity) {
        this.invoicedetailid = invoicedetailid;
        this.productid = productid;
        this.invoiceid = invoiceid;
        this.quantity = quantity;
    }
    public Invoicedetail(){}

    public int getInvoicedetailid() {
        return invoicedetailid;
    }

    public void setInvoicedetailid(int invoicedetailid) {
        this.invoicedetailid = invoicedetailid;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public int getInvoiceid() {
        return invoiceid;
    }

    public void setInvoiceid(int invoiceid) {
        this.invoiceid = invoiceid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
