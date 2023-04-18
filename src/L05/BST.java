package L05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class BST {

    private BinNode<Integer> root;
    private int size;
    private Random rd;

    public BST() {
        this.root = null;
        size = 0;
        rd = new Random();
    }

    public void add(int value) {
        this.root = add(root, value);
        size++;
    }


    private BinNode<Integer> add(BinNode<Integer> node, int value) {
        if (node == null)
            return new BinNode<>(value);
        if (value < node.getValue()) {
            node.setLeft(add(node.getLeft(), value));
        } else {
            node.setRight(add(node.getRight(), value));
        }
        return node;
    }

    public boolean contains(int value) {
        return contains(root, value);
    }

    private boolean contains(BinNode<Integer> node, int value) {
        if (node == null)
            return false;
        if (node.getValue().equals(value))
            return true;
        return contains(node.getLeft(), value) || contains(node.getRight(), value);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void print() {
        print(root);
    }

    public void levelOrder() {
        if (root == null)
            return;
        Queue<BinNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            BinNode current = q.poll();
            System.out.print(" " + current.getValue());
            if (current.hasLeft())
                q.add(current.getLeft());
            if (current.hasRight())
                q.add(current.getRight());
        }
    }

    private void print(BinNode<Integer> node) {
        if (node == null)
            return;
        print(node.getLeft());
        System.out.println(node.getValue());
        print(node.getRight());
    }


}
