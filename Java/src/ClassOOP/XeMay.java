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
public class XeMay extends PTGT{
    private int congSuat;
    public XeMay(){
        congSuat = 0;
    }
    
    public void setCongSuat(int c){
        this.congSuat = c;
    }
    
    public int getCongSuat(){
        return congSuat;
    }
    
    @Override
    public String toString(){
        return (super.toString()+"\t " + congSuat);
    }
}
