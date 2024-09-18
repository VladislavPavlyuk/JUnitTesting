package brainacad;

import org.junit.jupiter.api.Test;
import brainacad.shapes.models.*;

import static org.junit.jupiter.api.Assertions.*;

public class ShapeTest {

    @Test
    public void test_should_return_25_if_called() {
        Triangle triangle = new Triangle(10, 5);
        assertEquals(25, triangle.calculateArea());
    }

    @Test
    public void test_should_return_50_if_called() {
        Rectangle rectangle = new Rectangle(10, 5);
        assertEquals(50, rectangle.calculateArea());
    }

    @Test
    public void test2_should_return_25_if_called() {
        Square square = new Square(5);
        assertEquals(25, square.calculateArea());
    }

    @Test
    public void test3_should_return_25_if_called() {
        Rhombus rhombus = new Rhombus(10, 5);
        assertEquals(25, rhombus.calculateArea());
    }
}

