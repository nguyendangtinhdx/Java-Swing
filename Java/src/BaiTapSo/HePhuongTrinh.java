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
public class HePhuongTrinh {

    public static void main(String[] args) {
        /*
            giải hệ phương trình nhiều ẩn theo phương pháp Cramer - sử dụng định thức.
            - nếu hệ có số pt ít hơn số ẩn => hệ vô số nghiệm.
            - nếu hệ  có tất cả định thức chính và định thức thứ i = 0, hệ có thể có vô số hoặc vô nghiệm
            - nếu hệ có định thức chính = 0, tồn tại định thức thứ i nào đó khác 0 thì hệ vô nghiệm.
            - nếu hệ có định thức chính khác 0, hệ có nghiệm duy nhất.
        Nội dung thực hiện:
            nhập vào ma trận hpt.
            tiến hành tính các định thức thứ i và định thức chính.
            kết luận nghiệm dựa trên định thức theo những điều kiện trên.
         */
        int[][] arr = nhap();
        giaiHe(arr);
    }

    static void giaiHe(int[][] arr) { // tiến hành giải hệ
        int d1 = arr.length;
        int d2 = arr[0].length;
        if (d2 > d1 + 1) {
            System.out.println("vo so nghiem.");
        } else {
            int[] d = new int[d1];
            for (int i = 0; i < d1; i++) {
                d[i] = arr[i][d2 - 1];
            }
            int[][] matrix = copy(arr);
            int res = det(matrix);
            int[] dt = new int[d1];
            for (int k = 0; k < d1; k++) {
                int[][] matrix1 = copy(arr);
                for (int i = 0; i < d1; i++) {
                    matrix1[i][k] = d[i];
                }
                dt[k] = det(matrix1);
            }

            boolean b = false;
            for (int i = 0; i < d1; i++) {
                if (dt[i] != 0) {
                    b = true;
                    break;
                }
            }

            if (b && res == 0) {
                System.out.println("he vo nghiem");
            } else if (!b && res == 0) {
                System.out.println("vo nghiem hoac vo so nghiem");
            } else {
                for (int i = 0; i < d1; i++) {
                    System.out.println("x" + i + "= " + (double) dt[i] / res);

                }
            }
        }
    }

    static int[][] copy(int[][] arr) {
        int[][] a = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                a[i][j] = arr[i][j];
            }
        }
        return a;
    }

    static int[][] nhap() { // nhập vào thông tin ma trận của hệ
        int m, n;
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao ma tran phuong trinh: ");
        m = sc.nextInt();
        n = sc.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("a[" + i + "][" + j + "] = ");
                arr[i][j] = sc.nextInt();
            }

        }
        return arr;
    }

    static int det(int[][] arr) { // tính và trả về định thức 
        if (arr.length == 1) {
            return arr[0][0];
        }
        if (arr.length == 2) {
            return arr[0][0] * arr[1][1] - arr[0][1] * arr[1][0];
        } else {

            int res = 0;
            for (int k = 0; k < arr.length; k++) {
                int[][] smaller = new int[arr.length - 1][arr.length - 1];
                for (int i = 0; i < arr.length; i++) {
                    for (int j = 1; j < arr.length; j++) {
                        if (i < k) {
                            smaller[i][j - 1] = arr[i][j];
                        } else if (i > k) {
                            smaller[i - 1][j - 1] = arr[i][j];
                        }
                    }
                }
                int s = -1;
                if (k % 2 == 0) {
                    s = 1;
                }
                res += arr[k][0] * s * det(smaller);
            }
            return res;
        }
    }
}
