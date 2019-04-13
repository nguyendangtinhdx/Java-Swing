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
class A {

    public A() {
        System.out.println("Class A");
    }
    public void display(){
        System.out.println("This method display class A's content");
    }
}

class B extends A {

    public B() {
        super();
        System.out.println("Class B");
    }
    public void MethodCallUsingSuperKeyword(){
        super.display();
        System.out.println("This method display class B's content");
    }
}

class C extends B {

    public C() {
        System.out.println("Class C");
    }

    public static void main(String[] args) {
        C c = new C();
        c.display();
    }
    @Override
    public void display(){
        super.display();
        System.out.println("This method display class C's content");
    }
}
