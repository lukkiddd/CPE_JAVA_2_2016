package myUtil;
import java.util.ArrayList;
/**
 * Created by lukkiddd on 2/12/2017 AD.
 */
public class Queue {
    private static ArrayList<Integer> al = new ArrayList<Integer>();
    private static int queueSize;

    public Queue() {
        queueSize = 10;
    }

    public Queue(int x) {
        queueSize = x;
    }

    public void add(int x) {
        if(al.size() >= queueSize) {
            System.out.println("Queue is full!");
        } else {
            al.add(x);
        }
    }

    public int delete() {
        if(al.size() > 0) {
            return al.remove(0);
        }
        System.out.println("Queue is empty!");
        return 0;
    }
}
