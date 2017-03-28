import java.io.*;

/**
 * Created by lukkiddd on 3/28/2017 AD.
 */
public class main {

    public static void main(String args[]) {
        BSTNode<Integer> a,b;
        BSTTree<Integer> root;
        ObjectOutputStream oos;
        FileOutputStream fos;
        String filename = "bt.bst";
        ObjectInputStream ois;
        FileInputStream fis;

        a = new BSTNode<Integer>(10);
        b = new BSTNode<Integer>(11);

        System.out.println(a.compareTo(b)); // -1 a < b
        System.out.println(b.compareTo(b)); // 0 b = b
        System.out.println(b.compareTo(a)); // 1 b > a

        root = new BSTTree<Integer>();
        root.add(30);
        System.out.println(root.size());

        root.add(20);
        System.out.println(root.size());

        root.add(40);
        System.out.println(root.size());

        root.add(35);
        root.add(25);
        root.add(35);
        System.out.println(root.size());

        root.remove(40);
        System.out.println(root.size());

        try {
            fos = new FileOutputStream(filename);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(root);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fis = new FileInputStream(filename);
            ois = new ObjectInputStream(fis);
            root = (BSTTree<Integer>) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(root.search(30));
        System.out.println(root.search(40));

        System.out.println("== IN Order");
        root.inorder();
        System.out.println("");
        System.out.println("== PRE Order");
        root.preorder();
        System.out.println("");
        System.out.println("== POST Order");
        root.postorder();
    }
}
