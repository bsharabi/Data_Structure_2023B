package L05;

public class Main {

    public static void main(String[] args) {
//        BinNode<Integer> root = new BinNode<>(10);
//        int count = countOfX(root, 5);

        BTree<Integer> T = new BTree<>();
        T.add(50);
        T.add(52);
        T.add(53);
        T.add(54);
        T.add(56);
        T.add(58);
        T.add(43);
        T.add(67);
        System.out.println(T.contains(67));
        T.print();

        BST TS = new BST();
        TS.add(8);
        TS.add(3);
        TS.add(10);
        TS.add(14);
        TS.add(13);
        TS.add(1);
        TS.add(6);
        TS.add(4);
        TS.add(7);

        TS.levelOrder();



    }

    private static int countOfX(BinNode<Integer> root, int X) {
        if (root == null)
            return 0;
        if (root.getValue() == X)
            return countOfX(root.getLeft(), X) + countOfX(root.getRight(), X) + 1;

        return countOfX(root.getLeft(), X) + countOfX(root.getRight(), X);

    }


}
