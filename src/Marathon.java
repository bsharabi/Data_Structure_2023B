import java.util.ArrayList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class Marathon {
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
                    Node<Integer> chain = new Node<>(new Node<>(new Node<>(new Node<>(new Node<>(new Node<>(new Node<>(0), 1), -4), 1), 2), 3), 2);
                    printNodes(chain);
                    int numberNodes = numberNodesFollowing(chain.getNext().getNext());
                    System.out.println(numberNodes);
                    bool = isSection(chain);
                    break;
                case 3:
//                    A[] data = new A[5];
//                    data [0] = new A (5);
//                    data [1] = new B(5,10);
//                    data [2] = new C(5,10,15);
//                    data [3] = data [0];
//                    data [4] = new B(5);
//                    for (int i = 0; i < data.length; i++)
//                        System.out.println(data[i]);
//                    for(int i=0;i< data.length;i++)
//                        data [i].change();
//                    for (int i = 0; i < data.length; i++)
//                        System.out.println(data[i]);
                    break;
                case 4:
                    B b = new B(1);
                    C c = new C(1);
                    D d = new D(1);
                    B b1 = new D(1);
                    Object c1 = new C(1);
                    Object d1 = new D(1);
                    System.out.println(b1.equals(b));
                    System.out.println(c1.equals(c));
                    System.out.println(d1.equals(d));
                    System.out.println(d.equals((D) d1));

                    break;
                case 5:
                    break;
                case 6:
                    Inter1 x = new F();
                    G y = new G();
                    Inter3 z = new H();
                    //Inter1 x = new G();
                    x = y;
                    y = new H();
                    y.g2();
                    z.g3();
                    ((H) z).g4();
                    z = new F();
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
                    break;
                case -1:
                    return;
            }
        }
    }

    private static boolean isSection(Node<Integer> chain) {
        while (chain != null) {
            if (chain.getValue() > numberNodesFollowing(chain))
                return false;
            chain = chain.getNext();
        }
        return true;
    }

    private static int numberNodesFollowing(Node<Integer> chain) {
        int count = 0;
        if (chain == null)
            return 0;
        while (chain.hasNext()) {
            chain = chain.getNext();
            count++;
        }
        return count;
    }

    private static void printNodes(Node<Integer> chain) {
        while (chain != null) {
            System.out.print(chain.getValue() + " -> ");
            chain = chain.getNext();
        }
        System.out.println("null");
    }

    interface Inter1 {
        void g1();
    }

    interface Inter2 {
        void g2();
    }

    interface Inter3 {
        void g3();
    }

    static class F extends H implements Inter1 {

        @Override
        public void g1() {

        }
    }

    static class G implements Inter1, Inter2 {

        @Override
        public void g1() {

        }

        @Override
        public void g2() {

        }
    }

    static class H extends G implements Inter3 {


        void g4() {
        }

        @Override
        public void g3() {

        }
    }

    static public class B {
        protected int num;

        public B(int num) {
            this.num = num;
        }
    } // end of B

    static public class C extends B {
        public C(int num) {
            super(num);
        }

        public boolean equals(Object other) {
            return ((other != null) && (other instanceof C) &&
                    (num == ((C) other).num));
        }
    } // end of C

    static public class D extends B {
        public D(int num) {
            super(num + 1);
        }

        public boolean equals(D other) {
            return ((other != null) && (num == other.num));
        }
    } // end of D
//   static public class A
//    {
//        protected int x;
//        public A()
//        {
//            this.x = 1;
//        }
//        public A(int x)
//        {
//            this.x = x;
//        }
//        public void change()
//        {
//            this.x = this.x * 2;
//        }
//        public String toString()
//        {
//            return "X=" + this.x;
//        }
//    }
//   static public class B extends A
//    {
//        protected int y;
//        public B(int y)
//        {
//            this.y = -y;
//        }
//        public B(int x,int y)
//        {
//            super(x);
//            this.y = -y;
//        }
//        public String toString()
//        {
//            return super.toString() + " Y=" + this.y;
//        }
//    }
//  static   public class C extends B
//    {
//        private int z;
//        public C(int x,int y,int z)
//        {
//            super(x,y);
//            this.z = z;
//        }
//        public void change()
//        {
//            this.x = 3 * this.x;
//            this.y = 3 * this.y;
//            this.z = 3 * this.z;
//        }
//        public String toString()
//        {
//            return super.toString() + " Z=" + this.z;
//        }
//    }

    static class Area {
        private String color;
        private int free;
        private Node<String> carsNumber;


        public boolean add(String carNumber) {
            Node<String> newNode = new Node<>(carNumber);
            if (carNumber == null)
                carsNumber = newNode;
            else {
                newNode.setNext(carsNumber);
                carsNumber = newNode;
            }
            return true;
        }

        public Area(String color, int free, Node<String> carNumber) {
            this.color = color;
            this.free = free;
            this.carsNumber = null;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public int getFree() {
            return free;
        }

        public void setFree(int free) {
            this.free = free;
        }

        public Node<String> getCarNumber() {
            return carsNumber;
        }

        public void setCarNumber(Node<String> carNumber) {
            this.carsNumber = carNumber;
        }

        public boolean isFree() {
            return free > 0;
        }
    }

    static class Floor {

        private int floorNumber;
        private Node<Area> areas;

        public Floor(int floorNumber, ArrayList<Area> areas) {
            this.floorNumber = floorNumber;
            this.areas = null;
        }

        public String hasFreeParking(String carNumber) {
            if (isEmpty())
                return "no room";

            Node<Area> temp = areas;

            while (temp != null) {
                if (temp.getValue().isFree()) {
                    temp.getValue().add(carNumber);
                    return temp.getValue().getColor();
                }
                temp = temp.getNext();
            }
            return "no room";
        }

        public boolean isEmpty() {
            return areas == null;
        }

    }

    static class Parking {
        private Floor[] floors;

        //  POLL <-[222,333,444,555,666]<-INSERT
        //[area1,area2,area3]
        //[area4] i=1 , res = red
        //[area5,area6]
        //[area7,area8]
        //[area9]
        //[area10]


        public String wait(Queue<String> q) {
            int i = 0;
            String res = "";
            while (!q.isEmpty()) {
                String carNumber = q.peek();
                while (i < floors.length) {
                    if (!(res = floors[i].hasFreeParking(carNumber)).equals("no room"))
                        break;
                    i++;
                }
                if (res.equals("no room")) {
                    return "NOT ALL";
                } else {
                    System.out.println(res);
                    System.out.println(floors[i].floorNumber);
                }
                q.poll();
            }
            return "ALL";
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
}

