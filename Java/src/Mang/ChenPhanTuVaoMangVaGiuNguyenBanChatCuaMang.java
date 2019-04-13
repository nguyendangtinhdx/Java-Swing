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
public class ChenPhanTuVaoMangVaGiuNguyenBanChatCuaMang {// 3.6

    public static void main(String[] args) {
        nhap();
    }

    static void nhap() {
        int[] a;
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap so phan tu cua mang a[]: ");
        n = sc.nextInt();
        a = new int[n + 1];
        for (int i = 0; i < a.length - 1; i++) {
            System.out.print("nhap phan tu a[" + i + "]= ");
            a[i] = sc.nextInt();
        }
        int x;
        System.out.print("nhap phan tu can chen, x = ");
        x = sc.nextInt();
        chen(a, x);
    }

    static void chen(int[] a, int x) {
        if (a[0] > x) {
            for (int i = a.length - 1; i > 0; i--) {
                a[i] = a[i - 1];
            }
            a[0] = x;
        } else if (a[a.length - 2] < x) {
            a[a.length - 1] = x;
        } else {
            int index = 0;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > x) {
                    index = i;
                    break;
                }
            }
            for (int i = a.length - 1; i > index; i--) {
                a[i] = a[i - 1];
            }
            a[index] = x;
        }
        display(a);
    }

    static void display(int[] a) {
        System.out.print("mang a[]: ");
        for (int x : a) {
            System.out.print(x + " ");
        }
        System.out.println("");
    }
}
