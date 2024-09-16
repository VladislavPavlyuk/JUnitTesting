package brainacad.shapes.utils;

import org.junit.jupiter.api.Test;
import brainacad.shapes.models.*;

import static org.junit.jupiter.api.Assertions.*;

public class ShapeTest {

    @Test
    public void testTriangleArea() {
        Triangle triangle = new Triangle(10, 5);
        assertEquals(25, triangle.calculateArea());
    }

    @Test
    public void testRectangleArea() {
        Rectangle rectangle = new Rectangle(10, 5);
        assertEquals(50, rectangle.calculateArea());
    }

    @Test
    public void testSquareArea() {
        Square square = new Square(5);
        assertEquals(25, square.calculateArea());
    }

    @Test
    public void testRhombusArea() {
        Rhombus rhombus = new Rhombus(10, 5);
        assertEquals(25, rhombus.calculateArea());
    }
}

