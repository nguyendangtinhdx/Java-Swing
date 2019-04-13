/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Method;

import java.util.Arrays;
import java.util.ArrayList;

/**
 *
 * @author Nguyen Dang Tinh
 */
public class ArrayListEx {

    public static void main(String[] args) {

        String[] arr = {"Nam", "Hung", "Hieu", "Nhan"};
        String s0, s1, s2;
        s0 = "Nam";
        s1 = "Hai";
        s2 = "Nhan";

        ArrayList<String> al = new ArrayList<>(Arrays.asList(arr)); // chuyển Mảng sang ArrayList
        System.out.println("size: " + al.size());
        System.out.println("al = " + al.toString());

        al.add(s0);
        al.add(s1);
        al.add(s2);
        System.out.println("al = " + al.toString());
        String[] name = new String[al.size()]; // Chuyển ArrayList sang Mảng
        al.toArray(name);
        for (String s : name) {
            System.out.print(s + ",");
        }
        System.out.println("");

//        al.add(1, "Tony");
//        System.out.println("al = " +al.toString());
//        System.out.println("size: " + al.size());
//        
//        al.remove("Nam");
//        System.out.println("al = " +al.toString());
//        
//        al.set(0, "Stark");
//        System.out.println("al = " +al.toString());
//        al.clear();
//        System.out.println("size: " +al.size());
    }
}
