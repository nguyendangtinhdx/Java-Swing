/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Method;

import java.math.BigInteger;

/**
 *
 * @author Nguyen Dang Tinh
 */
public class BigIntegerClass {

    public static void main(String[] args) {

        String s1 = "32132321313213232132132131321321";
        String s2 = "-2132132425335454354543545454354654";
        String s3 = "423329507025792408109";

        BigInteger b1 = new BigInteger(s1);
        BigInteger b2 = new BigInteger(s2);
        BigInteger b3 = new BigInteger(s3);

        System.out.println("Big 1 = " + b1);
        System.out.println("Big 2 = " + b2);
        System.out.println("Big 3 = " + b3);
        System.out.println("abs b2  = " + b2.abs());

        System.out.println("addition s1 + s3 = " + b1.add(b3));
        System.out.println(" subtraction b1 - b3 = " + b1.subtract(b3));
        System.out.println("multiplication b1 mul b3 = " + b1.multiply(b3));
        System.out.println("division b1 divide b3 = " + b1.divide(b3));
    }
}
