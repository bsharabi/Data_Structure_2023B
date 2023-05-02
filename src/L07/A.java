package L07;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

abstract class C {
    public abstract void f();
    public abstract void f1();
    public abstract void f2();
    public abstract void f3();
    public abstract void f4();
}


class B extends C{

    public B(int num) {
    }

    public final void f() {

    }

    @Override
    public void f1() {

    }

    @Override
    public void f2() {

    }

    @Override
    public void f3() {

    }

    @Override
    public void f4() {

    }
}


public class A extends B implements Comparable<A> {
    static int a;
    public int num;
    public Main n = new Main();



    public A(A other) {
        super(10);
        num = other.num;

    }

    public A(int num) {
        super(10);
        this.num = num;
    }

    public A() {
        super(10);
    }

    @Override
    public String toString() {
        return "A{" +
                "num=" + num +
                '}';
    }

    @Override
    public int compareTo(A o) {
        if(this.num<o.num)
            return this.num-o.num;
        else if(this.num>o.num)
            return this.num-o.num;
        else return 0;
    }
}

class Test {

    public static void main(String[] args) {
        A a = new A(8);
        System.out.println(a);
        A.a = 9;
        A a1 = new A(a);
        a.num = 9;
        a.compareTo(a1);
        System.out.println(a);
        System.out.println(a1);
        a1.num = 78;
        System.out.println(a);
        System.out.println(a1);

        List[] lists = new List[10];
        lists[0] = new LinkedList();
        lists[1] = new ArrayList();

        LinkedList ll = (LinkedList) lists[0];


        String str = "fdjh";
        String newStr = "";
        newStr += str.charAt(0);
        StringBuilder s = new StringBuilder();



    }

}
