/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Method.Interface;

import com.oracle.webservices.internal.api.EnvelopeStyle.Style;

/**
 *
 * @author Nguyen Dang Tinh
 */
public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat(3,"Tom");
        Bird bird = new Bird(5,"Kitty");
        Fish fish = new Fish(10,"Dophil");
        Style temp;
        Food f;
        Drink d;
        Hobby h;
        System.out.println(cat.getName() + " " + cat.getAge() + " Thich an: " + cat.food() + " Uong: " + cat.drink() + " So thich: " +
                cat.hobby());
        f = cat;
        d = cat;
        h = cat;
        System.out.println(cat.getName() + " " + cat.getAge() + " Thich an: " + f.food() + " Uong: " + d.drink() + " So thich: " +
                h.hobby());
    }
}
