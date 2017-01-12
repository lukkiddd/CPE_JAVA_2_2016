public class main {
    private static int top = 0;
    private static int st[] = new int[10];

    public static void main(String args[]) {
        int j;

        for(j = 0; j <= 10; j++) {
            push(j + 1);
        }
        for(j = 0; j <= 10; j++) {
            System.out.println(pop());
        }
    }

    private static void push(int x) {
        System.out.println(st.length);

        if(top >= st.length) {
            System.out.println("Stack is full");
        } else {
            st[top++] = x;
        }
    }

    private static int pop() {
        if(top > 0)
            return st[--top];
        System.out.println("Stack under flow");
        return 0;
    }

}