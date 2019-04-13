/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiTapSo;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import java.util.Scanner;

/**
 *
 * @author Nguyen Dang Tinh
 */
public class PhanTuNguyenToCoGiaTriGanNhat { // 3.3

    static boolean ngTo(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    static void display(int[] a, int x) {
        int temp = 0;
        for (int i = 0; i < a.length; i++) {
            if (ngTo(a[i])) {
                temp = a[i]; // luu gia tri nguyen to dau tien
                break;
            }
        }

        for (int i = 0; i < a.length; i++) {
            if (ngTo(a[i]) && (abs(a[i] - x) < abs(temp - x))) {
                temp = a[i]; // tim a[i] gan x nhat, a[i] ngto
            }
        }
        System.out.print("mang a[]: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");

        for (int i = 0; i < a.length; i++) {
            if (ngTo(a[i]) && (abs(a[i] - x) == abs(temp - x))) {
                System.out.println("vi tri thu " + i);
            }
        }
    }

    static void nhap() {
        int[] a;
        int n, x;
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap so phan tu mang: ");
        n = sc.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("nhap phan tu a[" + i + "]= ");
            a[i] = sc.nextInt();
        }
        System.out.print("nhap x= ");
        x = sc.nextInt();
        display(a, x);
    }

    public static void main(String[] args) {
        nhap();
    }
}
