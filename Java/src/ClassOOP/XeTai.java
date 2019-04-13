/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassOOP;

/**
 *
 * @author Than
 */
public class XeTai extends PTGT {
    private double trongTai;
    
    public XeTai(){
        this.trongTai = 0.0;
    }
    
    public void setTT(double t){
        this.trongTai = t;
    }
    
    public double getTrongTai(){
        return this.trongTai;
    }
    
    
    @Override
    public String toString(){
        return (super.toString()+"\t\t "+this.trongTai);
    }
}
