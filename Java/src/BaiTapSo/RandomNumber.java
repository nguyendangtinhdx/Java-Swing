/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiTapSo;

import java.util.Random;

/**
 *
 * @author Nguyen Dang Tinh
 */
public class RandomNumber {
    public static void main(String[] args) {
        Random x = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(x.nextInt(5) +" ");
//            System.out.println(x.nextBoolean() +" ");
//            System.out.println(x.nextDouble() +" ");

        }
    }
}
