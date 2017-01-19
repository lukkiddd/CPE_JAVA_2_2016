/**
 * Created by lukkiddd on 1/19/2017 AD.
 */
public class Stack {
    private static int top = 0;
    private static int st[];

    public Stack() {
        this(10);
    }

    public Stack(int size) {
        st = new int[size];
    }

    public static void push(int item) {
        if(top >= st.length) {
            System.out.println("Stack is full!");
        } else {
            st[top++] = item;
        }

    }

    public static int pop() {
        if(top > 0)
            return st[--top];
        System.out.println("Stack is underflow!");
        return 0;
    }

}
