package myUtil;
import java.util.ArrayList;
/**
 * Created by lukkiddd on 2/12/2017 AD.
 */
public class Stack {
    private static ArrayList<Integer> al = new ArrayList<Integer>();
    private static int stackSize;

    public Stack() {
        stackSize = 10;
    }

    public Stack(int x) {
        stackSize = x;
    }

    public void push(int x) {
        if(al.size() >= stackSize) {
            System.out.println("Stack is full!");
        } else {
            al.add(x);
        }
    }

    public int pop() {
        if(al.size() > 0) {
            return al.remove((al.size()- 1));
        }
        System.out.println("Stack is underflow!");
        return 0;
    }
}
