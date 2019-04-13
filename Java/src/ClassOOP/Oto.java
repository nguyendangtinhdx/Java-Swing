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
public class Oto extends PTGT {
    private String kieuDC;
    private int soCho;
    
    public Oto(){
        kieuDC = "";
        soCho = 0;
    }
    
    public void setSoCho(int s){
        this.soCho = s;
    }
    
    public void setKieuDC(String s){
        this.kieuDC = s;
    }
    
    public int getSoCho(){
        return soCho;
    }
    
    public String getKieuDC(){
        return this.kieuDC;
    }
    
    @Override
    public String toString(){
        return (super.toString()+"\t\t\t "+soCho+"\t "+kieuDC);
    }
}
