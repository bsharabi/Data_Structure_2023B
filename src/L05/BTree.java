package L05;

import java.util.Random;

public class BTree<T> {

    public static void main(String[] args) {

        BTree T = new BTree();
        T.insert(12);

        T.Search(12);

    }

    private BinNode<T> root;
    private int size;
    private Random rd;

    public BTree() {
        this.root = null;
        size = 0;
        rd = new Random();
    }

    public void insert(T value) {
        root = insert(root, value);
    }

    private BinNode<T> insert(BinNode<T> node, T value) {

        if (node == null)
            return new BinNode<>(value);

        if (rd.nextBoolean()) {
            node.setLeft(insert(node.getLeft(), value));
        } else {
            node.setRight(insert(node.getRight(), value));
        }
        return node;
    }


    public boolean Search(T value) {

        return Search(root, value);
    }

    private boolean Search(BinNode<T> node, T value) {

        if (node == null)
            return false;

        if (node.getValue().equals(value))
            return true;

        return Search(node.getLeft(), value) || Search(node.getRight(), value);
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
