/**
 * Created by lukkiddd on 1/19/2017 AD.
 */
public class Queue extends MyBuffer {
    private static int head;
    private static int tail;
    private static int count;


    Queue() {
        this(10);
    }

    Queue(int x) {
        super(x);
        head = 0;
        tail = 0;
        count = 0;
    }

    public void add(int item) {
        if(count >= items.length) {
            System.out.println("Queue is full!");
        } else {
            if(tail >= items.length)
                tail = 0;

            this.items[tail++] = item;
            count++;
        }
    }

    public int delete() {
        if(count <= 0) {
            System.out.println("Queue is empty!");
            return 0;
        }
        count--;
        if(head >= items.length)
            head = 0;
        return items[head++];

    }

}