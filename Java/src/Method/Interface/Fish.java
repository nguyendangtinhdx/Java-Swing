package Method.Interface;

/**
 *
 * @author Nguyen Dang Tinh
 */
public class Fish implements Style{
    private int age;
    private String name;

    public Fish(int age,String name){
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
        return "giun";
    }

    @Override
    public String drink() {
        return "nuoc";
    }

    @Override
    public String hobby() {
        return "boi";
    }
    
}
