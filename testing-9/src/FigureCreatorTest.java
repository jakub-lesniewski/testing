import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FigureCreatorTest {
    Point[] points = new Point[]{
            new Point(0, 4),
            new Point(0, 6),
            new Point(2, 2),
            new Point(4, 4)};

    @Test
    public void testGetTriangleType() throws Exception {
        Point[] points2 = FigureCreator.parseLine("(0,4) (0,6) (2,2) (4,4)");
        for (int i = 0; i < points.length; i++) {
            assertEquals(points[i].getX(), points2[i].getX(), 0.001);
            assertEquals(points[i].getY(), points2[i].getY(), 0.001);
        }
    }
} // pozytywny