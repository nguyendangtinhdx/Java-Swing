/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Method;

import java.util.Scanner;

/**
 *
 * @author Nguyen Dang Tinh
 */
public class Exeption {
    public static void main(String[] args) {
        int x;
        Scanner s = new Scanner(System.in);
//        x = s.nextInt(); // chỉ nhập kiểu Int
        try {
            x = s.nextInt(); // chỉ nhập kiểu Int

        } catch (Exception e) {
            System.out.println("Got a exception. Try again");
        }
    }
}
