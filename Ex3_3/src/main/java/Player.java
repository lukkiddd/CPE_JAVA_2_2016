/**
 * Created by lukkiddd on 1/30/2017 AD.
 */
public class Player {
    private int number = 0;
    boolean status = false;

    public int guess() {
        number = (int) (Math.random() * 10);

        System.out.println("I'm guessing " + number);

        return number;
    }
}
