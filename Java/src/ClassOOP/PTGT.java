/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassOOP;

import java.io.Serializable;

/**
 *
 * @author Than
 */
public class PTGT implements PT, Serializable{
    protected  int nam, gia;
    protected  String hang, color;
    
    public PTGT(){
        nam = gia = 0;
        hang = color = "";
    }
    
    public void setHang(String h){
        this.hang = h;
    }
    
    public void setColor(String c){
        this.color = c;
    }
    
    public void setNamSX(int n){
        this.nam = n;
    }
    
    public void setGiaBan(int n){
        this.gia = n;
    }
    
    public int getGia(){
        return gia;
    }
    
    public int getNamSX(){
        return nam;
    }
    
    public String getHang(){
        return hang;
    }
    
    public String getColor(){
        return color;
    }
    
    @Override
    public String toString(){
        return (hang+"\t "+nam+"\t "+color+"\t "+gia);
    }
}
