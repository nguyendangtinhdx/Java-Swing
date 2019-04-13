/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiTapSo;

import java.util.Scanner;

/**
 *
 * @author Nguyen Dang Tinh
 */
public class DaoKiTuHoTen {//3.17

    public static void main(String[] args) {
        nhap();
    }

    static void nhap() {
        String s;
        Scanner sc = new Scanner(System.in);
        s = sc.nextLine();
        System.out.print("xau ban dau: " + s + "\n");
        tach(s);
        System.out.println("");
    }

    static void tach(String s) {
        String[] ss;
        ss = s.split(" ");
        System.out.print("xau sau khi dao: " + ss[ss.length - 1] + " ");
        for (int i = 1; i < ss.length - 1; i++) {
            System.out.print(ss[i] + " ");
        }
        System.out.print(ss[0]);
    }
}
