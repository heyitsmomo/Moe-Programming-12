package com.moe.module13;

public class Triangle extends TwoDShape implements Rotate{
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double width, double height) {
        super(width, height);
        set(0.0,0.0,0.0);
        setHeight(heronsHeight());
    }
    public Triangle(double side1, double side2, double side3) {
        super();
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        setHeight(heronsHeight());
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    @Override
    public double getArea() {
        double s = (side1 + side2 + side3)/2;
        double area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
        return area;
    }
    private double heronsHeight() {
        double area = getArea();
        double height = (2 * area)/side1;
        return height;
    }

    @Override
    public void set(double side1, double side2) {
        setSide1(side1);
        setSide2(side2);
    }

    public void set(double side1, double side2, double side3) {
        setSide1(side1);
        setSide2(side2);
        setSide3(side3);
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nSide 1: " + side1 +
                "\nSide 2: " + side2 +
                "\nSide 3: " + side3 +
                "\nHeron's Height: " + heronsHeight();
    }

    @Override
    public void rotate90() {
        System.out.println("Rotated 90 degrees");
    }

    @Override
    public void rotate180() {
        System.out.println("Rotated 180 degrees");
    }

    @Override
    public void rotate(double degree) {
        System.out.println("Rotated " + degree + " degrees");
    }
}