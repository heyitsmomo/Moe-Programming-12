public class Main {
    public static void main(String[] args) {
        TwoDShape triangle = new Triangle(3.0, 4.0, 5.0);
        triangle.getArea();
        ((Triangle) triangle).getHeight();
        System.out.println(triangle.toString());
    }
}



