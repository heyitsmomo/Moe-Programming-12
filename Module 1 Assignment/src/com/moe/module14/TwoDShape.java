package com.moe.module14;

public abstract class TwoDShape {
    private double width;
    private double height;
    Colour colour;

    /**
     * 2D SHAPE CONSTRUCTOR
     */
    public TwoDShape() {
        this.width = 0.0;
        this.height = 0.0;
    }

    /**
     * 2D SHAPE CONSTRUCTOR
     * @param width of shape in double
     * @param height of shape in double
     * @param colour of shape
     */
    public TwoDShape(double width, double height, Colour colour) {
        this.width = width;
        this.height = height;
        this.colour = colour;
    }

    /**
     * GET WIDTH
     * @return width of shape in double
     */
    public double getWidth() {
        return width;
    }

    /**
     * SET WIDTH
     * @param width of shape in double
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * GET HEIGHT
     * @return height of shape in double
     */
    public double getHeight() {
        return height;
    }

    /**
     * SET HEIGHT
     * @param height of shape in double
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * GET AREA
     * @return area depending on the shape
     */
    public abstract double getArea();

    /**
     * SET
     * @param width of shape in double
     * @param height of shape in double
     */
    public void set(double width, double height) {
        this.width = width;
        this.height = height;
    }

    /**
     * OVERALL RESULT IN STRING
     * @return string of overall result depending on shape
     */
    @Override
    public String toString() {
        return "Shape: " + getClass().getSimpleName() +
                "\nWidth: " + width +
                "\nHeight: " + height +
                "\nArea: " + getArea();
    }
}