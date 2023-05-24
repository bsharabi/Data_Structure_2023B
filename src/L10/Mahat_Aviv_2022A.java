package L10;

import javax.crypto.spec.PSource;
import java.util.*;

public class Mahat_Aviv_2022A {
    static Scanner in = new Scanner(System.in);
    static Random rd = new Random();
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public static void main(String[] args) {
        boolean bool;
        while (true) {
            System.out.println("Enter q number");
            int numberQ = in.nextInt();
            switch (numberQ) {
                case 1:
                    Node<Integer> chain = new Node<>(1);
                    chain.setNext(new Node<>(2));
                    chain.getNext().setNext(new Node<>(3));
                    chain.getNext().getNext().setNext(new Node<>(4));
                    print(chain);
                    Q1(chain);
                    print(chain);
                    Q2(chain);
                    print(chain);


                    Node<Integer> chain1 = new Node<>(new Node<>(new Node<>(new Node<>(4), 3), 2), 1);
                    printC(chain1);
                    q1(chain1);
                    printC(chain1);

                    Node<Integer> chain2 = new Node<>(new Node<>(new Node<>(new Node<>(4), 30), 2), 11);
                    printC(chain2);
                    q2(chain2);
                    printC(chain2);
                    break;
                case 2:

                    break;
                case 3:

                    int t = 0, s = 0;
                    String n = "", d = "";
                    A x = new B(t, s);
                    Test h = new Test();
                    h.g(n, d);
                    System.out.println("עבור כל אחד מההיגדים 1-6 ציינו האם הוא נכון או אינו נכון. הסבירו את תשובתכם");
                    System.out.println("הפעולה g חייבת להיות ציבורית public - >  לא נכון\nדוגמא נגדית הפונקציה מוגדרת להיות protected והקריאה לפונקציה מתבצעת מאותו package");
                    System.out.print("t ");
                    System.out.println("הוא בהכרח משתנה מטיפוס פשוט (int,double וכדו) לא נכון -> הוא יכול להיות גם אובייקט.");
                    System.out.print("h ");
                    System.out.println(" הוא בהכרח אובייקט -> נכון מכיוון והפעלת dot notation אפשרית רק על אובייקטים.");
                    System.out.print("d ");
                    System.out.println(" יכול להיות שם של פעולה -> לא נכון, גאווה לא תומכת בשליחת מצביעים של פונקציות לפונקציות אחרות");
                    System.out.print("B ");
                    System.out.println(" בהכרח מחלקה שיורשת ממחלקת A -> נכון, אחרת לא ניתן ליצור אובייקט B מטיפוס A.");
                    System.out.println("יתכן ש-A היא מחלקה שיורשת מ-B -> לא נכון, לפי 5 לא ניתן לבצע ורשה דו כיוונית.");
                    B b = new B();
                    b.a2();
                    System.out.println("הפעלת a2 על אובייקט מטיפוס B יגרור להפעלת פונקציה מ-B כל עוד היא קיימת בטבלה הווירטואלית גם אם פונקציה קוראת לפונקציה באופן מרובה עדיין כל עוד הפונקציה האחרונה קיימת בטבלה הווירטואלית של B אז היא זאת שתופעל.");
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("קיום מסלול בטבלת UML");
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:

                    break;
                case 12:
                    break;
                case 13:

                    Animal a = new Bat();
//                    Fish f = new IHasEggs();
                    ICanFly cf = new Bird();
                    cf = new Bat();
                    Mammal m = new Bat();

                    ((Bat) m).fly();
                    Animal a1 = new Bird();

                    ((Bird) a).fly();

                    IHasEggs he = new Fish();
                    ((ICanFly) he).fly();

                    break;
                case -1:
                    return;
            }
        }
    }

    private static int countFly(Animal[] animals) {
        if (animals == null)
            return 0;
        int counter = 0;
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] != null && animals[i] instanceof ICanFly)
                counter++;
        }
        return counter;

    }

    private static void q2(Node<Integer> chain2) {
        if (chain2 == null)
            return;

        Node<Integer> head = new Node<>(chain2.getValue());
        Node<Integer> temp = head;

        while (chain2.getNext() != null) {
            chain2 = chain2.getNext();
            temp.setNext(new Node<>(chain2.getValue()));
            temp = temp.getNext();
        }
        chain2.setNext(head);
    }

    private static void printC(Node<Integer> chain) {

        while (chain != null) {
            System.out.print(chain.getValue() + "-> ");
            chain = chain.getNext();
        }
        System.out.println("null");

    }

    private static void q1(Node<Integer> chain) {
        while (chain != null) {
            Node<Integer> copy = new Node<>(chain.getValue());
            copy.setNext(chain.getNext());
            chain.setNext(copy);
            chain = copy.getNext();
        }
    }

    static int countOfFlyAnimal(Animal[] animals) {
        int count = 0;
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] != null && animals[i] instanceof ICanFly)
                count++;
        }
        return count;
    }

    interface IHasEggs {
        public void layingEggs();

    }

    interface ICanFly {
        public void fly();
    }

    static abstract class Animal {
    }

    static class Mammal extends Animal {
    }

    ;

    static class Fish extends Animal implements IHasEggs {
        @Override
        public void layingEggs() {

        }
    }

    ;

    static class Bird extends Animal implements IHasEggs, ICanFly {
        @Override
        public void layingEggs() {

        }

        @Override
        public void fly() {

        }
    }

    ;

    static class Bat extends Mammal implements ICanFly {
        @Override
        public void fly() {

        }
    }


    static public class A {


        protected void a1() {

            System.out.println("Hello A");
        }

        protected void a2() {
            a1();
        }


    }

    static class Test {
        protected void g(String h, String d) {
        }
    }

    static public class B extends A {

        public B() {
        }

        public B(int t, int s) {

        }

        public B(ArrayList t, int s) {

        }

        protected void a1() {
            super.a1();
            System.out.println("Bye B");
        }

    }

    private static void Q1(Node<Integer> chain) {
        while (chain != null) {
            Node<Integer> newNode = new Node<>(chain.getNext(), chain.getValue());
            chain.setNext(newNode);
            chain = newNode.getNext();
        }
    }

    private static void Q2(Node<Integer> chain) {
        if (chain == null)
            return;
        Node<Integer> copy = new Node<>(chain.getValue());
        Node<Integer> temp = copy;
        while (chain.hasNext()) {
            chain = chain.getNext();
            temp.setNext(new Node<>(chain.getValue()));
            temp = temp.getNext();
        }
        chain.setNext(copy);
    }

    static public void print(Node<Integer> chain) {
        while (chain != null) {
            System.out.print(chain.getValue() + " -> ");
            chain = chain.getNext();
        }
        System.out.println("null");
    }

    static class Node<E> {
        private Node<E> next;
        private E value;

        public Node(E value) {
            this.value = value;
            this.next = null;
        }

        public Node(Node<E> next, E value) {
            this.next = next;
            this.value = value;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public boolean hasNext() {
            return next != null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "next=" + next +
                    ", value=" + value +
                    '}';
        }
    }
}


