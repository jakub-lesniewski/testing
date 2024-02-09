import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CircleTest {
    Point[] points = new Point[]{
            new Point(0, 0),
            new Point(5, 0)
    };
    Circle circle = new Circle(points, 5);

    @Test
    public void testGetArea() {
        assertEquals(78.5, circle.getArea(), 0.2); // pozytywny
    }
}