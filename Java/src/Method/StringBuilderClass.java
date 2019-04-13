/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Method;

/**
 *
 * @author Nguyen Dang Tinh
 */
public class StringBuilderClass {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder("Hello Nguyen Dang Tinh");
        System.out.println("Noi dung:" +s.toString());
        System.out.println("Size:" +s.length());
        System.out.println("Them vao cuoi:" +s.append(" BI"));
        System.out.println("Sau khi chen:" +s.insert(0, "55555"));
        System.out.println("Sau khi sua:" +s.replace(0, 4, "Tinh Bi"));
        System.out.println("Sau khi dao:" +s.reverse());
    }
}
