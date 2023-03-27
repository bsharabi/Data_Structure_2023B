package L01;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        DLinkedList<Integer> ll = new DLinkedList<>();
        printAll(ll);
        System.out.println("Insert - " + 1);
        ll.add(1);
        printAll(ll);
        Random rd = new Random();
        int ItemInsertion;
        for (int i = 0; i < rd.nextInt(89); i++) {
            ItemInsertion = rd.nextInt(78) + 9;
            System.out.println("Insert - " + ItemInsertion);
            ll.add(ItemInsertion);
        }
        printAll(ll);
        ItemInsertion = rd.nextInt(78) + 9;
        System.out.println("Delete element " + ItemInsertion);
        boolean bool = ll.remove((Object) ItemInsertion);
        if (bool)
            printAll(ll);
        else
            System.out.println("Invalid remove");

    }

    private static void printAll(DLinkedList<Integer> ll) {
        System.out.println(" ------------ List Print ---------------");
        if (ll.isEmpty()) {
            System.out.println("Empty");
        } else {
            for (Integer Item : ll) System.out.print(Item + " ");
            System.out.println();
        }
        System.out.println(" --------------------------------------");
    }
}