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
        double actualResult = triangle.calculateArea();
        double expectedResult = 25.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Треугольник: площадь с дробными значениями")
    public void triangleTest_decimalValues() {
        Triangle triangle = new Triangle(7.5, 4.2);
        double actualResult = triangle.calculateArea();
        double expectedResult = 15.75;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Треугольник: большие значения")
    public void triangleTest_largeValues() {
        Triangle triangle = new Triangle(100, 50);
        double actualResult = triangle.calculateArea();
        double expectedResult = 2500.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Треугольник: маленькие значения")
    public void triangleTest_smallValues() {
        Triangle triangle = new Triangle(0.5, 0.3);
        double actualResult = triangle.calculateArea();
        double expectedResult = 0.075;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Треугольник: нулевая высота")
    public void triangleTest_zeroHeight() {
        Triangle triangle = new Triangle(10, 0);
        double actualResult = triangle.calculateArea();
        double expectedResult = 0.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Треугольник: нулевое основание")
    public void triangleTest_zeroBase() {
        Triangle triangle = new Triangle(0, 5);
        double actualResult = triangle.calculateArea();
        double expectedResult = 0.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Треугольник: оба значения нулевые")
    public void triangleTest_bothZero() {
        Triangle triangle = new Triangle(0, 0);
        double actualResult = triangle.calculateArea();
        double expectedResult = 0.0;
        assertEquals(expectedResult, actualResult, 0.001);
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
        double actualResult = triangle.calculateArea();
        double expectedResult = 24.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    // ========== ПРЯМОУГОЛЬНИК ==========

    @Test
    @DisplayName("Прямоугольник: нормальный случай")
    public void rectangleTest_normalCase() {
        Rectangle rectangle = new Rectangle(10, 5);
        double actualResult = rectangle.calculateArea();
        double expectedResult = 50.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Прямоугольник: площадь с дробными значениями")
    public void rectangleTest_decimalValues() {
        Rectangle rectangle = new Rectangle(7.5, 4.2);
        double actualResult = rectangle.calculateArea();
        double expectedResult = 31.5;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Прямоугольник: квадрат (частный случай)")
    public void rectangleTest_squareCase() {
        Rectangle rectangle = new Rectangle(5, 5);
        double actualResult = rectangle.calculateArea();
        double expectedResult = 25.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Прямоугольник: большие значения")
    public void rectangleTest_largeValues() {
        Rectangle rectangle = new Rectangle(100, 50);
        double actualResult = rectangle.calculateArea();
        double expectedResult = 5000.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Прямоугольник: маленькие значения")
    public void rectangleTest_smallValues() {
        Rectangle rectangle = new Rectangle(0.5, 0.3);
        double actualResult = rectangle.calculateArea();
        double expectedResult = 0.15;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Прямоугольник: нулевая длина")
    public void rectangleTest_zeroLength() {
        Rectangle rectangle = new Rectangle(0, 5);
        double actualResult = rectangle.calculateArea();
        double expectedResult = 0.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Прямоугольник: нулевая ширина")
    public void rectangleTest_zeroWidth() {
        Rectangle rectangle = new Rectangle(10, 0);
        double actualResult = rectangle.calculateArea();
        double expectedResult = 0.0;
        assertEquals(expectedResult, actualResult, 0.001);
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
        double actualResult = rectangle.calculateArea();
        double expectedResult = 48.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    // ========== КВАДРАТ ==========

    @Test
    @DisplayName("Квадрат: нормальный случай")
    public void squareTest_normalCase() {
        Square square = new Square(6);
        double actualResult = square.calculateArea();
        double expectedResult = 36.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Квадрат: площадь с дробным значением")
    public void squareTest_decimalValue() {
        Square square = new Square(5.5);
        double actualResult = square.calculateArea();
        double expectedResult = 30.25;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Квадрат: большие значения")
    public void squareTest_largeValue() {
        Square square = new Square(100);
        double actualResult = square.calculateArea();
        double expectedResult = 10000.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Квадрат: маленькие значения")
    public void squareTest_smallValue() {
        Square square = new Square(0.5);
        double actualResult = square.calculateArea();
        double expectedResult = 0.25;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Квадрат: нулевая сторона")
    public void squareTest_zeroSide() {
        Square square = new Square(0);
        double actualResult = square.calculateArea();
        double expectedResult = 0.0;
        assertEquals(expectedResult, actualResult, 0.001);
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
        double actualResult = square.calculateArea();
        double expectedResult = 49.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Квадрат: единичная сторона")
    public void squareTest_unitSide() {
        Square square = new Square(1);
        double actualResult = square.calculateArea();
        double expectedResult = 1.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    // ========== РОМБ ==========

    @Test
    @DisplayName("Ромб: нормальный случай")
    public void rhombusTest_normalCase() {
        Rhombus rhombus = new Rhombus(4, 5);
        double actualResult = rhombus.calculateArea();
        double expectedResult = 10.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Ромб: площадь с дробными значениями")
    public void rhombusTest_decimalValues() {
        Rhombus rhombus = new Rhombus(6.4, 5.2);
        double actualResult = rhombus.calculateArea();
        double expectedResult = 16.64;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Ромб: равные диагонали")
    public void rhombusTest_equalDiagonals() {
        Rhombus rhombus = new Rhombus(5, 5);
        double actualResult = rhombus.calculateArea();
        double expectedResult = 12.5;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Ромб: большие значения")
    public void rhombusTest_largeValues() {
        Rhombus rhombus = new Rhombus(100, 50);
        double actualResult = rhombus.calculateArea();
        double expectedResult = 2500.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Ромб: маленькие значения")
    public void rhombusTest_smallValues() {
        Rhombus rhombus = new Rhombus(0.5, 0.3);
        double actualResult = rhombus.calculateArea();
        double expectedResult = 0.075;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Ромб: нулевая первая диагональ")
    public void rhombusTest_zeroDiagonal1() {
        Rhombus rhombus = new Rhombus(0, 5);
        double actualResult = rhombus.calculateArea();
        double expectedResult = 0.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Ромб: нулевая вторая диагональ")
    public void rhombusTest_zeroDiagonal2() {
        Rhombus rhombus = new Rhombus(4, 0);
        double actualResult = rhombus.calculateArea();
        double expectedResult = 0.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Ромб: обе диагонали нулевые")
    public void rhombusTest_bothDiagonalsZero() {
        Rhombus rhombus = new Rhombus(0, 0);
        double actualResult = rhombus.calculateArea();
        double expectedResult = 0.0;
        assertEquals(expectedResult, actualResult, 0.001);
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
        double actualResult = rhombus.calculateArea();
        double expectedResult = 24.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    // ========== ИНТЕГРАЦИОННЫЕ ТЕСТЫ ==========

    @Test
    @DisplayName("Интеграционный тест: все фигуры с одинаковой площадью")
    public void integrationTest_sameArea() {
        Triangle triangle = new Triangle(10, 10);
        Rectangle rectangle = new Rectangle(5, 10);
        Square square = new Square(10);
        Rhombus rhombus = new Rhombus(10, 10);
        
        double triangleActualResult = triangle.calculateArea();
        double triangleExpectedResult = 50.0;
        assertEquals(triangleExpectedResult, triangleActualResult, 0.001);
        
        double rectangleActualResult = rectangle.calculateArea();
        double rectangleExpectedResult = 50.0;
        assertEquals(rectangleExpectedResult, rectangleActualResult, 0.001);
        
        double squareActualResult = square.calculateArea();
        double squareExpectedResult = 100.0;
        assertEquals(squareExpectedResult, squareActualResult, 0.001);
        
        double rhombusActualResult = rhombus.calculateArea();
        double rhombusExpectedResult = 50.0;
        assertEquals(rhombusExpectedResult, rhombusActualResult, 0.001);
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
        
        double triangleActualResult = triangle.calculateArea();
        double triangleExpectedResult = 6.0;
        assertEquals(triangleExpectedResult, triangleActualResult, 0.001);
        
        double rectangleActualResult = rectangle.calculateArea();
        double rectangleExpectedResult = 12.0;
        assertEquals(rectangleExpectedResult, rectangleActualResult, 0.001);
        
        double squareActualResult = square.calculateArea();
        double squareExpectedResult = 9.0;
        assertEquals(squareExpectedResult, squareActualResult, 0.001);
        
        double rhombusActualResult = rhombus.calculateArea();
        double rhombusExpectedResult = 6.0;
        assertEquals(rhombusExpectedResult, rhombusActualResult, 0.001);
    }

    // ========== ТЕСТЫ ГЕТТЕРОВ ==========

    @Test
    @DisplayName("Rectangle: getLength возвращает установленное значение")
    public void testRectangle_getLength() {
        Rectangle rectangle = new Rectangle(10, 5);
        double actualResult = rectangle.getLength();
        double expectedResult = 10.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Rectangle: getWidth возвращает установленное значение")
    public void testRectangle_getWidth() {
        Rectangle rectangle = new Rectangle(10, 5);
        double actualResult = rectangle.getWidth();
        double expectedResult = 5.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Rectangle: геттеры после установки через сеттеры")
    public void testRectangle_gettersAfterSetters() {
        Rectangle rectangle = new Rectangle();
        rectangle.setLength(8);
        rectangle.setWidth(6);
        double lengthActualResult = rectangle.getLength();
        double lengthExpectedResult = 8.0;
        assertEquals(lengthExpectedResult, lengthActualResult, 0.001);
        
        double widthActualResult = rectangle.getWidth();
        double widthExpectedResult = 6.0;
        assertEquals(widthExpectedResult, widthActualResult, 0.001);
    }

    @Test
    @DisplayName("Rectangle: геттеры возвращают 0 для пустого объекта")
    public void testRectangle_gettersDefaultValues() {
        Rectangle rectangle = new Rectangle();
        double lengthActualResult = rectangle.getLength();
        double lengthExpectedResult = 0.0;
        assertEquals(lengthExpectedResult, lengthActualResult, 0.001);
        
        double widthActualResult = rectangle.getWidth();
        double widthExpectedResult = 0.0;
        assertEquals(widthExpectedResult, widthActualResult, 0.001);
    }

    @Test
    @DisplayName("Square: getSide возвращает установленное значение")
    public void testSquare_getSide() {
        Square square = new Square(5);
        double actualResult = square.getSide();
        double expectedResult = 5.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Square: getSide после установки через сеттер")
    public void testSquare_getSideAfterSetter() {
        Square square = new Square();
        square.setSide(7);
        double actualResult = square.getSide();
        double expectedResult = 7.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Square: getSide возвращает 0 для пустого объекта")
    public void testSquare_getSideDefaultValue() {
        Square square = new Square();
        double actualResult = square.getSide();
        double expectedResult = 0.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Triangle: getBase возвращает установленное значение")
    public void testTriangle_getBase() {
        Triangle triangle = new Triangle(10, 5);
        double actualResult = triangle.getBase();
        double expectedResult = 10.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Triangle: getHeight возвращает установленное значение")
    public void testTriangle_getHeight() {
        Triangle triangle = new Triangle(10, 5);
        double actualResult = triangle.getHeight();
        double expectedResult = 5.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Triangle: геттеры после установки через сеттеры")
    public void testTriangle_gettersAfterSetters() {
        Triangle triangle = new Triangle();
        triangle.setBase(8);
        triangle.setHeight(6);
        double baseActualResult = triangle.getBase();
        double baseExpectedResult = 8.0;
        assertEquals(baseExpectedResult, baseActualResult, 0.001);
        
        double heightActualResult = triangle.getHeight();
        double heightExpectedResult = 6.0;
        assertEquals(heightExpectedResult, heightActualResult, 0.001);
    }

    @Test
    @DisplayName("Triangle: геттеры возвращают 0 для пустого объекта")
    public void testTriangle_gettersDefaultValues() {
        Triangle triangle = new Triangle();
        double baseActualResult = triangle.getBase();
        double baseExpectedResult = 0.0;
        assertEquals(baseExpectedResult, baseActualResult, 0.001);
        
        double heightActualResult = triangle.getHeight();
        double heightExpectedResult = 0.0;
        assertEquals(heightExpectedResult, heightActualResult, 0.001);
    }

    @Test
    @DisplayName("Rhombus: getDiagonal1 возвращает установленное значение")
    public void testRhombus_getDiagonal1() {
        Rhombus rhombus = new Rhombus(4, 5);
        double actualResult = rhombus.getDiagonal1();
        double expectedResult = 4.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Rhombus: getDiagonal2 возвращает установленное значение")
    public void testRhombus_getDiagonal2() {
        Rhombus rhombus = new Rhombus(4, 5);
        double actualResult = rhombus.getDiagonal2();
        double expectedResult = 5.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Rhombus: геттеры после установки через сеттеры")
    public void testRhombus_gettersAfterSetters() {
        Rhombus rhombus = new Rhombus();
        rhombus.setDiagonal1(8);
        rhombus.setDiagonal2(6);
        double diagonal1ActualResult = rhombus.getDiagonal1();
        double diagonal1ExpectedResult = 8.0;
        assertEquals(diagonal1ExpectedResult, diagonal1ActualResult, 0.001);
        
        double diagonal2ActualResult = rhombus.getDiagonal2();
        double diagonal2ExpectedResult = 6.0;
        assertEquals(diagonal2ExpectedResult, diagonal2ActualResult, 0.001);
    }

    @Test
    @DisplayName("Rhombus: геттеры возвращают 0 для пустого объекта")
    public void testRhombus_gettersDefaultValues() {
        Rhombus rhombus = new Rhombus();
        double diagonal1ActualResult = rhombus.getDiagonal1();
        double diagonal1ExpectedResult = 0.0;
        assertEquals(diagonal1ExpectedResult, diagonal1ActualResult, 0.001);
        
        double diagonal2ActualResult = rhombus.getDiagonal2();
        double diagonal2ExpectedResult = 0.0;
        assertEquals(diagonal2ExpectedResult, diagonal2ActualResult, 0.001);
    }
}

