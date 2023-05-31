package com.moe.module14;

public class Circle extends TwoDShape{

    public static final double PI = 3.14;
    private double radius;

    /**
     * CIRCLE CONSTRUCTOR
     * @param radius of circle in double
     * @param colour of circle
     */
    public Circle(double radius, Colour colour) {
        super();
        this.radius = radius;
        this.colour = colour;
    }

    /**
     * GET RADIUS
     * @return radius of circle in double
     */
    public double getRadius() {
        return radius;
    }

    /**
     * SET RADIUS
     * @param radius of circle in double
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * GET AREA
     * @return area of the circle in double
     */
    @Override
    public double getArea() {
        return PI * radius * radius;
    }

    /**
     * OVERALL RESULTS IN STRING
     * @return String of results on circle
     */
    @Override
    public String toString() {
        return super.toString() +
                "\nRadius: " + radius +
                "\nColour: " + colour.getName();
    }
}