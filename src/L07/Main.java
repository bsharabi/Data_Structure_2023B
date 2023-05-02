package L07;

public class Main {
    public static void main(String[] args) {
//        B1 b = new B1();
//        C1 c = new C1();
//        D1 d = new D1();
        Object object = new F1();
        E1 test = new F1();

        ((E1)test).func();

        System.out.println(test);

        I2 i = new F1();
        I2 i1 = new G1();





    }
}

abstract class A1 {
    static int n;
    int num;

    public A1() {
        System.out.println("Hello constructor A1");
    }

    public A1(int num) {
        System.out.println("Hello constructor A1");
    }
}

class B1 extends A1 {
    int num1;
    int num2;
    int num3;

    public B1(int num) {
        super(8);
        System.out.println("Hello constructor B1");
        num = 9;
    }

    public B1() {
        System.out.println("Hello constructor B1");
        num = 9;
    }
}

class C1 extends B1 {

    int num2;

    public C1(int num2) {
        super();
        System.out.println("Hello constructor C1");
    }

    public C1() {
        super(8);
        System.out.println("Hello constructor C1");
    }
}

class D1 extends C1 {
    public D1() {
        super(2);
        System.out.println("Hello constructor D1");
    }
}

interface I1 {
    void f();

    void f1();

    void f2();

}

interface I2 extends I1 {
    void g();

    void g1();

    void g2();

}

class E1 implements I2 {
    int num1;
    int num2;

    public void func() {
        System.out.println("Func E1");
    }

    @Override
    public void f() {

    }

    @Override
    public void f1() {

    }

    @Override
    public void f2() {

    }

    @Override
    public void g() {

    }

    @Override
    public void g1() {

    }

    @Override
    public void g2() {

    }
}

class F1 extends E1 {
    int num1;
    int num2;

    public void func() {
        System.out.println("Func F1");
    }
}

class G1 extends F1 {
    int num1;
    int num2;

    public void func() {

    }

    public int func(int num1) {
        return 0;
    }
}

class H1 extends E1 {
    int num1;
    int num2;

    public void func() {

    }

    public void func2() {

    }

    @Override
    public String toString() {
        return "H1{" +
                "num1=" + num1 +
                ", num2=" + num2 +
                '}';
    }
}