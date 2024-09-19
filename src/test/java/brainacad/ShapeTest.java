package brainacad;

import org.junit.jupiter.api.Test;
import brainacad.shapes.models.*;

import static org.junit.jupiter.api.Assertions.*;

public class ShapeTest {

    @Test
    public void triangleTest_should_return_25_if_called() {
        Triangle triangle = new Triangle(10, 5);
        assertEquals(25, triangle.calculateArea());
    }

    @Test
    public void rectangleTest_should_return_50_if_called() {
        Rectangle rectangle = new Rectangle(10, 5);
        assertEquals(50, rectangle.calculateArea());
    }

    @Test
    public void squareTest_should_return_36_if_called() {
        Square square = new Square(6);
        assertEquals(36, square.calculateArea());
    }

    @Test
    public void rhombusTest_should_return_10_if_called() {
        Rhombus rhombus = new Rhombus(4, 5);
        assertEquals(10, rhombus.calculateArea());
    }
}

