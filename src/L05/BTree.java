package L05;

import java.util.Random;

public class BTree<T> {

    private BinNode<T> root;
    private int size;
    private Random rd;

    public BTree() {
        this.root = null;
        size = 0;
        rd = new Random();
    }

    public void add(T value) {
        this.root = add(root, value);
        size++;
    }

    private BinNode<T> add(BinNode<T> node, T value) {
        if (node == null)
            return new BinNode<>(value);
        if (rd.nextBoolean()) {
            node.setLeft(add(node.getLeft(), value));
        } else {
            node.setRight(add(node.getRight(), value));
        }
        return node;
    }

    public boolean contains(T value) {
        return contains(root, value);
    }

    private boolean contains(BinNode<T> node, T value) {
        if (node == null)
            return false;
        if (node.getValue().equals(value))
            return true;
        return contains(node.getLeft(), value) || contains(node.getRight(), value);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void addWithIteration(T value) {
        BinNode<T> temp = root;
        if (root == null)
            root = new BinNode<>(value);
        else
            while (temp != null) {
                if (rd.nextBoolean()) {
                    if (!temp.hasLeft()) {
                        temp.setLeft(new BinNode<>(value));
                        break;
                    }
                    temp = temp.getLeft();
                } else {
                    if (!temp.hasRight()) {
                        temp.setRight(new BinNode<>(value));
                        break;
                    }
                    temp = temp.getRight();
                }
            }
    }

    public void print() {
        print(root);
    }

    private void print(BinNode<T> node) {
        if (node == null)
            return;
        print(node.getLeft());
        System.out.println(node.getValue());
        print(node.getRight());
    }

//    @Override
//    public String toString() {
//        return
//    }
}
