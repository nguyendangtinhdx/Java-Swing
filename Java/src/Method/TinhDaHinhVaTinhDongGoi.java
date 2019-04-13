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
class A1 extends Object {

    private final int X = 100;

    public void display() {
        System.out.println("class A method.");
    }

    public double add(double a, double b) {
        return a + b;
    }
}

class B1 extends A1 {

    @Override
    public void display() {
        System.out.println("class B method.");
    }

    public void who() {
        System.out.println("who method in class B.");
    }
}

class C1 extends B1 {

    @Override
    public void display() {
        System.out.println("class C method.");
    }

    public void what() {
        System.out.println("what method in class C");
    }
}

public class TinhDaHinhVaTinhDongGoi {

    public static void main(String[] args) {
        A1 a = new A1(); // tạo ra object của class A
        B1 b = new B1(); // tạo ra object của class B
        C1 c = new C1(); // tạo ra object của class C

        a.display(); // hiên thị thông tin trong của class A

        a = b; // biến của class A tham chiếu tới đối tượng của class B
        a.display(); // hiển thị thông tin class B
        System.out.println("tong = " + a.add(0.25, 10));
        a = c; // biến của class A tham chiếu tới đối tượng của class C
        a.display(); //  hiển thị thông tin class C
    }
}
