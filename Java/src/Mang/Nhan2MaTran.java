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
public class Nhan2MaTran { // 3.9

    static void inIt() {
        int[][] a, b, c;
        int m, n, k;
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap co ma tran, m, n, k: ");
        m = sc.nextInt();
        n = sc.nextInt();
        k = sc.nextInt();
        a = nhap(m, n);
        b = nhap(n, k);
        System.out.println("ma tran A: ");
        xuat(a);
        System.out.println("ma tran B: ");
        xuat(b);
        System.out.println("ma tran tich: ");
        c = tich(a, b);
        xuat(c);
    }

    static int[][] tich(int[][] a, int[][] b) {
        int[][] x = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int l = 0; l < a[0].length; l++) {
                    x[i][j] += a[i][l] * b[l][j];
                }
            }
        }
        return x;
    }

    static int[][] nhap(int m, int n) {
        int[][] result = new int[m][n];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("nhap phan tu x[" + i + "][" + j + "]= ");
                result[i][j] = sc.nextInt();
            }
        }
        return result;
    }

    static void xuat(int[][] a) {
        for (int[] x : a) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        inIt();
    }
}
