package brainacad;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import brainacad.shapes.models.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тесты для вычисления площади геометрических фигур")
public class ShapeTest {

    // ========== ТРЕУГОЛЬНИК ==========
    
    @Test
    @DisplayName("Треугольник: нормальный случай")
    public void triangleTest_normalCase() {
        Triangle triangle = new Triangle(10, 5);
        assertEquals(25.0, triangle.calculateArea(), 0.001);
    }

    @Test
    @DisplayName("Треугольник: площадь с дробными значениями")
    public void triangleTest_decimalValues() {
        Triangle triangle = new Triangle(7.5, 4.2);
        assertEquals(15.75, triangle.calculateArea(), 0.001);
    }

    @Test
    @DisplayName("Треугольник: большие значения")
    public void triangleTest_largeValues() {
        Triangle triangle = new Triangle(100, 50);
        assertEquals(2500.0, triangle.calculateArea(), 0.001);
    }

    @Test
    @DisplayName("Треугольник: маленькие значения")
    public void triangleTest_smallValues() {
        Triangle triangle = new Triangle(0.5, 0.3);
        assertEquals(0.075, triangle.calculateArea(), 0.001);
    }

    @Test
    @DisplayName("Треугольник: нулевая высота")
    public void triangleTest_zeroHeight() {
        Triangle triangle = new Triangle(10, 0);
        assertEquals(0.0, triangle.calculateArea(), 0.001);
    }

    @Test
    @DisplayName("Треугольник: нулевое основание")
    public void triangleTest_zeroBase() {
        Triangle triangle = new Triangle(0, 5);
        assertEquals(0.0, triangle.calculateArea(), 0.001);
    }

    @Test
    @DisplayName("Треугольник: оба значения нулевые")
    public void triangleTest_bothZero() {
        Triangle triangle = new Triangle(0, 0);
        assertEquals(0.0, triangle.calculateArea(), 0.001);
    }

    @Test
    @DisplayName("Треугольник: отрицательное основание - исключение")
    public void triangleTest_negativeBase() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Triangle(-5, 10);
        });
    }

    @Test
    @DisplayName("Треугольник: отрицательная высота - исключение")
    public void triangleTest_negativeHeight() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Triangle(10, -5);
        });
    }

    @Test
    @DisplayName("Треугольник: установка значений через сеттеры")
    public void triangleTest_setters() {
        Triangle triangle = new Triangle();
        triangle.setBase(8);
        triangle.setHeight(6);
        assertEquals(24.0, triangle.calculateArea(), 0.001);
    }

    // ========== ПРЯМОУГОЛЬНИК ==========

    @Test
    @DisplayName("Прямоугольник: нормальный случай")
    public void rectangleTest_normalCase() {
        Rectangle rectangle = new Rectangle(10, 5);
        assertEquals(50.0, rectangle.calculateArea(), 0.001);
    }

    @Test
    @DisplayName("Прямоугольник: площадь с дробными значениями")
    public void rectangleTest_decimalValues() {
        Rectangle rectangle = new Rectangle(7.5, 4.2);
        assertEquals(31.5, rectangle.calculateArea(), 0.001);
    }

    @Test
    @DisplayName("Прямоугольник: квадрат (частный случай)")
    public void rectangleTest_squareCase() {
        Rectangle rectangle = new Rectangle(5, 5);
        assertEquals(25.0, rectangle.calculateArea(), 0.001);
    }

    @Test
    @DisplayName("Прямоугольник: большие значения")
    public void rectangleTest_largeValues() {
        Rectangle rectangle = new Rectangle(100, 50);
        assertEquals(5000.0, rectangle.calculateArea(), 0.001);
    }

    @Test
    @DisplayName("Прямоугольник: маленькие значения")
    public void rectangleTest_smallValues() {
        Rectangle rectangle = new Rectangle(0.5, 0.3);
        assertEquals(0.15, rectangle.calculateArea(), 0.001);
    }

    @Test
    @DisplayName("Прямоугольник: нулевая длина")
    public void rectangleTest_zeroLength() {
        Rectangle rectangle = new Rectangle(0, 5);
        assertEquals(0.0, rectangle.calculateArea(), 0.001);
    }

    @Test
    @DisplayName("Прямоугольник: нулевая ширина")
    public void rectangleTest_zeroWidth() {
        Rectangle rectangle = new Rectangle(10, 0);
        assertEquals(0.0, rectangle.calculateArea(), 0.001);
    }

    @Test
    @DisplayName("Прямоугольник: отрицательная длина - исключение")
    public void rectangleTest_negativeLength() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Rectangle(-5, 10);
        });
    }

    @Test
    @DisplayName("Прямоугольник: отрицательная ширина - исключение")
    public void rectangleTest_negativeWidth() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Rectangle(10, -5);
        });
    }

    @Test
    @DisplayName("Прямоугольник: установка значений через сеттеры")
    public void rectangleTest_setters() {
        Rectangle rectangle = new Rectangle();
        rectangle.setLength(8);
        rectangle.setWidth(6);
        assertEquals(48.0, rectangle.calculateArea(), 0.001);
    }

    // ========== КВАДРАТ ==========

    @Test
    @DisplayName("Квадрат: нормальный случай")
    public void squareTest_normalCase() {
        Square square = new Square(6);
        assertEquals(36.0, square.calculateArea(), 0.001);
    }

    @Test
    @DisplayName("Квадрат: площадь с дробным значением")
    public void squareTest_decimalValue() {
        Square square = new Square(5.5);
        assertEquals(30.25, square.calculateArea(), 0.001);
    }

    @Test
    @DisplayName("Квадрат: большие значения")
    public void squareTest_largeValue() {
        Square square = new Square(100);
        assertEquals(10000.0, square.calculateArea(), 0.001);
    }

    @Test
    @DisplayName("Квадрат: маленькие значения")
    public void squareTest_smallValue() {
        Square square = new Square(0.5);
        assertEquals(0.25, square.calculateArea(), 0.001);
    }

    @Test
    @DisplayName("Квадрат: нулевая сторона")
    public void squareTest_zeroSide() {
        Square square = new Square(0);
        assertEquals(0.0, square.calculateArea(), 0.001);
    }

    @Test
    @DisplayName("Квадрат: отрицательная сторона - исключение")
    public void squareTest_negativeSide() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Square(-5);
        });
    }

    @Test
    @DisplayName("Квадрат: установка значения через сеттер")
    public void squareTest_setter() {
        Square square = new Square();
        square.setSide(7);
        assertEquals(49.0, square.calculateArea(), 0.001);
    }

    @Test
    @DisplayName("Квадрат: единичная сторона")
    public void squareTest_unitSide() {
        Square square = new Square(1);
        assertEquals(1.0, square.calculateArea(), 0.001);
    }

    // ========== РОМБ ==========

    @Test
    @DisplayName("Ромб: нормальный случай")
    public void rhombusTest_normalCase() {
        Rhombus rhombus = new Rhombus(4, 5);
        assertEquals(10.0, rhombus.calculateArea(), 0.001);
    }

    @Test
    @DisplayName("Ромб: площадь с дробными значениями")
    public void rhombusTest_decimalValues() {
        Rhombus rhombus = new Rhombus(6.4, 5.2);
        assertEquals(16.64, rhombus.calculateArea(), 0.001);
    }

    @Test
    @DisplayName("Ромб: равные диагонали")
    public void rhombusTest_equalDiagonals() {
        Rhombus rhombus = new Rhombus(5, 5);
        assertEquals(12.5, rhombus.calculateArea(), 0.001);
    }

    @Test
    @DisplayName("Ромб: большие значения")
    public void rhombusTest_largeValues() {
        Rhombus rhombus = new Rhombus(100, 50);
        assertEquals(2500.0, rhombus.calculateArea(), 0.001);
    }

    @Test
    @DisplayName("Ромб: маленькие значения")
    public void rhombusTest_smallValues() {
        Rhombus rhombus = new Rhombus(0.5, 0.3);
        assertEquals(0.075, rhombus.calculateArea(), 0.001);
    }

    @Test
    @DisplayName("Ромб: нулевая первая диагональ")
    public void rhombusTest_zeroDiagonal1() {
        Rhombus rhombus = new Rhombus(0, 5);
        assertEquals(0.0, rhombus.calculateArea(), 0.001);
    }

    @Test
    @DisplayName("Ромб: нулевая вторая диагональ")
    public void rhombusTest_zeroDiagonal2() {
        Rhombus rhombus = new Rhombus(4, 0);
        assertEquals(0.0, rhombus.calculateArea(), 0.001);
    }

    @Test
    @DisplayName("Ромб: обе диагонали нулевые")
    public void rhombusTest_bothDiagonalsZero() {
        Rhombus rhombus = new Rhombus(0, 0);
        assertEquals(0.0, rhombus.calculateArea(), 0.001);
    }

    @Test
    @DisplayName("Ромб: отрицательная первая диагональ - исключение")
    public void rhombusTest_negativeDiagonal1() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Rhombus(-5, 10);
        });
    }

    @Test
    @DisplayName("Ромб: отрицательная вторая диагональ - исключение")
    public void rhombusTest_negativeDiagonal2() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Rhombus(10, -5);
        });
    }

    @Test
    @DisplayName("Ромб: установка значений через сеттеры")
    public void rhombusTest_setters() {
        Rhombus rhombus = new Rhombus();
        rhombus.setDiagonal1(8);
        rhombus.setDiagonal2(6);
        assertEquals(24.0, rhombus.calculateArea(), 0.001);
    }

    // ========== ИНТЕГРАЦИОННЫЕ ТЕСТЫ ==========

    @Test
    @DisplayName("Интеграционный тест: все фигуры с одинаковой площадью")
    public void integrationTest_sameArea() {
        Triangle triangle = new Triangle(10, 10);
        Rectangle rectangle = new Rectangle(5, 10);
        Square square = new Square(10);
        Rhombus rhombus = new Rhombus(10, 10);
        
        assertEquals(50.0, triangle.calculateArea(), 0.001);
        assertEquals(50.0, rectangle.calculateArea(), 0.001);
        assertEquals(100.0, square.calculateArea(), 0.001);
        assertEquals(50.0, rhombus.calculateArea(), 0.001);
    }

    @Test
    @DisplayName("Интеграционный тест: множественные вычисления")
    public void integrationTest_multipleCalculations() {
        Triangle triangle = new Triangle(3, 4);
        Rectangle rectangle = new Rectangle(3, 4);
        Square square = new Square(3);
        Rhombus rhombus = new Rhombus(3, 4);
        
        // Вычисляем площадь несколько раз
        double area1 = triangle.calculateArea();
        double area2 = triangle.calculateArea();
        assertEquals(area1, area2, 0.001);
        
        assertEquals(6.0, triangle.calculateArea(), 0.001);
        assertEquals(12.0, rectangle.calculateArea(), 0.001);
        assertEquals(9.0, square.calculateArea(), 0.001);
        assertEquals(6.0, rhombus.calculateArea(), 0.001);
    }

    // ========== ТЕСТЫ ГЕТТЕРОВ ==========

    @Test
    @DisplayName("Rectangle: getLength возвращает установленное значение")
    public void testRectangle_getLength() {
        Rectangle rectangle = new Rectangle(10, 5);
        assertEquals(10.0, rectangle.getLength(), 0.001);
    }

    @Test
    @DisplayName("Rectangle: getWidth возвращает установленное значение")
    public void testRectangle_getWidth() {
        Rectangle rectangle = new Rectangle(10, 5);
        assertEquals(5.0, rectangle.getWidth(), 0.001);
    }

    @Test
    @DisplayName("Rectangle: геттеры после установки через сеттеры")
    public void testRectangle_gettersAfterSetters() {
        Rectangle rectangle = new Rectangle();
        rectangle.setLength(8);
        rectangle.setWidth(6);
        assertEquals(8.0, rectangle.getLength(), 0.001);
        assertEquals(6.0, rectangle.getWidth(), 0.001);
    }

    @Test
    @DisplayName("Rectangle: геттеры возвращают 0 для пустого объекта")
    public void testRectangle_gettersDefaultValues() {
        Rectangle rectangle = new Rectangle();
        assertEquals(0.0, rectangle.getLength(), 0.001);
        assertEquals(0.0, rectangle.getWidth(), 0.001);
    }

    @Test
    @DisplayName("Square: getSide возвращает установленное значение")
    public void testSquare_getSide() {
        Square square = new Square(5);
        assertEquals(5.0, square.getSide(), 0.001);
    }

    @Test
    @DisplayName("Square: getSide после установки через сеттер")
    public void testSquare_getSideAfterSetter() {
        Square square = new Square();
        square.setSide(7);
        assertEquals(7.0, square.getSide(), 0.001);
    }

    @Test
    @DisplayName("Square: getSide возвращает 0 для пустого объекта")
    public void testSquare_getSideDefaultValue() {
        Square square = new Square();
        assertEquals(0.0, square.getSide(), 0.001);
    }

    @Test
    @DisplayName("Triangle: getBase возвращает установленное значение")
    public void testTriangle_getBase() {
        Triangle triangle = new Triangle(10, 5);
        assertEquals(10.0, triangle.getBase(), 0.001);
    }

    @Test
    @DisplayName("Triangle: getHeight возвращает установленное значение")
    public void testTriangle_getHeight() {
        Triangle triangle = new Triangle(10, 5);
        assertEquals(5.0, triangle.getHeight(), 0.001);
    }

    @Test
    @DisplayName("Triangle: геттеры после установки через сеттеры")
    public void testTriangle_gettersAfterSetters() {
        Triangle triangle = new Triangle();
        triangle.setBase(8);
        triangle.setHeight(6);
        assertEquals(8.0, triangle.getBase(), 0.001);
        assertEquals(6.0, triangle.getHeight(), 0.001);
    }

    @Test
    @DisplayName("Triangle: геттеры возвращают 0 для пустого объекта")
    public void testTriangle_gettersDefaultValues() {
        Triangle triangle = new Triangle();
        assertEquals(0.0, triangle.getBase(), 0.001);
        assertEquals(0.0, triangle.getHeight(), 0.001);
    }

    @Test
    @DisplayName("Rhombus: getDiagonal1 возвращает установленное значение")
    public void testRhombus_getDiagonal1() {
        Rhombus rhombus = new Rhombus(4, 5);
        assertEquals(4.0, rhombus.getDiagonal1(), 0.001);
    }

    @Test
    @DisplayName("Rhombus: getDiagonal2 возвращает установленное значение")
    public void testRhombus_getDiagonal2() {
        Rhombus rhombus = new Rhombus(4, 5);
        assertEquals(5.0, rhombus.getDiagonal2(), 0.001);
    }

    @Test
    @DisplayName("Rhombus: геттеры после установки через сеттеры")
    public void testRhombus_gettersAfterSetters() {
        Rhombus rhombus = new Rhombus();
        rhombus.setDiagonal1(8);
        rhombus.setDiagonal2(6);
        assertEquals(8.0, rhombus.getDiagonal1(), 0.001);
        assertEquals(6.0, rhombus.getDiagonal2(), 0.001);
    }

    @Test
    @DisplayName("Rhombus: геттеры возвращают 0 для пустого объекта")
    public void testRhombus_gettersDefaultValues() {
        Rhombus rhombus = new Rhombus();
        assertEquals(0.0, rhombus.getDiagonal1(), 0.001);
        assertEquals(0.0, rhombus.getDiagonal2(), 0.001);
    }
}

