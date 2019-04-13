/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hocjava;

/**
 *
 * @author Nguyen Dang Tinh
 */
public class Diff {
    public static void main(String[] args){
        HocJava ex1 = new HocJava(22,"Bi","Quảng Ninh","0000000");
        ex1.xuat();
        HocJava.mark=100;
        ex1.address = "Ha Noi";
        ex1.age = 55;
        ex1.name = "Phong";
        ex1.xuat();
    }
}
