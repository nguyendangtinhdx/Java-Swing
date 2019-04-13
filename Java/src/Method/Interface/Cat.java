/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Method.Interface;

/**
 *
 * @author Nguyen Dang Tinh
 */
//public class Cat implements Style{
public class Cat implements Food,Drink,Hobby{
    private int age;
    private String name;

    public Cat(int age,String name){
        this.age = age;
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String food() {
        return "ca";
    }

    @Override
    public String drink() {
        return "ruou";
    }

    @Override
    public String hobby() {
        return "phoi nang";
    }
    
}
