package L06;


import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Example {

}

interface IFillable {
    void fill(String color);
}

interface ITurnable {
    void left(int degree);

    void right(int degree);
}

abstract class Shape {
    protected String color;
    protected Point point;
}

class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Circle extends Shape implements IFillable {
    private double radius;

    public void fill(String color) {
    }

    public Circle(Point p, double radius) {
        this.radius = radius;
        this.point = p;
    }
}

class Square extends Shape implements IFillable, ITurnable {
    protected double length1;

    public void fill(String color) {
    }

    public void left(int degree) {
    }

    public void right(int degree) {
    }

    public Square(Point p, double length1) {
        this.length1 = length1;
        this.point = p;
    }


}

class Rectangle extends Square {
    private double length2;

    public Rectangle(double length2, Point p, double length1) {
        super(p, length1);
        this.length2 = length2;
    }

}