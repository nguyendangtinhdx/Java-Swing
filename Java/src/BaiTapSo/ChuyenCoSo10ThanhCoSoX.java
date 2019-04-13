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
public class ChuyenCoSo10ThanhCoSoX { //3.12

    public static void main(String[] args) {
        nhap();
    }

    static void nhap() {
        int n, b;
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap n, b: ");
        n = sc.nextInt();
        b = sc.nextInt();
        String str = chuyen(n, b);
        System.out.print("gia tri " + n + " chuyen tu he 10 sang he " + b + ": ");
        xuat(str);
    }

    static void xuat(String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(str.length() - i - 1));
        }
        System.out.println("");
    }

    static String chuyen(int n, int b) {
        String str = "";
        int x = 0;
        while (n > 0) {
            x = n % b;
            n /= b;
            if (b == 16) {
                if (x == 10) {
                    str += "A";
                }
                if (x == 11) {
                    str += "B";
                }
                if (x == 12) {
                    str += "C";
                }
                if (x == 13) {
                    str += "D";
                }
                if (x == 14) {
                    str += "E";
                }
                if (x == 15) {
                    str += "F";
                }
                if (0 <= x && x < 10) {
                    str += x;
                }
            } else {
                str += x;
            }
        }
        return str;
    }
}
