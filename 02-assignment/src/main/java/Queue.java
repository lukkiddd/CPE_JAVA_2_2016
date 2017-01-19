/**
 * Created by lukkiddd on 1/19/2017 AD.
 */
public class Queue {
    private static int head = 0;
    private static int tail = 0;
    private static int count = 0;
    private static int q[];

    public Queue() {
        this(10);
    }

    public Queue(int size) {
        q = new int[size];
    }

    public static void add(int item) {
        if(count >= q.length) {
            System.out.println("Queue is full!");
        } else {
            if(tail >= q.length)
                tail = 0;

            q[tail++] = item;
            count++;
        }

    }

    public static int delete() {
        if(count <= 0 || head > tail) {
            System.out.println("Queue is empty!");
            return 0;
        }
        count--;
        if(head >= q.length)
            head = 0;
        return q[head++];

    }

}
