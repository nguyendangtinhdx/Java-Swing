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
public class DuongChayDaiNhat { // 3.7

    public static void main(String[] args) { 
        nhap();
    }

    static void nhap() {
        int[] a;
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap so phan tu cua mang: ");
        n = sc.nextInt();
        a = new int[n];
        for (int i = 0; i < a.length; i++) {
            System.out.print("nhap phan tu a[" + i + "] = ");
            a[i] = sc.nextInt();
        }
        duongChay(a);
    }

    static void display(int[] a, int[] b) {
        int max = 0;
        for (int x : b) {
            if (x > max) {
                max = x;
            }
        }
        System.out.print("mang a[]: ");
        for (int x : a) {
            System.out.print(x + " ");
        }
        System.out.println("");
        int vt = 0;
        for (int x : b) {
            if (x == max) {
                System.out.println("vi tri: " + vt + ", do dai: " + max);
            }
            vt += x;
        }
    }

    static void duongChay(int[] a) {
        int index = 0;
        int[] b = new int[a.length];
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i + 1] < a[i]) {
                b[index]++;
                index++;
            } else {
                b[index]++;
            }
        }
        display(a, b);
    }
}
