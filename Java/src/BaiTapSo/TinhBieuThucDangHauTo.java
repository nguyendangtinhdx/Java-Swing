/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiTapSo;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Nguyen Dang Tinh
 */
public class TinhBieuThucDangHauTo {

    /*  Bước 1: Nhập vào biểu thức hậu tố ở dạng String.
    
        Bước 2: Tính toán: cho biến chạy i chạy tử đầu tới cuối biểu thức, nếu kí tự tại i khác rỗng:
    
            Bước 2.1: Nếu kí tự i là một thành phần của toán hạng, lưu vào giá trị toán hạng;
                     Kiểm tra phần tử tiếp theo nếu không là thành phần của toán hạng 
                     thì push toán hạng hiện tại vào Stack; thiết lập lại giá trị toán hạng;
    
           Bước 2.2: Nếu giá trị kí tự i là toán tử, pop hai phần tử đầu Stack ra tính toán, push lại
                     kết quả vào stack;
    
        Bước 3: Xuất ra kết quả là giá trị còn lại trong Stack; 
    
        --> The End!         
     */

    public static void main(String[] args) {
        String str = new Scanner(System.in).nextLine(); // nhập vào biểu thức dạng hậu tố từ keyboard
        double res = 0; // khởi tạo giá trị toán hạng của biểu thức
        Stack s = new Stack(); // tạo ra một stack để lưu giá trị toán hạng và giá trị tính toán
        for (int i = 0; i < str.length(); i++) { // cho i chạy từ đầu tới cuối biểu thức
            char c = str.charAt(i); // lấy giá trị kí tự hiện tại
            if (c != ' ') { // nếu kí tự hiện tại khác rỗng (khoảng trắng)
                if (c - '0' >= 0 && c - '0' <= 9) { // trường hợp nếu kí tự là thành phần của toán hạng
                    res = res * 10 + c - '0'; // hoàn tất giá trị cho toán hạng đang xét
                    if (i < str.length() - 1) {//  nếu chưa chạy tới phần tử cuối cùng
                        int temp = str.charAt(i + 1) - '0';// lấy giá trị phần tử tiếp theo
                        if (temp > 9 || temp < 0) { // nếu nó không phải giá trị toán hạng
                            s.push(res); // đưa toán hạng hiện tại vào stack vì toán hạng đã đầy đủ
                            res = 0; // reset giá trị toán hạng để tìm toán hạng kế tiếp
                        }
                    }
                } else { // nếu kí tự hiện tại là một toán tử ( + - * / ^ );
                    double a, b; // lưu giá trị để tính toán
                    b = (double) s.pop(); // lấy phần tử đầu stack
                    a = (double) s.pop(); // tương tự trên

                    if (c == '+') {
                        s.push(a + b); // nếu là toán tử + thì đưa tổng a+b vào stack
                    }
                    if (c == '-') {
                        s.push(a - b); // tương tự cho toán tử còn lại
                    }
                    if (c == '*') {
                        s.push(a * b);
                    }
                    if (c == '/') {
                        s.push(a / b);
                    }
                    if (c == '^') {
                        s.push(Math.pow(a, b));
                    }
                }
            }
        } // sau khi vòng for kết thúc, phần tử còn lại trong stack chính là giá trị của biểu thức dạng hậu tố
        System.out.println("Gia tri bieu thuc hau to " + str + " = " + s.pop()); // ta lôi nó ra để coi mặt !!
    }
    // Triệu Thân @Pro - let's grow together!
    // Chúc các bạn học tốt !
}
