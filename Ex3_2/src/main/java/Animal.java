/**
 * Created by lukkiddd on 1/30/2017 AD.
 */
public abstract class Animal {
    int life;

    public Animal() {
        this(100);
    }

    public Animal(int life) {
        this.life = life;
    }

    abstract void talk();
}
