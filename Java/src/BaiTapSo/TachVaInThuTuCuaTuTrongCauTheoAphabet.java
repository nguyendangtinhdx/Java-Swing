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
public class TachVaInThuTuCuaTuTrongCauTheoAphabet { // 3.19

    public static void main(String[] args) {
        nhap();
    }

    static void tach(String str) {
        String[] s;
        s = str.split(" ");
        for (int i = 0; i < s.length - 1; i++) {
            for (int j = i + 1; j < s.length; j++) {
                if (s[i].compareToIgnoreCase(s[j]) > 0) {
                    String ss = s[i];
                    s[i] = s[j];
                    s[j] = ss;
                }
            }
        }
        xuat(s);
    }

    static void xuat(String[] s) {
        for (String s1 : s) {
            System.out.print(s1 + " ");
        }
    }

    static void nhap() {
        String str;
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();
        System.out.print("xau truoc khi sap xep: " + str + "\n");
        System.out.print("xau sau khi sap xep: ");
        tach(str);
        System.out.println("");
    }
}
