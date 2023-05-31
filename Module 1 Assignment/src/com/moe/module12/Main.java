package com.moe.module12;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<TwoDShape> shapes = new ArrayList<>();
        shapes.add(new Circle(5.0));
        shapes.add(new Triangle(2.0, 4.0, 6.0));
        shapes.add(new Circle(3.0));
        shapes.add(new Triangle(3.0, 4.0, 5.0));

        for(TwoDShape shape : shapes) {
            System.out.println("Shape Details: ");
            System.out.println(shape.toString());
            System.out.println();
        }
    }
}
