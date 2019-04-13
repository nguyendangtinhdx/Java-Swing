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
public class TimTuDaiNhatVaViTriCuaNoTrongXau {// 3.16

    public static void main(String[] args) {
        nhap();
    }

    static void nhap() {
        String s;
        Scanner sc = new Scanner(System.in);
        s = sc.nextLine();
        System.out.print("xau vua nhap: " + s + "\n");
        timMax(s);
    }

    static void timMax(String s) {
        int[] len;
        String[] ss;
        ss = s.split(" ");
        len = new int[ss.length];
        int max = 0;
        for (int i = 0; i < ss.length; i++) {
            int l = ss[i].length();
            len[i] = l;
            if (l > max) {
                max = l;
            }
        }

        int count = 0;
        for (int i = 0; i < ss.length; i++) {
            if (len[i] == max) {
                System.out.print(ss[i]);
                System.out.println(", vi tri: " + count);
            }
            count += len[i] + 1;
        }

    }
}
