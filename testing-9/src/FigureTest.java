import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FigureTest {
    @Test
    public void testCheckIfLinear() {
        Point[] point = new Point[]{
                new Point(0, 0),
                new Point(0, 1),
                new Point(0, 3),
                new Point(0, 5)};
        assertTrue(Figure.checkIfLinear(point)); // pozytywny
    }
}