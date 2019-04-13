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
public class HocJava {

    int age;
    public String name;
    protected String address;
    private String phone;
    static double mark;
    public HocJava(int age, String name, String address, String phone)
    {
        this.age=age;
        this.name=name;
        this.address=address;
        this.phone=phone;
    }
    protected void xuat(){
        System.out.println("Ten: "+name);
        System.out.println("Tuoi: "+age);
        System.out.println("Dia Chi: "+address);
        System.out.println("SDT: "+phone);
        System.out.println("Diem: "+mark);
    }
    
    public static void main(String[] args) {
        HocJava ex = new HocJava(20,"Tỉnh","Quảng Nam","023655112");
        mark = 7.5;
        HocJava.mark = 7.5;
        ex.xuat();
        ex.age = 21;
        ex.name= "Minh";
        ex.phone= "0123456789";
        mark = 9;
        HocJava.mark = 9;
        ex.xuat();
    }
    
}
