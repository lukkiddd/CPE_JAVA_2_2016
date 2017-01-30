/**
 * Created by lukkiddd on 1/30/2017 AD.
 */
public class Human extends Animal {
    String name;

    public Human(String Name) {
        super();
        this.name = new String(Name);
    }

    public Human(String Name, int life) {
        super(life);
        this.name = new String(Name);
    }

    void talk() {
        System.out.println("hey!!");
    }

}
