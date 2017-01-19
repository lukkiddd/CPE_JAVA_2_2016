/**
 * Created by lukkiddd on 1/19/2017 AD.
 */
public class Stack extends MyBuffer {
    private static int top;

    Stack() {
        this(10);
    }

    Stack(int x) {
        super(x);
        top = 0;
    }

    public void push(int x) {
        if(top >= items.length) {
            System.out.println("Stack is full!");
        } else {
            items[top++] = x;
        }

    }

    public int pop() {
        if(top > 0)
            return items[--top];
        System.out.println("Stack is underflow!");
        return 0;
    }

}
