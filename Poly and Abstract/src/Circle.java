public class Circle extends TwoDShape {
    public static final double PI = 3.14;
    private double radius;

    public Circle(double radius) {
        super();
        this.radius = radius;
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
                "\nRadius: " + radius;
    }
}
