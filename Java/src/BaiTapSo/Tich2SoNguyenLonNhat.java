/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiTapSo;

import static java.lang.Math.max;
import java.util.Scanner;

/**
 *
 * @author Nguyen Dang Tinh
 */
public class Tich2SoNguyenLonNhat { // 3.14
    //    "Các bı?c ti?n hành c?ng hai s? nguyên l?n:"
//    + "Bİ?c 1: t?m ğ? dài max trong hai xâu, sau ğó ğ?o th? t? hai xâu."
//    + "Bı?c 2: n?i thêm các s? 0 vào ğít xâu có ğ? dài nh? hõn."
//    + "Bİ?c 3: c?ng tıõng ?ng các ph?n t? c?a hai xâu"
//    + "Bİ?c 4: ğ?o l?i k?t qu? và in ra màn h?nh."

    public static void main(String[] args) {
        nhap();
    }

    static String dao(String s) {
        String s1 = "";
        for (int i = 0; i < s.length(); i++) {
            s1 += s.charAt(s.length() - 1 - i);
        }
        return s1; // chuoi sau khi dao
    }

    static String add(String s1, String s2) {
        String s = "";
        int nho = 0;
        int max = max(s1.length(), s2.length());
        s1 = dao(s1);
        s2 = dao(s2);
        for (int i = max; i > s1.length(); i--) {
            s1 += "0";
        }
        for (int i = max; i > s2.length(); i--) {
            s2 += "0";
        }
        for (int i = 0; i < max; i++) {
            int x = s1.charAt(i) - '0' + s2.charAt(i) - '0' + nho;
            s += x % 10;
            nho = x / 10;
        }
        if (nho > 0) {
            s += 1;
        }
        s = dao(s);
        return s;
    }

    static String sub(String s1, String s2) {
//     "Thao tác tr? hai s? nguyên dıõng"
//    + "Bı?c 1: n?u s? a > s? b th? l?y a-b; ngı?c l?i l?y -(b-a)."
//    + "Bı?c 2: t?m max(ğ? dài xâu s1, s2) ğ?o hai xâu."
//    + "Bı?c 3: n?i thêm s? 0 vào ğít xâu ng?n hõn."
//    + "Bı?c 4: tr? tıõng ?ng các ph?n t? xâu s1,s2."
//    + "Bı?c 5: ğ?o l?i k?t qu? và tr? v?."
        String s = "";
        if (s1.compareTo(s2) >= 0) {
            int nho = 0;
            s1 = dao(s1);
            s2 = dao(s2);
            int max = max(s1.length(), s2.length());
            for (int i = max; i > s2.length(); i--) {
                s2 += "0";
            }
            for (int i = 0; i < max; i++) {
                int x = 0;
                if (s1.charAt(i) - '0' < s2.charAt(i) - '0') {
                    x = s1.charAt(i) - '0' - (s2.charAt(i) - '0') + 10 - nho;
                    nho = 1;
                } else {
                    x = s1.charAt(i) - '0' - (s2.charAt(i) - '0') - nho;
                    nho = 0;
                }
                s += x;
            }
        } else {
            s = sub(s2, s1);
            s = dao(s);
            s += "-";
        }
        s = dao(s);
        return s;
    }

    static String mul(String s1, String s2) {
        String s = "";
        int array[] = new int[s1.length() + s2.length()];
        for (int i = s1.length() - 1; i >= 0; i--) {
            for (int j = s2.length() - 1; j >= 0; j--) {
                array[i + j + 1] += (s1.charAt(i) - '0') * (s2.charAt(j) - '0');
            }
        }

        for (int i = s1.length() + s2.length() - 1; i > 0; i--) {
            if (array[i] > 9) {
                array[i - 1] += array[i] / 10;
                array[i] %= 10;
            }
        }
        for (int i = 0; i < s1.length() + s2.length(); i++) {
            s += array[i];
        }
        return s;
    }

    static void nhap() {
        String s1, s2;
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap hai so nguyen: ");
        s1 = sc.next();
        s2 = sc.next();
        String s = add(s1, s2);
        System.out.print("tong hai so nguyen: " + s);
        String ss = sub(s1, s2);
        System.out.println("\nhieu hai so nguyen: " + ss);
        String ss1 = mul(s1, s2);
        System.out.print("tich hai so : " + ss1);
        System.out.println("");
    }
}
