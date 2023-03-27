package L03;

class Main {


    public static void main(String[] args) {
        BinNode<Integer> root = new BinNode<>(17);

        root.setLeft(new BinNode<>(36));
        root.setRight(new BinNode<>(7));

        root.getLeft().setLeft(new BinNode<>(12));
        root.getRight().setLeft(new BinNode<>(28));
        root.getRight().setRight(new BinNode<>(0));

        root.getLeft().getLeft().setLeft(new BinNode<>(10));
        root.getLeft().getLeft().setRight(new BinNode<>(42));
        root.getRight().getRight().setRight(new BinNode<>(1));

        root.getRight().getRight().getRight().setRight(new BinNode<>(70));

        inOrder(root);
        System.out.println();


        preOrder(root);
        System.out.println();

        postOrder(root);
        System.out.println();

        BinNode<Integer> rootSort = new BinNode<>(10);
        rootSort.setRight(new BinNode<>(34));
        rootSort.getRight().setLeft(new BinNode<>(24));
        rootSort.setLeft(new BinNode<>(5));
        rootSort.getRight().getLeft().setLeft(new BinNode<>(17));
        rootSort.getLeft().setRight(new BinNode<>(7));
        rootSort.getLeft().getRight().setLeft(new BinNode<>(6));
        rootSort.getRight().getLeft().getLeft().setRight(new BinNode<>(17));

        inOrder(rootSort);
        System.out.println();
        int count = countLeaves(root);
        System.out.println("Count Leaves - " + count);

    }

    private static int countLeaves(BinNode<Integer> root) {
        if (root == null) return 0;

        if (emptyTree(root.getLeft()) && emptyTree(root.getRight())) return 1;

        return countLeaves(root.getLeft())+ countLeaves(root.getRight());
    }

    private static void postOrder(BinNode<Integer> root) {

        if (!emptyTree(root)) {
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.print(root.getKey() + ",");
        }
    }

    private static void preOrder(BinNode<Integer> root) {
        if (!emptyTree(root)) {
            System.out.print(root.getKey() + ",");
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    private static boolean emptyTree(BinNode<Integer> root) {
        return root == null;
    }

    private static void inOrder(BinNode<Integer> root) {

        if (!emptyTree(root)) {
            inOrder(root.getLeft());
            System.out.print(root.getKey() + ",");
            inOrder(root.getRight());
        }

    }

    private static void inOrder2(BinNode<Integer> root) {

        if (root == null)
            return;
        inOrder2(root.getLeft());
        System.out.println(root.getKey());
        inOrder2(root.getRight());
    }

}

public class BinNode<T> {

    private T key;
    private BinNode<T> left;
    private BinNode<T> right;

    public BinNode(T key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }

    public BinNode(T key, BinNode<T> left, BinNode<T> right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public BinNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinNode<T> left) {
        this.left = left;
    }

    public BinNode<T> getRight() {
        return right;
    }

    public void setRight(BinNode<T> right) {
        this.right = right;
    }

    public boolean hasRight() {
        return right != null;
    }

    public boolean hasLeft() {
        return left != null;
    }

}