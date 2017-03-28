import java.io.Serializable;
import java.util.Stack;

/**
 * Created by lukkiddd on 3/28/2017 AD.
 */

public class BSTTree<T extends Comparable<T>> implements Serializable {
    BSTNode<T> root;

    public BSTTree() {
        root = null;
    }

    public BSTTree(BSTNode<T> r) {
        this();
        root = r;
    }

    public void setRoot(BSTNode<T> r) {
        root = r;
    }

    public BSTNode<T> getRoot() {
        return root;
    }

    public void add(T i) {
        if(i == null) return;
        BSTNode<T> n = new BSTNode<T>(i);
        add(n);
    }

    public void add(BSTNode<T> n) {
        if(root == null) {
            setRoot(n);
            return;
        }
        insert(root,n);
    }

    private void insert(BSTNode<T> node, BSTNode<T> n) {
        T a,b;

        if(n == null) return;

        a = (T) node.get();
        b = (T) n.get();

        if(a.compareTo(b) > 0) {
            if(node.getLeft() == null) {
                node.setLeft(n);
                n.setParent(node);
            } else {
                insert(node.getLeft(), n);
            }
        }

        if(a.compareTo(b) < 0) {
            if(node.getRight() == null) {
                node.setRight(n);
                n.setParent(node);
            } else {
                insert(node.getRight(), n);
            }
        }

        if(a.compareTo(b) == 0) {
            System.out.println("Value exists!");
        }
    }

    public T remove(T v) {
        if(root == null) return null;
        return delete(root, v);
    }

    private T delete(BSTNode<T> n, T v) {
        T ret;
        BSTNode<T> p, l, r;
        r = null;
        if(n == null) return null;
        if(n.get().equals(v)) {
            ret = n.get();
            p = n.getParent();
            l = n.getLeft();
            r = n.getRight();
            if(l!= null) insert(l, r);
            else l = r;

            l.setParent(p);

            if(p.getLeft() == n) {
                p.setLeft(l);
            } else {
                p.setRight(l);
            }
        }

        if(n.get().compareTo(v) > 0) {
            ret = delete(n.left, v);
        } else {
            ret = delete(n.right, v);
        }

        return ret;
    }

    public T search(T v) {
        T ret = null;
        if(root != null) ret = searchNode(root, v);
        return ret;
    }

    public T searchNode(BSTNode<T> n, T v) {
        T ret = null;
        if(n == null) return ret;
        if(n.get().equals(v)) return n.get();
        if(n.get().compareTo(v) < 0) ret = searchNode(n.getLeft(), v);
        else ret = searchNode(n.getRight(), v);

        return ret;
    }

    public void preorder() {
        if( root == null) return;
        Stack<BSTNode> stack = new Stack<BSTNode>();

        stack.push(root);
        while(!stack.isEmpty()) {
            BSTNode n = stack.pop();
            if(n.getRight() != null) stack.push(n.getRight());
            if(n.getLeft() != null) stack.push(n.getLeft());
            System.out.print(n.get() + " ");
        }
    }

    public void inorder() {
        BSTNode n = root;
        Stack<BSTNode> stack = new Stack<BSTNode>();
        while(!stack.isEmpty() || n != null) {
            if(n != null) {
                stack.push(n);
                n = n.getLeft();
            } else {
                n = stack.pop();
                System.out.print(n.get() + " ");
                n = n.getRight();
            }
        }
    }

    public void postorder() {
        if(root == null) return;

        Stack<BSTNode> stack = new Stack<BSTNode>();
        BSTNode n = root;

        while(true) {
            if(n != null) {
                if(n.getRight() != null) stack.push(n.getRight());
                stack.push(n);
                n = n.getLeft();
                continue;
            }

            if(stack.isEmpty()) return;
            n = stack.pop();

            if(n.getRight() != null && !stack.isEmpty() && n.getRight() == stack.peek()) {
                stack.pop();
                stack.push(n);
                n = n.getRight();
            } else {
                System.out.print(n.get() + " ");
                n = null;
            }
        }
    }

    public int size() {
        return size(root);
    }

    private int size(BSTNode n) {
        if(n == null) return 0;
        else {
            return 1 + size(n.left) + size(n.right);
        }
    }
}
