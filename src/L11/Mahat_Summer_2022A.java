package L11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class Mahat_Summer_2022A {
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
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:

                    A y1 = new B(10);
                    B y2 = new B(10);
                    A z1 = new C(10);
                    C z2 = new C(10);

                    // זמן ריצה
                    //System.out.println(y1.getNum()==((B)z1).getNum());
                    // תקין
                    //System.out.println(y1.f(y2));
                    // תקין
                    //System.out.println(y2.f(y1));
                    //תץקין
                    //System.out.println(z1.f(z2));
                    //תקין
                    //System.out.println(z1.f(y1));
                    // קומפילציה
                    //System.out.println(z2.f((C)y2));

                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    sumQueue(null);
                    sumQueue(new LinkedList<>() {{
                        add(1);
                        add(2);
                        add(13);
                        add(4);
                        add(5);
                    }});
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
                    break;
                case -1:
                    return;
            }


        }
    }

    //O(n)
    public static int sumQueue(Queue<Integer> q) {
        if (q == null || q.isEmpty())
            return 0;
        int sum = 0;
        Queue<Integer> temp = new LinkedList<>();
        while (!q.isEmpty())
            temp.add(q.poll());

        while (!temp.isEmpty()) {
            int curr = temp.remove();
            sum += curr;
            q.add(curr);
        }
        return sum;
    }

    //O(n)
    public static int lastValue(Queue<Integer> q) {
        if (q == null || q.isEmpty())
            return Integer.MAX_VALUE;

        int last = 0;

        Queue<Integer> temp = new LinkedList<>();
        while (!q.isEmpty())
            temp.add(q.poll());

        while (!temp.isEmpty()) {
            last = temp.remove();
            q.add(last);
        }
        return last;
    }

    // m
    private Queue<Integer> newQ(Node<Queue<Integer>> nq) {

        Queue<Integer> newQu = new LinkedList<>();
        while (nq != null) {
            if (nq.getValue() != null)
                if (nq.getValue().peek() % 2 == 0)
                    newQu.add(lastValue(nq.getValue()));
                else
                    newQu.add(sumQueue(nq.getValue()));
            nq = nq.getNext();
        }
        return newQu;
    }

    static class Pyramid {

        private Node<Clown> head;
        private int size;

        public Pyramid() {
            head = null;
            size = 0;
        }

        public boolean isStable() {
            if (head == null)
                return true;
            Node<Clown> temp = head;

            while (temp.hasNext()) {
                Node<Clown> next = temp.getNext();
                if (temp.getValue().getWeight() > next.getValue().getWeight())
                    return false;
                temp = next;
            }

            return true;
        }


        // תחשבו איך ניתן ליעל את הקוד לפחות בזרימה
        public boolean addClown(Clown c) {
            if (c == null || !isStable())
                return false;

            Node<Clown> newNode = new Node<>(c);

            if (head == null) {
                head = newNode;
                return true;
            }

            if (newNode.getValue().getWeight() <= head.getValue().getWeight()) {
                newNode.setNext(head);
                head = newNode;
                return true;
            }
            Node<Clown> temp = head;

            while (temp.hasNext()) {

                if (temp.getValue().getWeight() < newNode.getValue().getWeight()) {
                    Node<Clown> next = temp.getNext();
                    temp.setNext(newNode);
                    newNode.setNext(next);
                    return true;
                }
                temp = temp.getNext();
            }
            temp.setNext(newNode);
            return true;

        }

    }

    static class Clown {
        private String name; // ליצן שם
        private int weight; // ליצן משקל


        public Clown(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
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


    static public class A {
        protected int num;

        public A(int n) {
            num = n;
        }

        public int getNum() {
            return num;
        }

        public boolean f(A a) {
            System.out.println("F in A");
            return num == a.num * 2;
        }
    }// end of class A

    static public class B extends A {
        public B(int n) {
            super(n);
        }

        public boolean f(B b) {
            System.out.println("F in B");
            return num == b.num;
        }
    }// end of class B

    static public class C extends A {
        public C(int n) {
            super(n);
            System.out.println("F in C");
        }

        public boolean f(A a) {
            return a instanceof C && num == a.num;
        }
    } //end of class C

}



