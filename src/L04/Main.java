package L04;

import L03.BinNode;

import java.util.Random;


public class Main {
    static Random rd = new Random();

    public static void main(String[] args) {
        BinNode<Integer> root = null;
        root = add(root, 17);

        add(root, rd.nextInt(20) + 1);
        add(root, rd.nextInt(20) + 1);
        add(root, rd.nextInt(20) + 1);
        add(root, rd.nextInt(20) + 1);
        add(root, rd.nextInt(20) + 1);
        add(root, rd.nextInt(20) + 1);
        add(root, rd.nextInt(20) + 1);
        add(root, rd.nextInt(20) + 1);

//        inOrder(root);
//        System.out.println();
//        preOrder(root);

        System.out.println();
        BinNode<Integer> root2 = null;
        root2 = addS(root2, rd.nextInt(20) + 1);
        addS(root2, rd.nextInt(20) + 1);
        addS(root2, rd.nextInt(20) + 1);
        addS(root2, rd.nextInt(20) + 1);
        addS(root2, rd.nextInt(20) + 1);
        addS(root2, rd.nextInt(20) + 1);
        addS(root2, rd.nextInt(20) + 1);
        addS(root2, rd.nextInt(20) + 1);

//        inOrder(root2);
//        System.out.println();
//        preOrder(root2);

        int randomNumber = rd.nextInt(10) + 1;
        boolean bool = contains(root2, randomNumber);
        System.out.println("\n" + randomNumber);
        inOrder(root2);
        System.out.println("\nIs contains " + bool);


        BinNode<Character> root3 = null;
        char[] nodesChar = {'b', 'w', 'r'};
        root3 = addWB(root3, nodesChar[rd.nextInt(3)]);
        addWB(root3, nodesChar[rd.nextInt(3)]);
        addWB(root3, nodesChar[rd.nextInt(3)]);
        addWB(root3, nodesChar[rd.nextInt(3)]);
        addWB(root3, nodesChar[rd.nextInt(3)]);
        addWB(root3, nodesChar[rd.nextInt(3)]);
        addWB(root3, nodesChar[rd.nextInt(3)]);
        addWB(root3, nodesChar[rd.nextInt(3)]);

        inOrderCh(root3);

        bool = isBW(root3);

        int numberOfNodes = countNodes(root2);
        System.out.println("\nNumber Of Nodes " + numberOfNodes);

        bool = exitXY(root, 5, 9);

    }

    private static boolean exitXY(BinNode<Integer> root, int x, int y) {

        if (root == null)
            return false;

        if (root.getKey() == x)
            return contains(root.getLeft(), y) || contains(root.getRight(), y);

        return exitXY(root.getLeft(), x, y) || exitXY(root.getRight(), x, y);

    }

    private static int countNodes(BinNode<Integer> root) {
        if (root == null)
            return 0;
        int sumOfNodeLeft = countNodes(root.getLeft());
        int sumOfNodeRight = countNodes(root.getRight());
        int sumAll = sumOfNodeLeft + sumOfNodeRight + 1;

        return sumAll;
    }

    private static boolean visit(BinNode<Character> root) {
        if (root.getKey() != 'b' && root.getKey() != 'w')
            return false;

        if (root.getLeft() == null && root.getRight() == null) {
            if (root.getKey() != 'b')
                return false;
        } else {
            if (root.getKey() == 'b') {
                if (root.getLeft() == null || root.getRight() == null)
                    return false;
                else {
                    if (root.getLeft().getKey() != 'w' || root.getRight().getKey() != 'w')
                        return false;
                }

            }

        }
        return true;
    }

    private static boolean isBW(BinNode<Character> root) {

        if (root == null)
            return true;
        if (!visit(root))
            return false;

        boolean left = isBW(root.getLeft());
        boolean right = isBW(root.getRight());


        return left && right;


    }

    private static BinNode<Integer> add(BinNode<Integer> root, int key) {
        if (root == null)
            return new BinNode<>(key);
        if (rd.nextBoolean()) {
            root.setRight(add(root.getRight(), key));
        } else {
            root.setLeft(add(root.getLeft(), key));
        }
        return root;
    }

    private static BinNode<Character> addWB(BinNode<Character> root, char key) {
        if (root == null)
            return new BinNode<>(key);
        if (rd.nextBoolean()) {
            root.setRight(addWB(root.getRight(), key));
        } else {
            root.setLeft(addWB(root.getLeft(), key));
        }
        return root;
    }

    private static BinNode<Integer> addS(BinNode<Integer> root, int key) {
        if (root == null)
            return new BinNode<>(key);
        if (key >= root.getKey()) {
            root.setRight(addS(root.getRight(), key));
        } else {
            root.setLeft(addS(root.getLeft(), key));
        }
        return root;
    }

    private static boolean contains(BinNode<Integer> root, int key) {
        if (root == null)
            return false;
        if (key == root.getKey())
            return true;
        if (key > root.getKey()) {
            return contains(root.getRight(), key);
        } else {
            return contains(root.getLeft(), key);
        }

    }


    private static void inOrder(BinNode<Integer> root) {

        if (root != null) {
            inOrder(root.getLeft());
            System.out.print(root.getKey() + ",");
            inOrder(root.getRight());
        }

    }

    private static void inOrderCh(BinNode<Character> root) {

        if (root != null) {
            inOrderCh(root.getLeft());
            System.out.print(root.getKey() + ",");
            inOrderCh(root.getRight());
        }

    }

    private static void preOrder(BinNode<Integer> root) {
        if (root != null) {
            System.out.print(root.getKey() + ",");
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }
}
