/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassOOP;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Than
 */
public class Ex {
    private ArrayList<PT> list;
    
    public Ex(){
        list = new ArrayList();
    }
    
    public static void main(String[] args) {
        Ex ex = new Ex();
        ex.ghi();
        
    }
    
    public void ghi(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("D.DAT")))){
             oos.writeObject(list);
             System.out.println("write file success.");
         } catch(Exception e){
             System.out.println("Got an exception in write file.");
         }
    }
}
