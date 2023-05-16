package L09;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class Mahat_Summer_2021B {
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
                    Queue<Integer> q = Q1_a(4);
                    System.out.println(q);
                    Queue<Integer> q1 = new LinkedList<>();
                    for (int i = 1; i < 3; i++) {
                        for (int j = 0; j < i; j++) {
                            q1.add(i);
                        }
                    }
                    System.out.println(q1);
                    bool = Q1_b(q1, 4);
                    System.out.println(bool);
                    bool = Q1_b(q, 4);
                    break;
                case 2:
                    Node<Integer> n = new Node<>(1);
                    bool = Q2_a(n);
                    System.out.println(bool);
                    bool = Q2_b(n);
                    break;
                case 3:
//                    B b1 = new A();
//                    B b2 = new C();
//                    A a1 = (C) b2;
//                    D d1 = new C();
//                    B b3 = new B();
//                    D d2 = new A();
                    break;
                case 4:
                    break;
                case 5:
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
                    TrickTrack trickTrack = new TrickTrack();
                    trickTrack.AddPayment(1, 4689756, "barak", 40);
                    System.out.println(trickTrack);
                    break;
                case 11:
                    Test test = new Test();
                    test.testIt();
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

    private static int sumNodes(Node<Integer> node) {
        if (node == null)
            return 0;
        int sum = node.getValue();
        node = node.getNext();
        while (node != null) {
            sum += node.getValue();
            node = node.getNext();
        }
        return sum;
    }

    // תנסו לשפר את הסיבוכיות מO(n^2) ל- O(n)
    private static boolean Q2_b(Node<Integer> node) {
        if (node == null)
            return false;
        //128 -> 64 -> 32 -> 16 -> 8 -> 4 -> 2 -> 2
        while (node != null) {
            int value = node.getValue();
            node = node.getNext();
            if (sumNodes(node) != value)
                return false;
        }
        return true;
    }

    private static boolean Q2_a(Node<Integer> node) {
        if (node == null)
            return false;
        int temp = node.getValue();
        node = node.getNext();
        while (node != null) {
            if (temp != node.getValue())
                return false;
            temp += node.getValue();
            node = node.getNext();
        }
        return true;
    }

    static class Payment {

        private int day;
        private int num;
        private String name;
        private double fuel;

        Payment(String name, int num, double fuel) {
            this.name = name;
            this.num = num;
            this.fuel = fuel;
        }

        public int getDay() {
            return day;
        }

        public void setDay(int day) {
            this.day = day;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getFuel() {
            return fuel;
        }

        public void setFuel(double fuel) {
            this.fuel = fuel;
        }

        @Override
        public String toString() {
            return "Payment{" +
                    "day=" + day +
                    ", num=" + num +
                    ", name='" + name + '\'' +
                    ", fuel=" + fuel +
                    '}';
        }
    }

    static class TrickTrack {
        private Node<String> drivers;
        private Node<Integer> cars;
        private Node<Payment>[] payments;

        public TrickTrack() {
            drivers = null;
            cars = null;
            this.payments = new Node[30];
        }


        public boolean AddPayment(int day, int num, String name, double fuel) {
            if (!existCar(num) || !existDriver(name) || day < 1 || day > 30 || fuel < 0)
                return false;

            Node<Payment> nPayment = new Node(new Payment(name, num, fuel));
            nPayment.getValue().setDay(day);

            if (payments[day - 1] == null) {
                payments[day - 1] = nPayment;
            } else {
                Node<Payment> pTemp = payments[day - 1];
                while (pTemp.next != null) {
                    pTemp = pTemp.getNext();
                }
                pTemp.setNext(nPayment);
            }

            return true;
        }

        public double totalFuel(int num) {
            if (!existCar(num))
                return 0;
            double sum = 0;
            for (int i = 0; i < payments.length; i++) {
                Node<Payment> pTemp = payments[i];
                while (pTemp != null) {
                    if (pTemp.getValue().getNum() == num)
                        sum += pTemp.getValue().getFuel();
                    pTemp = pTemp.getNext();
                }
            }
            return sum;
        }

        // נסמן את מספר הנהגים ב-m וגם נסמן את מספר הימים בחודש ב-n
        // O(m*n) ~ O(m) => n=30 -> O(1) => o(m)
        public void printWorkDays() {
            if (drivers == null)
                return;
            // ראש של רשימת הנהגים במחלקה
            Node<String> temp = drivers;
            while (temp != null) {
                int sumDay = 0;
                for (int i = 1; i <= 30; i++) {
                    sumDay += (worked(temp.getValue(), i)) ? 1 : 0;
                }
                System.out.println("Name -> " + temp.getValue() + " Days -> " + sumDay);
                temp = temp.getNext();
            }
        }


        public boolean existDriver(String name) {
            return true;
        }

        public boolean existCar(int num) {
            return true;
        }

        public boolean worked(String name, int num) {
            return true;
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


    //--------------- Q3_A First option -------------------
//    static class A extends D {
//    }
//
//    static class B {
//    }
//
//    static class C extends A {
//    }
//
//    static class D extends B {
//    }
    //--------------- Q3_A Second option ------------------
//    static class A extends B {
//    }
//
//    static class D {
//    }
//
//    static class C extends A {
//    }
//
//    static class B extends D {
//    }

    //-------------------- Q3_B ----------------------------
    //    static class A extends B {};
    //    static class B{};
    //    static class C extends D{};
    //    static class D extends A{};

    private static boolean Q1_b(Queue<Integer> q, int N) {
        if (q == null || N <= 0)
            return false;
        //{1,2,2,3,3,3,4, } N=4
        //{1,2,2,3,3,3,4,4,4,4,6,9,8,7,8,5,4,4} N=4
        //{6,9,8,7,8,5,4,4} N=4
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < i; j++) {
                if (q.isEmpty() || q.remove() != i)
                    return false;
            }
        }

        return q.isEmpty();
    }

    private static Queue<Integer> Q1_a(int N) {
        if (N <= 0)
            return null;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < i; j++) {
                queue.add(i);
            }
        }
        return queue;
    }

    static class A {
        private static int countA = 0;
        protected int n;

        public A(int n1) {
            this.n = n1;
            A.countA++;
            System.out.println(A.countA + " " + this.n);
        }

        public int getN() {
            return this.n;
        }

        public void doIt() {
            for (int i = 0; i < this.n; i++)
                System.out.print(i + ",");
            System.out.println();
        }

        public void print() {
            System.out.println(this.n);
        }
    }

    static class B extends A {
        private static int countB = 0;

        public B(int n2) {
            super(n2);
            B.countB++;
            System.out.println(B.countB + " " + n2);
        }

        public void doIt() {
            System.out.println("B Does It!");
        }
    }

    static class C extends B {
        private static int countC = 0;
        private A a;

        public C(int n1, int n2) {
            super(n1);
            this.a = new A(n2);
            countC++;
            System.out.println("C is " + (a.getN() + this.n));
        }

        public void print() {
            super.print();
            this.a.print();
        }
    }

    static class Test {
        private A[] arr;

        public Test() {
            arr = new A[3];
            arr[0] = new A(4);
            arr[1] = new B(2);
            arr[2] = new C(1, 6);
        }

        public void testIt() {
            for (int i = 0; i < arr.length; i++) {
                arr[i].doIt();
                arr[i].print();
            }
        }
    }

}

