package com.company;

public class Line implements  Cloneable{
    private Point A,B;
    int thickness;

    public Line(Point a, Point b,int thickness) {
        A = a;
        B = b;
        this.thickness=thickness;
    }

    public Line() {
    }

    public Point getA() {
        return A;
    }

    public void setA(Point a) {
        A = a;
    }

    public Point getB() {
        return B;
    }

    public void setB(Point b) {
        B = b;
    }

    public int getThickness() {
        return thickness;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    //Some reference fields,so we need deep copy.
    @Override
    public Line clone() throws CloneNotSupportedException
    {
        Line line = new Line();
        line.thickness=this.thickness;

        Point A = (Point) this.A.clone();
        Point B = (Point) this.B.clone();

        line.setA(A);
        line.setB(B);

        return line;


    }

    @Override
    public String toString() {
        return "Line{" +
                "A=" + A +
                ", B=" + B +
                ", thickness=" + thickness +
                '}';
    }
}
