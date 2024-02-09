import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

public class QuadrangleTest {
    Point[] points = new Point[]{
            new Point(0, 0),
            new Point(0, 2),
            new Point(1, 2),
            new Point(1, 0)};
    Quadrangle quadrangle = new Quadrangle(points);

    @Test
    public void testGetArea() {
        assertEquals(2.0, quadrangle.getArea(), 0.00001); // pomyślny
    }
}