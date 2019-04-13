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
public class ChiaDaThucChoDaThuc {

    public static void main(String[] args) {
        int[] arr1, arr2;
        arr1 = nhap();
        arr2 = nhap();
        display(arr1);
        display(arr2);

        System.out.println("Ket qua phep chia: ");
        double[] arr = chia(arr1, arr2);
        if (arr == null) {
            System.out.println("Khong chia dc");
        } else {
            display(arr);
            boolean check = false;
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] != 0) {
                    check = true;
                    break;
                }
            }
            if (check) {
                System.out.println("Phan du: ");
                display(arr1);
                System.out.println("________");
                display(arr2);
            } else {
                System.out.println("Phep chia het.");
            }
        }// vd: x^3 + 4x^2 + x - 6/ x+3;
    }

    public static int[] nhap() {
        int n;
        System.out.println("Nhap bac cua da thuc: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = n; i >= 0; i--) {
            System.out.println("he so cua x^" + (i) + "= ");
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public static void display(int[] arr) {
        if (arr != null) { // dam bao arr khong rong
            for (int i = arr.length - 1; i >= 0; i--) {
                if (i > 0) {
                    if (arr[i] != 0) {
                        if (arr[i] != 1) {
                            System.out.print(arr[i] + "x^" + i);
                        } else {
                            System.out.print("x^" + i);
                        }
                    }
                    if (arr[i - 1] > 0) {
                        System.out.print(" + ");
                    } else {
                        System.out.print(" ");
                    }
                } else {
                    if (arr[0] != 0) {
                        System.out.print(arr[i]);
                    }
                }
            }
        } else {
            System.out.println("Khong ton tai da thuc");
        }
        System.out.println("");
    }

    public static void display(double[] arr) {
        if (arr != null) {
            for (int i = arr.length - 1; i >= 0; i--) {
                if (i > 0) {
                    if (arr[i] != 0) {
                        if (arr[i] != 1) {
                            System.out.print(arr[i] + "x^" + i);
                        } else {
                            System.out.print("x^" + i);
                        }
                    }
                    if (arr[i - 1] > 0) {
                        System.out.print(" + ");
                    } else {
                        System.out.print(" ");
                    }
                } else {
                    if (arr[0] != 0) {
                        System.out.print(arr[i]);
                    }
                }
            }
        } else {
            System.out.println("Khong ton tai da thuc");
        }
        System.out.println("");
    }

    /*
    Thuật toán chia hai đa thức bất kì ( có dư, ko có dư ) sử dụng mảng một chiều trong java.
    thực hiện tương tự chia đa thức cho đa thức, chia làm các bước:
    Giả sử chỉ số phần tử là số mũ của phần tử tại i. ta xét hai trường hợp:
    TH1: nếu đa thức bị chia có bậc nhỏ hơn đa thức chia thì dừng. không chia đc.
    TH2: nếu bậc của đa thức bị chia >= bậc của đa thức chia thì thực hiện
    
    Bước 1: tạo ra mảng kết quả kiểu double, có số phần tử = ( bậc đa thức bị chia - bậc đa thức chia + 1)
    Bước 2: lặp tới khi bậc của đa thức bị chia < bậc đa thức chia:
        Buớc 2.1: lấy g.trị hệ số tương ứng của các lần chia.
        Bước 2.2: tạo mảng phụ chứa các giá trị sau mỗi lần chia bằng cách nhân hệ số kết quả tại
                  mỗi lần chia với biểu thức chia.
        Buớc 2.3: loại bỏ các phần đã chia khỏi biểu thức bị chia bằng cách trừ biểu thức bị chia
                  cho biểu thức phụ.
    Bước 3: trả về kết quả là biểu thức kết quả.
    
    ví dụ: x^2 - 2x + 1 / x - 1: kết quả trong mảng double arr[2-1+1];
    lần lặp 1: arr[1] = 1; mảng phụ: x^2 - x -> x^2 - 2x + 1
                                              -(x^2 - x)
                                              =      -x + 1
    lần lặp 2: arr[0] = -1; mảng phụ: -x + 1 -> -x + 1
                                              -(-x + 1)
                                              = 0
    kết quả chia ko có dư: x - 1;
     */

    static double[] chia(int[] arr1, int[] arr2) {
        if (arr1.length < arr2.length) {
            return null;
        } else {
            int m = arr1.length - 1;
            int n = arr2.length - 1;
            int i = m;
            double[] arr = new double[m - n + 1];

            while (i >= n) {
                arr[i - n] = (double) arr1[i] / arr2[n];
                // tao mang phu
                int[] arr3 = new int[i + 1];
                for (int j = n; j >= 0; j--) {
                    arr3[i + j - n] = (int) arr[i - n] * arr2[j];
                }
                // tru thanh phan da chia
                for (int k = i; k >= 0; k--) {
                    arr1[k] -= arr3[k];
                }

                i--;
            }

            return arr;
        }
    }
}
