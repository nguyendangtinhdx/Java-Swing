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
public class Chen1MangVaoViTriTruocCuaMangKhac { // 3.5

    static void nhap() {
        int[] a, b;
        int m, n;
        int k;
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap so phan tu mang b[]: ");
        n = sc.nextInt();
        System.out.print("nhap so phan tu mang a[]: ");
        m = sc.nextInt();
        b = new int[n];
        a = new int[m + n];
        for (int i = 0; i < m; i++) {
            System.out.print("nhap cac phan tu mang a[]: ");
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            System.out.print("nhap b[" + i + "]= ");
            b[i] = sc.nextInt();
        }
        System.out.print("nhap vi tri can chen: ");
        k = sc.nextInt();
        System.out.print("mang a[]: ");
        for (int i = 0; i < m; i++) {
            System.out.print(a[i] + " ");
        }
        chen(a, b, m, k);
    }

    static void chen(int[] a, int[] b, int m, int k) {
        if (k >= m) {
            for (int i = 0; i < b.length; i++) {
                a[i + m] = b[i];
            }
        } else if (k <= 0) {
            for (int i = a.length - 1; i >= b.length; i--) {
                a[i] = a[i - b.length];
            }
            for (int i = 0; i < b.length; i++) {
                a[i] = b[i];
            }
        } else {
            for (int i = a.length - 1; i >= b.length + k; i--) {
                a[i] = a[i - b.length];
            }
            for (int i = k; i < k + b.length; i++) {
                a[i] = b[i - k];
            }
        }
        display(a, b);
    }

    static void display(int[] a, int[] b) {
        System.out.print("mang b[]: ");
        for (int x : b) {
            System.out.print(x + " ");
        }
        System.out.println("");
        System.out.print("mang sau khi chen: ");
        for (int x : a) {
            System.out.print(x + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        nhap();
    }

}
