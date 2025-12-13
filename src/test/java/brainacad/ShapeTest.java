package brainacad;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import brainacad.shapes.models.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тесты для вычисления площади геометрических фигур")
@ExtendWith(TestResultLogger.class)
public class ShapeTest {

    // ========== ТРЕУГОЛЬНИК ==========
    
    @Test
    @DisplayName("Треугольник: нормальный случай")
    public void calculateArea_WhenValidTriangle_ReturnsCorrectArea() {
        Triangle triangle = new Triangle(10, 5);
        double actualResult = triangle.calculateArea();
        double expectedResult = 25.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Треугольник: площадь с дробными значениями")
    public void calculateArea_WhenTriangleWithDecimalValues_ReturnsCorrectArea() {
        Triangle triangle = new Triangle(7.5, 4.2);
        double actualResult = triangle.calculateArea();
        double expectedResult = 15.75;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Треугольник: большие значения")
    public void calculateArea_WhenTriangleWithLargeValues_ReturnsCorrectArea() {
        Triangle triangle = new Triangle(100, 50);
        double actualResult = triangle.calculateArea();
        double expectedResult = 2500.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Треугольник: маленькие значения")
    public void calculateArea_WhenTriangleWithSmallValues_ReturnsCorrectArea() {
        Triangle triangle = new Triangle(0.5, 0.3);
        double actualResult = triangle.calculateArea();
        double expectedResult = 0.075;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Треугольник: нулевая высота")
    public void calculateArea_WhenTriangleWithZeroHeight_ReturnsZero() {
        Triangle triangle = new Triangle(10, 0);
        double actualResult = triangle.calculateArea();
        double expectedResult = 0.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Треугольник: нулевое основание")
    public void calculateArea_WhenTriangleWithZeroBase_ReturnsZero() {
        Triangle triangle = new Triangle(0, 5);
        double actualResult = triangle.calculateArea();
        double expectedResult = 0.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Треугольник: оба значения нулевые")
    public void calculateArea_WhenTriangleWithBothZeroValues_ReturnsZero() {
        Triangle triangle = new Triangle(0, 0);
        double actualResult = triangle.calculateArea();
        double expectedResult = 0.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Треугольник: отрицательное основание - исключение")
    public void Triangle_WhenNegativeBase_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Triangle(-5, 10);
        });
    }

    @Test
    @DisplayName("Треугольник: отрицательная высота - исключение")
    public void Triangle_WhenNegativeHeight_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Triangle(10, -5);
        });
    }

    @Test
    @DisplayName("Треугольник: установка значений через сеттеры")
    public void calculateArea_WhenTriangleCreatedWithSetters_ReturnsCorrectArea() {
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
    public void calculateArea_WhenValidRectangle_ReturnsCorrectArea() {
        Rectangle rectangle = new Rectangle(10, 5);
        double actualResult = rectangle.calculateArea();
        double expectedResult = 50.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Прямоугольник: площадь с дробными значениями")
    public void calculateArea_WhenRectangleWithDecimalValues_ReturnsCorrectArea() {
        Rectangle rectangle = new Rectangle(7.5, 4.2);
        double actualResult = rectangle.calculateArea();
        double expectedResult = 31.5;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Прямоугольник: квадрат (частный случай)")
    public void calculateArea_WhenSquareRectangle_ReturnsCorrectArea() {
        Rectangle rectangle = new Rectangle(5, 5);
        double actualResult = rectangle.calculateArea();
        double expectedResult = 25.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Прямоугольник: большие значения")
    public void calculateArea_WhenRectangleWithLargeValues_ReturnsCorrectArea() {
        Rectangle rectangle = new Rectangle(100, 50);
        double actualResult = rectangle.calculateArea();
        double expectedResult = 5000.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Прямоугольник: маленькие значения")
    public void calculateArea_WhenRectangleWithSmallValues_ReturnsCorrectArea() {
        Rectangle rectangle = new Rectangle(0.5, 0.3);
        double actualResult = rectangle.calculateArea();
        double expectedResult = 0.15;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Прямоугольник: нулевая длина")
    public void calculateArea_WhenRectangleWithZeroLength_ReturnsZero() {
        Rectangle rectangle = new Rectangle(0, 5);
        double actualResult = rectangle.calculateArea();
        double expectedResult = 0.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Прямоугольник: нулевая ширина")
    public void calculateArea_WhenRectangleWithZeroWidth_ReturnsZero() {
        Rectangle rectangle = new Rectangle(10, 0);
        double actualResult = rectangle.calculateArea();
        double expectedResult = 0.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Прямоугольник: отрицательная длина - исключение")
    public void Rectangle_WhenNegativeLength_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Rectangle(-5, 10);
        });
    }

    @Test
    @DisplayName("Прямоугольник: отрицательная ширина - исключение")
    public void Rectangle_WhenNegativeWidth_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Rectangle(10, -5);
        });
    }

    @Test
    @DisplayName("Прямоугольник: установка значений через сеттеры")
    public void calculateArea_WhenRectangleCreatedWithSetters_ReturnsCorrectArea() {
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
    public void calculateArea_WhenValidSquare_ReturnsCorrectArea() {
        Square square = new Square(6);
        double actualResult = square.calculateArea();
        double expectedResult = 36.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Квадрат: площадь с дробным значением")
    public void calculateArea_WhenSquareWithDecimalValue_ReturnsCorrectArea() {
        Square square = new Square(5.5);
        double actualResult = square.calculateArea();
        double expectedResult = 30.25;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Квадрат: большие значения")
    public void calculateArea_WhenSquareWithLargeValue_ReturnsCorrectArea() {
        Square square = new Square(100);
        double actualResult = square.calculateArea();
        double expectedResult = 10000.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Квадрат: маленькие значения")
    public void calculateArea_WhenSquareWithSmallValue_ReturnsCorrectArea() {
        Square square = new Square(0.5);
        double actualResult = square.calculateArea();
        double expectedResult = 0.25;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Квадрат: нулевая сторона")
    public void calculateArea_WhenSquareWithZeroSide_ReturnsZero() {
        Square square = new Square(0);
        double actualResult = square.calculateArea();
        double expectedResult = 0.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Квадрат: отрицательная сторона - исключение")
    public void Square_WhenNegativeSide_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Square(-5);
        });
    }

    @Test
    @DisplayName("Квадрат: установка значения через сеттер")
    public void calculateArea_WhenSquareCreatedWithSetter_ReturnsCorrectArea() {
        Square square = new Square();
        square.setSide(7);
        double actualResult = square.calculateArea();
        double expectedResult = 49.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Квадрат: единичная сторона")
    public void calculateArea_WhenSquareWithUnitSide_ReturnsOne() {
        Square square = new Square(1);
        double actualResult = square.calculateArea();
        double expectedResult = 1.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    // ========== РОМБ ==========

    @Test
    @DisplayName("Ромб: нормальный случай")
    public void calculateArea_WhenValidRhombus_ReturnsCorrectArea() {
        Rhombus rhombus = new Rhombus(4, 5);
        double actualResult = rhombus.calculateArea();
        double expectedResult = 10.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Ромб: площадь с дробными значениями")
    public void calculateArea_WhenRhombusWithDecimalValues_ReturnsCorrectArea() {
        Rhombus rhombus = new Rhombus(6.4, 5.2);
        double actualResult = rhombus.calculateArea();
        double expectedResult = 16.64;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Ромб: равные диагонали")
    public void calculateArea_WhenRhombusWithEqualDiagonals_ReturnsCorrectArea() {
        Rhombus rhombus = new Rhombus(5, 5);
        double actualResult = rhombus.calculateArea();
        double expectedResult = 12.5;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Ромб: большие значения")
    public void calculateArea_WhenRhombusWithLargeValues_ReturnsCorrectArea() {
        Rhombus rhombus = new Rhombus(100, 50);
        double actualResult = rhombus.calculateArea();
        double expectedResult = 2500.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Ромб: маленькие значения")
    public void calculateArea_WhenRhombusWithSmallValues_ReturnsCorrectArea() {
        Rhombus rhombus = new Rhombus(0.5, 0.3);
        double actualResult = rhombus.calculateArea();
        double expectedResult = 0.075;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Ромб: нулевая первая диагональ")
    public void calculateArea_WhenRhombusWithZeroDiagonal1_ReturnsZero() {
        Rhombus rhombus = new Rhombus(0, 5);
        double actualResult = rhombus.calculateArea();
        double expectedResult = 0.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Ромб: нулевая вторая диагональ")
    public void calculateArea_WhenRhombusWithZeroDiagonal2_ReturnsZero() {
        Rhombus rhombus = new Rhombus(4, 0);
        double actualResult = rhombus.calculateArea();
        double expectedResult = 0.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Ромб: обе диагонали нулевые")
    public void calculateArea_WhenRhombusWithBothDiagonalsZero_ReturnsZero() {
        Rhombus rhombus = new Rhombus(0, 0);
        double actualResult = rhombus.calculateArea();
        double expectedResult = 0.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Ромб: отрицательная первая диагональ - исключение")
    public void Rhombus_WhenNegativeDiagonal1_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Rhombus(-5, 10);
        });
    }

    @Test
    @DisplayName("Ромб: отрицательная вторая диагональ - исключение")
    public void Rhombus_WhenNegativeDiagonal2_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Rhombus(10, -5);
        });
    }

    @Test
    @DisplayName("Ромб: установка значений через сеттеры")
    public void calculateArea_WhenRhombusCreatedWithSetters_ReturnsCorrectArea() {
        Rhombus rhombus = new Rhombus();
        rhombus.setDiagonal1(8);
        rhombus.setDiagonal2(6);
        double actualResult = rhombus.calculateArea();
        double expectedResult = 24.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    // ========== ИНТЕГРАЦИОННЫЕ ТЕСТЫ ==========

    @Test
    @DisplayName("Интеграционный тест: треугольник с одинаковой площадью")
    public void calculateArea_WhenTriangleWithSameDimensions_ReturnsCorrectArea() {
        Triangle triangle = new Triangle(10, 10);
        double triangleActualResult = triangle.calculateArea();
        double triangleExpectedResult = 50.0;
        assertEquals(triangleExpectedResult, triangleActualResult, 0.001);
    }

    @Test
    @DisplayName("Интеграционный тест: прямоугольник с одинаковой площадью")
    public void calculateArea_WhenRectangleWithSameDimensions_ReturnsCorrectArea() {
        Rectangle rectangle = new Rectangle(5, 10);
        double rectangleActualResult = rectangle.calculateArea();
        double rectangleExpectedResult = 50.0;
        assertEquals(rectangleExpectedResult, rectangleActualResult, 0.001);
    }

    @Test
    @DisplayName("Интеграционный тест: квадрат с одинаковой площадью")
    public void calculateArea_WhenSquareWithSameDimensions_ReturnsCorrectArea() {
        Square square = new Square(10);
        double squareActualResult = square.calculateArea();
        double squareExpectedResult = 100.0;
        assertEquals(squareExpectedResult, squareActualResult, 0.001);
    }

    @Test
    @DisplayName("Интеграционный тест: ромб с одинаковой площадью")
    public void calculateArea_WhenRhombusWithSameDimensions_ReturnsCorrectArea() {
        Rhombus rhombus = new Rhombus(10, 10);
        double rhombusActualResult = rhombus.calculateArea();
        double rhombusExpectedResult = 50.0;
        assertEquals(rhombusExpectedResult, rhombusActualResult, 0.001);
    }

    @Test
    @DisplayName("Интеграционный тест: множественные вычисления треугольника")
    public void calculateArea_WhenTriangleCalledMultipleTimes_ReturnsConsistentResults() {
        Triangle triangle = new Triangle(3, 4);
        double area1 = triangle.calculateArea();
        double area2 = triangle.calculateArea();
        assertEquals(area1, area2, 0.001);
    }

    @Test
    @DisplayName("Интеграционный тест: множественные вычисления прямоугольника")
    public void calculateArea_WhenRectangleCalledMultipleTimes_ReturnsConsistentResults() {
        Rectangle rectangle = new Rectangle(3, 4);
        double rectangleActualResult = rectangle.calculateArea();
        double rectangleExpectedResult = 12.0;
        assertEquals(rectangleExpectedResult, rectangleActualResult, 0.001);
    }

    @Test
    @DisplayName("Интеграционный тест: множественные вычисления квадрата")
    public void calculateArea_WhenSquareCalledMultipleTimes_ReturnsConsistentResults() {
        Square square = new Square(3);
        double squareActualResult = square.calculateArea();
        double squareExpectedResult = 9.0;
        assertEquals(squareExpectedResult, squareActualResult, 0.001);
    }

    @Test
    @DisplayName("Интеграционный тест: множественные вычисления ромба")
    public void calculateArea_WhenRhombusCalledMultipleTimes_ReturnsConsistentResults() {
        Rhombus rhombus = new Rhombus(3, 4);
        double rhombusActualResult = rhombus.calculateArea();
        double rhombusExpectedResult = 6.0;
        assertEquals(rhombusExpectedResult, rhombusActualResult, 0.001);
    }

    // ========== ТЕСТЫ ГЕТТЕРОВ ==========

    @Test
    @DisplayName("Rectangle: getLength возвращает установленное значение")
    public void getLength_WhenRectangleCreatedWithLength_ReturnsLength() {
        Rectangle rectangle = new Rectangle(10, 5);
        double actualResult = rectangle.getLength();
        double expectedResult = 10.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Rectangle: getWidth возвращает установленное значение")
    public void getWidth_WhenRectangleCreatedWithWidth_ReturnsWidth() {
        Rectangle rectangle = new Rectangle(10, 5);
        double actualResult = rectangle.getWidth();
        double expectedResult = 5.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Rectangle: getLength после установки через сеттер")
    public void getLength_WhenSetViaSetter_ReturnsSetValue() {
        Rectangle rectangle = new Rectangle();
        rectangle.setLength(8);
        double lengthActualResult = rectangle.getLength();
        double lengthExpectedResult = 8.0;
        assertEquals(lengthExpectedResult, lengthActualResult, 0.001);
    }

    @Test
    @DisplayName("Rectangle: getWidth после установки через сеттер")
    public void getWidth_WhenSetViaSetter_ReturnsSetValue() {
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(6);
        double widthActualResult = rectangle.getWidth();
        double widthExpectedResult = 6.0;
        assertEquals(widthExpectedResult, widthActualResult, 0.001);
    }

    @Test
    @DisplayName("Rectangle: getLength возвращает 0 для пустого объекта")
    public void getLength_WhenEmptyRectangle_ReturnsZero() {
        Rectangle rectangle = new Rectangle();
        double lengthActualResult = rectangle.getLength();
        double lengthExpectedResult = 0.0;
        assertEquals(lengthExpectedResult, lengthActualResult, 0.001);
    }

    @Test
    @DisplayName("Rectangle: getWidth возвращает 0 для пустого объекта")
    public void getWidth_WhenEmptyRectangle_ReturnsZero() {
        Rectangle rectangle = new Rectangle();
        double widthActualResult = rectangle.getWidth();
        double widthExpectedResult = 0.0;
        assertEquals(widthExpectedResult, widthActualResult, 0.001);
    }

    @Test
    @DisplayName("Square: getSide возвращает установленное значение")
    public void getSide_WhenSquareCreatedWithSide_ReturnsSide() {
        Square square = new Square(5);
        double actualResult = square.getSide();
        double expectedResult = 5.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Square: getSide после установки через сеттер")
    public void getSide_WhenSetViaSetter_ReturnsSetValue() {
        Square square = new Square();
        square.setSide(7);
        double actualResult = square.getSide();
        double expectedResult = 7.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Square: getSide возвращает 0 для пустого объекта")
    public void getSide_WhenEmptySquare_ReturnsZero() {
        Square square = new Square();
        double actualResult = square.getSide();
        double expectedResult = 0.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Triangle: getBase возвращает установленное значение")
    public void getBase_WhenTriangleCreatedWithBase_ReturnsBase() {
        Triangle triangle = new Triangle(10, 5);
        double actualResult = triangle.getBase();
        double expectedResult = 10.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Triangle: getHeight возвращает установленное значение")
    public void getHeight_WhenTriangleCreatedWithHeight_ReturnsHeight() {
        Triangle triangle = new Triangle(10, 5);
        double actualResult = triangle.getHeight();
        double expectedResult = 5.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Triangle: getBase после установки через сеттер")
    public void getBase_WhenSetViaSetter_ReturnsSetValue() {
        Triangle triangle = new Triangle();
        triangle.setBase(8);
        double baseActualResult = triangle.getBase();
        double baseExpectedResult = 8.0;
        assertEquals(baseExpectedResult, baseActualResult, 0.001);
    }

    @Test
    @DisplayName("Triangle: getHeight после установки через сеттер")
    public void getHeight_WhenSetViaSetter_ReturnsSetValue() {
        Triangle triangle = new Triangle();
        triangle.setHeight(6);
        double heightActualResult = triangle.getHeight();
        double heightExpectedResult = 6.0;
        assertEquals(heightExpectedResult, heightActualResult, 0.001);
    }

    @Test
    @DisplayName("Triangle: getBase возвращает 0 для пустого объекта")
    public void getBase_WhenEmptyTriangle_ReturnsZero() {
        Triangle triangle = new Triangle();
        double baseActualResult = triangle.getBase();
        double baseExpectedResult = 0.0;
        assertEquals(baseExpectedResult, baseActualResult, 0.001);
    }

    @Test
    @DisplayName("Triangle: getHeight возвращает 0 для пустого объекта")
    public void getHeight_WhenEmptyTriangle_ReturnsZero() {
        Triangle triangle = new Triangle();
        double heightActualResult = triangle.getHeight();
        double heightExpectedResult = 0.0;
        assertEquals(heightExpectedResult, heightActualResult, 0.001);
    }

    @Test
    @DisplayName("Rhombus: getDiagonal1 возвращает установленное значение")
    public void getDiagonal1_WhenRhombusCreatedWithDiagonal1_ReturnsDiagonal1() {
        Rhombus rhombus = new Rhombus(4, 5);
        double actualResult = rhombus.getDiagonal1();
        double expectedResult = 4.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Rhombus: getDiagonal2 возвращает установленное значение")
    public void getDiagonal2_WhenRhombusCreatedWithDiagonal2_ReturnsDiagonal2() {
        Rhombus rhombus = new Rhombus(4, 5);
        double actualResult = rhombus.getDiagonal2();
        double expectedResult = 5.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Rhombus: getDiagonal1 после установки через сеттер")
    public void getDiagonal1_WhenSetViaSetter_ReturnsSetValue() {
        Rhombus rhombus = new Rhombus();
        rhombus.setDiagonal1(8);
        double diagonal1ActualResult = rhombus.getDiagonal1();
        double diagonal1ExpectedResult = 8.0;
        assertEquals(diagonal1ExpectedResult, diagonal1ActualResult, 0.001);
    }

    @Test
    @DisplayName("Rhombus: getDiagonal2 после установки через сеттер")
    public void getDiagonal2_WhenSetViaSetter_ReturnsSetValue() {
        Rhombus rhombus = new Rhombus();
        rhombus.setDiagonal2(6);
        double diagonal2ActualResult = rhombus.getDiagonal2();
        double diagonal2ExpectedResult = 6.0;
        assertEquals(diagonal2ExpectedResult, diagonal2ActualResult, 0.001);
    }

    @Test
    @DisplayName("Rhombus: getDiagonal1 возвращает 0 для пустого объекта")
    public void getDiagonal1_WhenEmptyRhombus_ReturnsZero() {
        Rhombus rhombus = new Rhombus();
        double diagonal1ActualResult = rhombus.getDiagonal1();
        double diagonal1ExpectedResult = 0.0;
        assertEquals(diagonal1ExpectedResult, diagonal1ActualResult, 0.001);
    }

    @Test
    @DisplayName("Rhombus: getDiagonal2 возвращает 0 для пустого объекта")
    public void getDiagonal2_WhenEmptyRhombus_ReturnsZero() {
        Rhombus rhombus = new Rhombus();
        double diagonal2ActualResult = rhombus.getDiagonal2();
        double diagonal2ExpectedResult = 0.0;
        assertEquals(diagonal2ExpectedResult, diagonal2ActualResult, 0.001);
    }
}

