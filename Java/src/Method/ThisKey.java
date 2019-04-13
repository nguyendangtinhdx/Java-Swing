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
public class ThisKey {

    private String name;
    private String add;
    private String phone;

    public ThisKey() {
        this("Nam ", "Da Nang ", "0845");
    }

    public ThisKey(String name, String add, String phone) {
        this.name = name;
        this.add = add;
        this.phone = phone;
        this.display();
    }

    public void display() {
        System.out.println("Name: " + this.name + "\nAdd: " + add + "\nPhone: " + phone);
    }

    public static void main(String[] args) {
        new ThisKey();
    }
}
