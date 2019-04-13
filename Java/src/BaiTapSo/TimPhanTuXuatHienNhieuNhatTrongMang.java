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
public class TimPhanTuXuatHienNhieuNhatTrongMang { // 3.2 trong Youtube

    static void display(int[] a) {
        int max = 0;
        int[] b = new int[a.length]; // tao mang b co a.length phan tu = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (a[i] == a[j]) {
                    b[i]++;
                }
            }
        }
        // tim gia tri max
        max = b[0];
        for (int i = 1; i < a.length; i++) {
            if (b[i] > max) {
                max = b[i]; // tim dc phan tu co so lan xuat hien max
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
        for (int i = 0; i < a.length; i++) {
            if (b[i] == max) {
                System.out.println("phan tu " + a[i] + " co so lan xuat hien la " + max);
            }
        }
    }

    static void nhap() {
        int[] a;
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap so phan tu mang a[]: ");
        n = sc.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("nhap phan tu a[" + i + "]= ");
            a[i] = sc.nextInt();
        }
        display(a);
    }

    public static void main(String[] args) {
        nhap();
    }
}
