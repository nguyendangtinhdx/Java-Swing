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
public class EpKieuUpcastingDowncasting {

    public EpKieuUpcastingDowncasting() {
    }

    public void aFruit() {
        System.out.println("I'm a fruit.");
    }
}

class Banana extends EpKieuUpcastingDowncasting {

    public Banana() {
        System.out.println("I'm a banana.");
    }
}

class Apple extends EpKieuUpcastingDowncasting {

    public Apple() {

    }

    public void message() {
        System.out.println("I'm an Apple!");
    }

    public static void main(String[] args) {
        Object o = new Banana();
        Apple a = new Apple();
        o = a;
        // câu lệnh sau là không chắc chắn.
        //   Apple a1 = (Apple)new Object();
        EpKieuUpcastingDowncasting banana = new Banana();

        if (o instanceof Apple) { // để chắc chắn, làm như này nhé
            a = (Apple) o; // ép đối tượng o của Object sang Apple nếu đc
            a.message(); // hiển thị thông báo là o đã biến thành Apple
        } else // nếu không ép được thì thông báo: anh ko phải Apple em nhé !
        {
            System.out.println("OOP!, You're wrong! "
                    + "I'm a Banana!, I'm not Apple");
        }
    }
}
