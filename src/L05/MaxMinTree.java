package L05;

public class MaxMinTree {


    public static void main(String[] args) {
        BinNode<Integer> root = null;
        int max = findMax(root);
        int min = findMin(root);


    }

    private static int findMax(BinNode<Integer> root) {
        if (root == null)
            return Integer.MIN_VALUE;

        int maxLeft = findMax(root.getLeft());
        int maxRight = findMax(root.getRight());

        return Math.max(root.getValue(), Math.max(maxLeft, maxRight));

    }

    private static int findMin(BinNode<Integer> root) {

        if (root == null)
            return Integer.MIN_VALUE;

        int minLeft = findMin(root.getLeft());
        int minRight = findMin(root.getRight());

        return Math.min(root.getValue(), Math.min(minLeft, minRight));
    }
}
