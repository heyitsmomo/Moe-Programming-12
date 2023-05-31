public class Circle extends TwoDShape{
    public static final double PI = 3.14;
    private double radius;

    public Circle(double radius, Colour colour) {
        super();
        this.radius = radius;
        this.colour = colour;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return PI * radius * radius;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nRadius: " + radius +
                "\nColour: " + colour.getName();
    }
}