/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mang;

import java.util.Scanner;

/**
 *
 * @author Nguyen Dang Tinh
 */
public class NhapXuatThemXoaSapXep {

    private int a[];
    private int n;

    public void nhap() {
        Scanner x = new Scanner(System.in);
        System.out.print("Nhap so phan tu: ");
        n = x.nextInt();

        a = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "]= ");
            a[i] = x.nextInt();
        }
    }

    public void in() {
        System.out.print("Mang vua tao: ");
        for (int i = 0; i < n; i++) {
            System.out.print(" " + a[i] + " ");
        }
    }

    public void xoa(int x) {
        for (int i = 0; i < n; i++) {
            if (x == a[i]) {
                for (int j = i; j < n - 1; j++) {
                    a[j] = a[j + 1];
                }
                n--;
            }
        }
    }

    public void chen(int x, int vt) {
        for (int i = n - 1; i >= vt; i--) {
            a[i] = a[i - 1];
        }
        a[vt] = x;
//        n++;
    }

    public void sapxep() {
        int x;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] > a[j]) {
                    x = a[i];
                    a[i] = a[j];
                    a[j] = x;
                }
            }
        }
    }

    public static void main(String[] args) {
        NhapXuatThemXoaSapXep x = new NhapXuatThemXoaSapXep();
        x.nhap();
        x.in();

        Scanner t = new Scanner(System.in);
        System.out.println("");
        System.out.println("Nhap phan tu can xoa: ");
        int y = t.nextInt();
        x.xoa(y);
        System.out.println("Mang sau khi xoa: ");
        x.in();

//        System.out.println("");
//        System.out.println("Nhap vi tri can chen: ");
//        int m = t.nextInt();
//        System.out.println("Nhap gia tri can chen: ");
//        int n = t.nextInt();
//        x.chen(m, n);
//        n++;
//        System.out.println("NhapXuatThemXoaSapXep sau khi chen: ");
//        x.in();
        System.out.println("");
        System.out.println("Mang sau khi sap xep: ");
        x.sapxep();
        x.in();
    }
}
