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
// final là k cho lớp B kế thừa
final class AA {
    private final int X = 100;
    public void display(){
        System.out.println("Class A");
//        X = 200; // bao loi k dc gan
    }
    public double add(double a,double b){
        return a + b;
    }
}
class BB extends A{
    @Override
    public void display(){
        System.out.println("Class B");
    }
    public void who(){
        System.out.println("Who method in class B");
    }
}
class CC extends B{
    @Override
    public void display(){
        System.out.println("Class C");
    }
    public void who(){
        System.out.println("Who method in class C");
    }
    public static void main(String[] args) {
        CC c = new CC();
        c.display();
    }
}
