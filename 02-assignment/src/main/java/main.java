/**
 * Created by lukkiddd on 1/19/2017 AD.
 */
public class main {

    public static void main(String args[]) {
        int i;
        Queue q = new Queue(10);
        Stack st = new Stack(10);

        for(i = 0; i <= 10; i++) {
            st.push(i);
            q.add(i);
        }
        for(i = 0; i <= 10; i++) {
            System.out.printf("%d %d\n",st.pop(),q.delete());
        }

    }
}
