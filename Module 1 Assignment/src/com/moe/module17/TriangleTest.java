import com.moe.module14.Colour;
import com.moe.module14.Triangle;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TriangleTest {
    /*
    GET AREA
    s is equal to one of the sides, area is 0
    s is not equal to any of the sides, area > 0
    HERONS HEIGHT
    area is 0, herons height is 0
    area > 0, herons height > 0
     */

    @Test
    public void testGetArea() {
        Triangle triangle1 = new Triangle(2.0, 4.0, 6.0, Colour.NONE);
        double expArea1 = 0.0;
        double area1 = triangle1.getArea();
        assertEquals(expArea1, area1, 0.0);

        Triangle triangle2 = new Triangle(3.0, 5.0, 7.0, Colour.RED);
        double expArea2 = 6.495190528;
        double area2 = triangle2.getArea();
        assertEquals(expArea2, area2, 0.0);
    }

    @Test
    public void testHeronsHeight() {
        Triangle triangle = new Triangle(3.0, 5.0, 7.0, Colour.GREEN);
        double expHeight = 4.330127019;
        double height = (2 * triangle.getArea())/triangle.getSide1();
        assertEquals(expHeight, height, 0.0);
    }

}