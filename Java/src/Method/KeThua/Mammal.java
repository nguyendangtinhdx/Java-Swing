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
public class Mammal {
    private int age;
    private double weight;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    public void moving(String s){
        System.out.println(s);
    }
    
    public void eating(String s){
        System.out.println(s);
    }
}
