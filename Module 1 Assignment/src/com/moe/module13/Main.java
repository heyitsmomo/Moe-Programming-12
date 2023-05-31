package com.moe.module13;

public class Main {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(2.0, 4.0, 6.0);
        System.out.println("Shape Details: ");
        System.out.print(triangle.toString());
        System.out.println();
        triangle.rotate180();
    }
}