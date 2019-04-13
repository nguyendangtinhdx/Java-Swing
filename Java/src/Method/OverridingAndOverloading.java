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
class M {

    public M() {
        System.out.println("This is constructor of class A");
    }

    public void display(String s) {
        System.out.println("display a string in class A, s= " + s);
    }

    public static void a(int x) {
        System.out.println("in class A, x = " + x);
    }

    public static void a(double x) {
        System.out.println("in class A, x = " + x);
    }
}

public class OverridingAndOverloading extends M {

    public OverridingAndOverloading() {
        System.out.println("This is constructor of class B");
    }

    public void display(int x) {
        System.out.println("x= " + x);
    }

    public void display(double x) {
        System.out.println("x= " + x);
    }

    @Override
    public void display(String s) {
        super.display(s);
        System.out.println("display a string in class B, s = " + s);
    }

    public static void main(String[] args) {
        OverridingAndOverloading b = new OverridingAndOverloading();
        M a = new M();
        a.a(10);
        a.a(100.02);
//        b.display("Hello Java!");
//        b.display(100);
//        b.display(123.456);
    }
}
