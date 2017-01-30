/**
 * Created by lukkiddd on 1/30/2017 AD.
 */
public class Dog extends Animal {
    String name;

    public Dog(String Name) {
        super();
        this.name = new String(Name);
    }

    public Dog(String Name, int life) {
        super(life);
        this.name = new String(Name);
    }

    void talk() {
        bark();
    }

    void bark() {
        System.out.println("Bowow");
    }
}
