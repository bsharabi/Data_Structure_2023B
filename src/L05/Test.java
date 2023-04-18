package L05;

import java.util.Arrays;

public class Test {
    static public BinNode<Integer> root = null;


    public static void main(String[] args) {
        int[] pre = new int[]{17, 36, 12, 10, 42, 7, 28, 0, 1, 70};
        int[] in = new int[]{10, 12, 42, 36, 17, 28, 7, 0, 1, 70};

        System.out.println(Arrays.toString(pre));
        System.out.println(Arrays.toString(in));

        root = build(pre, in);
        inOrder(root);
        System.out.println();
        preOrder(root);
        System.out.println();
    }

    private static void inOrder(BinNode<Integer> root) {
        if (root == null)
            return;
        inOrder((root.getLeft()));
        System.out.print(" " + root.getValue());
        inOrder((root.getRight()));
    }

    private static void preOrder(BinNode<Integer> root) {

        if (root == null)
            return;
        System.out.print(" " + root.getValue());
        preOrder((root.getLeft()));
        preOrder((root.getRight()));
    }

    private static BinNode<Integer> build(int[] pre, int[] in) {
        if (pre.length != in.length || pre.length == 0)
            return null;
        if (pre.length == 1)
            return new BinNode<>(pre[0]);

        BinNode<Integer> node = new BinNode<>(pre[0]);

        int middle = pre[0];
        int i;
        for (i = 0; i < in.length; i++) {
            if (in[i] == middle)
                break;
        }
        int[] preLeft = Arrays.copyOfRange(pre, 1, i + 1);
        int[] inLeft = Arrays.copyOfRange(in, 0, i);

        int[] preRight = Arrays.copyOfRange(pre, i + 1, pre.length );
        int[] inRight = Arrays.copyOfRange(in, i+1, in.length );

//        System.out.println("-------Left-------");
//        System.out.println(Arrays.toString(preLeft));
//        System.out.println(Arrays.toString(inLeft));
//
//        System.out.println("-------Right-------");
//        System.out.println(Arrays.toString(preRight));
//        System.out.println(Arrays.toString(inRight));

        node.setLeft(build(preLeft, inLeft));
        node.setRight(build(preRight, inRight));

        return node;

    }

}
