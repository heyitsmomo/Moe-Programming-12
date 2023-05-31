import com.moe.module14.Circle;

import com.moe.module14.Colour;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CircleTest {
    //partition
    /*
    GET AREA
    radius is 0 , area is 0
    radius > 0, area > 0
     */
    @Test
    public void testGetArea() {
        Circle circle = new Circle(2.0, Colour.BLUE);
        double expArea = 12.56;
        double area = circle.getArea();
        assertEquals(expArea, area, 0.0);
    }
}