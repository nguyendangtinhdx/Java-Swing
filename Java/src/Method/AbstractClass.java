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
public abstract class AbstractClass { // lớp trừu tượng

    public abstract int getValue(); // phuong thuc de lay ra gia tri cua 1 so

    public abstract void ChangeValue(); // phuong thuc de thay doi gia tri cua 1 so

}

class SoChan extends AbstractClass {

    int num = 100;

    @Override
    public int getValue() {
        return num;
    }

    @Override
    public void ChangeValue() {
        num += 2;
    }
}

class SoLe extends AbstractClass{
int num = 101;
    @Override
    public int getValue() {
        return num;
    }

    @Override
    public void ChangeValue() {
        num += 2;
    }
    
}
// tạo 1 class chứa ct Main

//public class Main{
//    AbstractClass[-] Arr = new Number[5]; // dung de luu bien tham chieu cac object cua lop con
//    public static void main(String[] args){
//        AbstractClass num;
//        SoChan chan = new SoChan();
//        num = chan;
//        System.out.println("Gia tri so chan: " + num.getValue());
//        SoLe le = new SoLe();
//        num = le;
//        System.out.println("Gia tri so le: " + num.getValue());
//    }
//}