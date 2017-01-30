/**
 * Created by lukkiddd on 1/30/2017 AD.
 */
public class Cat extends Animal {
    String name;

    public Cat(String Name) {
        super();
        this.name = new String(Name);
    }

    public Cat(String Name, int life) {
        super(life);
        this.name = new String(Name);
    }

    void talk() {
        meow();
    }

    void meow() {
        System.out.println("meow");
    }
}
