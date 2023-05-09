package L08;

import java.util.*;

public class Mahat_Summer_2021A {
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
                    Tablet t = new Tablet();
                    Tablet t1 = new Tablet();
                    t.isSame(t1);
                    break;
                case 2:
                    Queue<Integer> queue = new LinkedList<Integer>() {{
                        add(1);
                        add(2);
                        add(3);
                        add(4);
                        add(5);
                    }};
                    Queue<Integer> q = Q2(queue);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    A a = new A();
                    B b = new B();
                    A ab = new B();
                    a.f();
                    ab.f();
                    b.f();
                    a.g();
                    ab.g();
                    b.g();
                    ((B) (ab)).superG();
                    b.superG();
//                    a.superG();
//                    ((B)a).superG();
                    System.out.println("שגיאת קומפילציה, לא ניתן לקרוא לפונקציה שלא קיימת במחלקה או במי שמרחיב אותה אם בכלל");
                    System.out.println("שגיאת זמן ריצה, לא ניתן לבצע המרה של מחלקת אב למחלקת בן");
                    break;
                case 6:
                    Apple apple = new Apple(4);
                    Banana banana = new Banana(4);
                    System.out.println("במחלקת תפוח קיימת העמסה של פונקציית ה-equals ממחלקת האב Object");
                    System.out.println("במחלקת בננה קיימת דריסה של פונקצייה ה-equals ממחלקת האב Object על ידי הצהרת פונקציה בעלת חתימה זהה");


                    System.out.println("************");
                    Apple a1 = new Apple(10);
                    Object a2 = new Apple(10);
                    Banana b1 = new Banana(10);
                    Object b2 = new Banana(10);
//                    System.out.println (a1.weight); תקין
//                    System.out.println (((Banana)a2).getWeight()); זמן ריצה
//                    System.out.println (a1.equals(a2)); תקין
//                    System.out.println(a2.equals(a1));
//                    System.out.println(b1.equals(b2));
//                    System.out.println(b2.equals(b1));
//                    System.out.println(a1.equals((Banana) b2));
//                    System.out.println(a1.equals((Apple) a2));
//                    System.out.println(b1.equals((Apple) a2));
//                    System.out.println(b1.equals((Banana) a2));
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

    static public class Apple {
        private int weight;

        public Apple(int w) {
            weight = w;
        }

        public int getWeight() {
            return weight;
        }

        public boolean equals(Apple other) {
            return ((other != null) &&
                    (weight == other.weight));
        }
    }

    static public class Banana {
        private int weight;

        public Banana(int w) {
            weight = w;
        }

        public int getWeight() {
            return weight;
        }

        public boolean equals(Object other) {
            return ((other != null) &&
                    (other instanceof Banana) &&
                    (weight == ((Banana) other).weight));
        }
    }

    private static Queue<Integer> Q2(Queue<Integer> queue) {
        if (queue == null)
            return null;
        Queue<Integer> q = new LinkedList<>();
        int size = queue.size();// במבחן צריך לכתוב את הפונקציה

        while (!queue.isEmpty()) {
            int cnt = 1;
            int item1 = queue.remove();
            size--;
            for (int i = 0; i < size; i++) {
                int item2 = queue.remove();
                if (item1 == item2) {
                    cnt++;
                    size--;
                } else {
                    queue.add(item2);
                }
            }
            if (cnt > 2)
                q.add(item1);
        }
        return q;
    }

    static public Queue<Integer> Q2_(Queue<Integer> queue) {
        if (queue == null)
            return null;
        //queue={}
        //q1={}
        //q={2}
        // temp = {}
        //item1 = 2
        //item2 =6
        // count=1
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> temp;
        int count = 1;
        while (!queue.isEmpty()) {
            int item1 = queue.remove();
            while (!queue.isEmpty()) {
                int item2 = queue.remove();
                if (item1 == item2)
                    count++;
                else
                    q1.add(item2);
            }
            if (count > 2)
                q.add(item1);
            count = 1;

            temp = queue;
            queue = q1;
            q1 = temp;

        }

        return q;
    }

    static class A {
        public void f() {
            System.out.println("A.f");
        }

        public void g() {
            this.f();
        }


    }

    static public class B extends A {
        public void f() {
            System.out.println("B.f");
        }

        public void g() {
            System.out.println("B.g");
        }

        public void superG() {
            super.g();
        }
    }

    static public class Store {
        private Tablet[] tablets;
        private int[] systems;

        public Store() {
            tablets = new Tablet[1000];
            systems = new int[3];
        }

        public boolean addTablet(Tablet tab) {

            if (tab == null)
                return false;

            int index = systems[0] + systems[1] + systems[2];
            if (index >= tablets.length)
                return false;

            for (int i = 0; i < index; i++) {
                if (tab.isSame(tablets[i])) {
                    tablets[i].setPrice(Math.max(tablets[i].getPrice(), tab.getPrice()));
                    return true;
                }
            }
            tablets[index] = tab;
            switch (tab.getSystem()) {

                case 'A':
                    systems[1]++;
                    break;
                case 'I':
                    systems[2]++;
                    break;
                case 'W':
                    systems[0]++;
                    break;
            }
            return true;
        }


        // יש לנסות לפתור את התרגיל גם ללא שימוש במבנה נתונים.
        public int sortStore() {
            int index = systems[0] + systems[1] + systems[2];
            LinkedList<Tablet> win = new LinkedList<>();
            LinkedList<Tablet> ios = new LinkedList<>();
            LinkedList<Tablet> android = new LinkedList<>();

            for (int i = 0; i < index; i++) {
                switch (tablets[i].getSystem()) {
                    case 'W':
                        win.add(tablets[i]);
                        break;
                    case 'I':
                        ios.add(tablets[i]);
                        break;
                    case 'A':
                        android.add(tablets[i]);
                        break;
                }
                int j = 0;
                while (!win.isEmpty())
                    tablets[j++] = win.removeFirst();
                while (!android.isEmpty())
                    tablets[j++] = android.removeFirst();
                while (!ios.isEmpty())
                    tablets[j++] = ios.removeFirst();
            }
            return tablets.length - index;
        }
    }

    static public class Tablet {
        private String name;
        private String kind;
        private char system;
        private double size;
        private double price;

        public Tablet() {
        }


        public boolean isSame(Tablet other) {
            if (other == null)
                return false;
            return name.equals(other.name) && kind.equals(other.kind) && size == other.size;

        }

        public Tablet(String name, String kind, char system, double size, double price) {
            this.name = name;
            this.kind = kind;
            this.system = system;
            this.size = size;
            this.price = price;
        }

        public char getSystem() {
            return system;
        }

        public void setSystem(char system) {
            this.system = system;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getKind() {
            return kind;
        }

        public void setKind(String kind) {
            this.kind = kind;
        }


        public double getSize() {
            return size;
        }

        public void setSize(double size) {
            this.size = size;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}
