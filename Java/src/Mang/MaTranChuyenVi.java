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
public class MaTranChuyenVi { // 3.8

    public static void main(String[] args) {
        nhap();
    }

    static void nhap() {
        int[][] a;
        int m, n;
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap m, n: ");
        m = sc.nextInt();
        n = sc.nextInt();
        a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("nhap a[" + i + "]= ");
                a[i][j] = sc.nextInt();
            }
        }
        System.out.println("ma tran A: ");
        display(a);
        chuyenVi(a);
    }

    static void chuyenVi(int[][] a) {
        int[][] b = new int[a[0].length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                b[j][i] = a[i][j];
            }
        }
        System.out.println("ma tran chuyen vi: ");
        display(b);
    }

    static void display(int[][] a) {
        for (int[] x : a) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println("");
        }
    }
}
