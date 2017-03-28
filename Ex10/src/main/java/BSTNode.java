import java.io.Serializable;

/**
 * Created by lukkiddd on 3/28/2017 AD.
 */
public class BSTNode<E extends Comparable<E>> implements Serializable {
    BSTNode<E> parent;
    BSTNode<E> left;
    BSTNode<E> right;
    E item;

    public BSTNode() {
        parent = null;
        left = null;
        right = null;
        item = null;
    }

    public BSTNode(E e) {
        this();
        item = e;
    }

    public void setParent(BSTNode<E> p) {
        parent = p;
    }

    public BSTNode<E> getParent() {
        return parent;
    }

    public void setLeft(BSTNode<E> p) {
        left = p;
    }

    public BSTNode<E> getLeft() {
        return left;
    }

    public void setRight(BSTNode<E> p) {
        right = p;
    }

    public BSTNode<E> getRight() {
        return right;
    }

    public void set(E p) {
        item = p;
    }

    public E get() {
        return item;
    }

    public int compareTo(BSTNode<E> n) {
        return (this.get().compareTo(n.get()));
    }

}
