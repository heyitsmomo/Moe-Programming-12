package com.moe.module14;

public class Main {

    /**
     * MAIN METHOD
     * @param no args used
     */
    public static void main(String[] args) {
        Triangle triangle = new Triangle(3.0, 5.0, 7.0, Colour.GREEN);
        System.out.println("SHAPE DETAILS: ");
        System.out.println(triangle.toString());
        triangle.rotate90();

        System.out.println();

        Circle circle = new Circle(2.0, Colour.BLUE);
        System.out.println("SHAPE DETAILS: ");
        System.out.println(circle.toString());
    }
}