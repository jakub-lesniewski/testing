import static org.junit.jupiter.api.Assertions.*;

import org.junit.*;

public class PolygonTest {
    @Test
    public void testGetCircuit() {
        Point[] points = new Point[] {
                new Point(1, 1),
                new Point(1, 2),
                new Point(2, 1),
                new Point(2, 2)
        };
        Polygon polygon = new Quadrangle(points);

        assertEquals(4.0, polygon.getCircuit(), 0.00001); // niepowodzenie, otrzymano 4.82842712474619 d
    }
}