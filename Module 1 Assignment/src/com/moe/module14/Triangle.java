package com.moe.module14;

public class Triangle extends TwoDShape implements Rotate{
    private double side1;
    private double side2;
    private double side3;

    /**
     * TRIANGLE CONSTRUCTOR WITH WIDTH AND HEIGHT
     * @param width of triangle in double
     * @param height of triangle in double
     * @param colour of triangle
     */
    public Triangle(double width, double height, Colour colour) {
        super(width, height, colour);
        set(0.0,0.0,0.0);
        this.colour = colour;
        setHeight(heronsHeight());
    }

    /**
     * TRIANGLE CONSTRUCTOR WITH 3 SIDES
     * @param side1 of triangle in double
     * @param side2 of triangle in double
     * @param side3 of triangle in double
     * @param colour of triangle
     */
    public Triangle(double side1, double side2, double side3, Colour colour) {
        super();
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.colour = colour;
        setHeight(heronsHeight());
    }

    /**
     * GET SIDE 1
     * @return side 1 length in double
     */
    public double getSide1() {
        return side1;
    }

    /**
     * SET SIDE 1
     * @param side1 of triangle in double
     */
    public void setSide1(double side1) {
        this.side1 = side1;
    }

    /**
     * GET SIDE 2
     * @return side 2 length in double
     */
    public double getSide2() {
        return side2;
    }

    /**
     * SET SIDE 2
     * @param side2 of triangle in double
     */
    public void setSide2(double side2) {
        this.side2 = side2;
    }

    /**
     * GET SIDE 3
     * @return side 3 length in double
     */
    public double getSide3() {
        return side3;
    }

    /**
     * SET SIDE 3
     * @param side3 of triangle in double
     */
    public void setSide3(double side3) {
        this.side3 = side3;
    }

    /**
     * GET AREA
     * @return area of triangle using Heron's formula
     */
    @Override
    public double getArea() {
        double s = (side1 + side2 + side3)/2;
        double area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
        return area;
    }

    /**
     * HERON'S HEIGHT
     * @return height of triangle using Heron's formula
     */
    private double heronsHeight() {
        double area = getArea();
        double height = (2 * area)/side1;
        return height;
    }

    /**
     * SET SIDES
     * @param side1 of triangle in double
     * @param side2 of triangle in double
     */
    @Override
    public void set(double side1, double side2) {
        setSide1(side1);
        setSide2(side2);
    }

    /**
     * SET SIDES
     * @param side1 of triangle in double
     * @param side2 of triangle in double
     * @param side3 of triangle in double
     */
    public void set(double side1, double side2, double side3) {
        setSide1(side1);
        setSide2(side2);
        setSide3(side3);
    }

    /**
     * OVERALL RESULTS IN STRING
     * @return string of overall results on triangle
     */
    @Override
    public String toString() {
        return super.toString() +
                "\nSide 1: " + side1 +
                "\nSide 2: " + side2 +
                "\nSide 3: " + side3 +
                "\nHeron's Height: " + heronsHeight() +
                "\nColour: " + colour.getName();
    }

    /**
     * ROTATE 90 DEGREES
     */
    @Override
    public void rotate90() {
        System.out.println("Rotate: 90 degrees");
    }

    /**
     * ROTATE 180 DEGREES
     */
    @Override
    public void rotate180() {
        System.out.println("Rotate: 180 degrees");
    }

    /**
     * ROTATE
     * @param degree of rotated triangle in double
     */
    @Override
    public void rotate(double degree) {
        System.out.println("Rotate: " + degree + " degrees");
    }
}
