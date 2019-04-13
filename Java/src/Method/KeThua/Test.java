/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Method.KeThua;

/**
 *
 * @author Nguyen Dang Tinh
 */
public class Test {

    public static void main(String[] args) {

        Mammal mammal = new Mammal();
        mammal.setAge(3);
        mammal.setWeight(5.5);
        System.out.println("the mammal is " + mammal.getAge() + " years old.");
        System.out.println("he is " + mammal.getWeight() + " kg");
        mammal.moving("The mammal is moving");
        mammal.eating("the mammal is eating");
        System.out.println("");

        Dog puppy = new Dog();
        puppy.setAge(3);
        puppy.setWeight(5.5);
        System.out.println("the puppy is " + puppy.getAge() + " years old.");
        System.out.println("he is " + puppy.getWeight() + " kg");
        puppy.moving("The puppy is moving");
        puppy.eating("the puppy is eating");
        puppy.wagging();
        puppy.barking();
        System.out.println("");

        Horse blackHorse = new Horse();
        blackHorse.setAge(5);
        blackHorse.setWeight(100);
        blackHorse.setColor("black");
        System.out.println("The horse's color is " + blackHorse.getColor());
        System.out.println("He is " + blackHorse.getAge() + " years old.");
        System.out.println("He is " + blackHorse.getWeight() + "kg.");
        blackHorse.eating("He is eating grass.");
        blackHorse.moving("The horse is running very fast!");
    }
}
