import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {
    Point[] points = new Point[]{
            new Point(0, 5),
            new Point(0, 0),
            new Point(5, 0)};
    Triangle triangle = new Triangle(points);

    @Test
    public void testGetTriangleType() {
        assertEquals("isosceles right", triangle.getTriangleType()); // pozytywny
    }
}