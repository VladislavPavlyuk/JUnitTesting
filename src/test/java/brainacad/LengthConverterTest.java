package brainacad;

import static org.junit.jupiter.api.Assertions.*;

import brainacad.lengths.model.LengthConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@DisplayName("Тесты для конвертации единиц длины")
@ExtendWith(TestResultLogger.class)
public class LengthConverterTest {
    private LengthConverter converter;

    @BeforeEach
    void setUp() {
        converter = new LengthConverter();
    }

    // ========== КОНВЕРТАЦИЯ ИЗ МЕТРОВ (обратная совместимость) ==========

    @Test
    @DisplayName("Метры -> Миллиметры: 1 метр = 1000 мм")
    public void toMillimeters_WhenOneMeter_ReturnsThousandMillimeters() {
        double actualResult = converter.toMillimeters(1);
        double expectedResult = 1000;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Метры -> Сантиметры: 1 метр = 100 см")
    public void toCentimeters_WhenOneMeter_ReturnsHundredCentimeters() {
        double actualResult = converter.toCentimeters(1);
        double expectedResult = 100;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Метры -> Дециметры: 1 метр = 10 дм")
    public void toDecimeters_WhenOneMeter_ReturnsTenDecimeters() {
        double actualResult = converter.toDecimeters(1);
        double expectedResult = 10;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Метры -> Метры: 1 метр = 1 м")
    public void toMeters_WhenOneMeter_ReturnsOneMeter() {
        double actualResult = converter.toMeters(1);
        double expectedResult = 1;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Метры -> Километры: 1 метр = 0.001 км")
    public void toKilometers_WhenOneMeter_ReturnsZeroPointZeroZeroOneKilometers() {
        double actualResult = converter.toKilometers(1);
        double expectedResult = 0.001;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    // ========== УНИВЕРСАЛЬНАЯ КОНВЕРТАЦИЯ: МИЛЛИМЕТРЫ ==========

    @Test
    @DisplayName("Миллиметры -> Сантиметры")
    public void convert_WhenMillimetersToCentimeters_ReturnsCorrectValue() {
        double actualResult = converter.convert("mm", "cm", 100);
        double expectedResult = 10;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Миллиметры -> Дециметры")
    public void convert_WhenMillimetersToDecimeters_ReturnsCorrectValue() {
        double actualResult = converter.convert("mm", "dm", 100);
        double expectedResult = 1;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Миллиметры -> Метры")
    public void convert_WhenMillimetersToMeters_ReturnsCorrectValue() {
        double actualResult = converter.convert("mm", "m", 1000);
        double expectedResult = 1;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Миллиметры -> Километры")
    public void convert_WhenMillimetersToKilometers_ReturnsCorrectValue() {
        double actualResult = converter.convert("mm", "km", 1000000);
        double expectedResult = 1;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Миллиметры -> Миллиметры (та же единица)")
    public void convert_WhenSameUnit_ReturnsSameValue() {
        double actualResult = converter.convert("mm", "mm", 1000);
        double expectedResult = 1000;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    // ========== УНИВЕРСАЛЬНАЯ КОНВЕРТАЦИЯ: САНТИМЕТРЫ ==========

    @Test
    @DisplayName("Сантиметры -> Миллиметры")
    public void convert_WhenCentimetersToMillimeters_ReturnsCorrectValue() {
        double actualResult = converter.convert("cm", "mm", 10);
        double expectedResult = 100;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Сантиметры -> Дециметры")
    public void convert_WhenCentimetersToDecimeters_ReturnsCorrectValue() {
        double actualResult = converter.convert("cm", "dm", 10);
        double expectedResult = 1;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Сантиметры -> Метры")
    public void convert_WhenCentimetersToMeters_ReturnsCorrectValue() {
        double actualResult = converter.convert("cm", "m", 100);
        double expectedResult = 1;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Сантиметры -> Километры")
    public void convert_WhenCentimetersToKilometers_ReturnsCorrectValue() {
        double actualResult = converter.convert("cm", "km", 100000);
        double expectedResult = 1;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Сантиметры -> Сантиметры (та же единица)")
    public void convert_WhenCentimetersToCentimeters_ReturnsSameValue() {
        double actualResult = converter.convert("cm", "cm", 100);
        double expectedResult = 100;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    // ========== УНИВЕРСАЛЬНАЯ КОНВЕРТАЦИЯ: ДЕЦИМЕТРЫ ==========

    @Test
    @DisplayName("Дециметры -> Миллиметры")
    public void convert_WhenDecimetersToMillimeters_ReturnsCorrectValue() {
        double actualResult = converter.convert("dm", "mm", 1);        double expectedResult = 100;        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Дециметры -> Сантиметры")
    public void convert_WhenDecimetersToCentimeters_ReturnsCorrectValue() {
        double actualResult = converter.convert("dm", "cm", 1);        double expectedResult = 10;        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Дециметры -> Метры")
    public void convert_WhenDecimetersToMeters_ReturnsCorrectValue() {
        double actualResult = converter.convert("dm", "m", 10);        double expectedResult = 1;        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Дециметры -> Километры")
    public void convert_WhenDecimetersToKilometers_ReturnsCorrectValue() {
        double actualResult = converter.convert("dm", "km", 10000);        double expectedResult = 1;        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Дециметры -> Дециметры (та же единица)")
    public void convert_WhenDecimetersToDecimeters_ReturnsSameValue() {
        double actualResult = converter.convert("dm", "dm", 10);        double expectedResult = 10;        assertEquals(expectedResult, actualResult, 0.001);
    }

    // ========== УНИВЕРСАЛЬНАЯ КОНВЕРТАЦИЯ: МЕТРЫ ==========

    @Test
    @DisplayName("Метры -> Миллиметры")
    public void convert_WhenMetersToMillimeters_ReturnsCorrectValue() {
        double actualResult = converter.convert("m", "mm", 1);        double expectedResult = 1000;        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Метры -> Сантиметры")
    public void convert_WhenMetersToCentimeters_ReturnsCorrectValue() {
        double actualResult = converter.convert("m", "cm", 1);        double expectedResult = 100;        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Метры -> Дециметры")
    public void convert_WhenMetersToDecimeters_ReturnsCorrectValue() {
        double actualResult = converter.convert("m", "dm", 1);        double expectedResult = 10;        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Метры -> Километры")
    public void convert_WhenMetersToKilometers_ReturnsCorrectValue() {
        double actualResult = converter.convert("m", "km", 1000);        double expectedResult = 1;        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Метры -> Метры (та же единица)")
    public void convert_WhenMetersToMeters_ReturnsSameValue() {
        double actualResult = converter.convert("m", "m", 1);        double expectedResult = 1;        assertEquals(expectedResult, actualResult, 0.001);
    }

    // ========== УНИВЕРСАЛЬНАЯ КОНВЕРТАЦИЯ: КИЛОМЕТРЫ ==========

    @Test
    @DisplayName("Километры -> Миллиметры")
    public void convert_WhenKilometersToMillimeters_ReturnsCorrectValue() {
        double actualResult = converter.convert("km", "mm", 1);        double expectedResult = 1000000;        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Километры -> Сантиметры")
    public void convert_WhenKilometersToCentimeters_ReturnsCorrectValue() {
        double actualResult = converter.convert("km", "cm", 1);        double expectedResult = 100000;        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Километры -> Дециметры")
    public void convert_WhenKilometersToDecimeters_ReturnsCorrectValue() {
        double actualResult = converter.convert("km", "dm", 1);        double expectedResult = 10000;        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Километры -> Метры")
    public void convert_WhenKilometersToMeters_ReturnsCorrectValue() {
        double actualResult = converter.convert("km", "m", 1);        double expectedResult = 1000;        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Километры -> Километры (та же единица)")
    public void convert_WhenKilometersToKilometers_ReturnsSameValue() {
        double actualResult = converter.convert("km", "km", 1);        double expectedResult = 1;        assertEquals(expectedResult, actualResult, 0.001);
    }

    // ========== РАЗНЫЕ ФОРМАТЫ НАЗВАНИЙ ЕДИНИЦ ==========

    @Test
    @DisplayName("Полные названия единиц: millimeter -> centimeter")
    public void convert_WhenFullNames_ReturnsCorrectValue() {
        double actualResult = converter.convert("millimeter", "centimeter", 100);        double expectedResult = 10;        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Множественное число: millimeters -> centimeters")
    public void convert_WhenPluralNames_ReturnsCorrectValue() {
        double actualResult = converter.convert("millimeters", "centimeters", 100);        double expectedResult = 10;        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Смешанные форматы: mm -> meters")
    public void convert_WhenMixedFormats_ReturnsCorrectValue() {
        double actualResult = converter.convert("mm", "meters", 1000);        double expectedResult = 1;        assertEquals(expectedResult, actualResult, 0.001);
    }

    // ========== ГРАНИЧНЫЕ СЛУЧАИ ==========

    @Test
    @DisplayName("Нулевое значение")
    public void convert_WhenZeroValue_ReturnsZero() {
        double actualResult = converter.convert("m", "cm", 0);        double expectedResult = 0;        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Очень маленькое значение")
    public void convert_WhenVerySmallValue_ReturnsCorrectValue() {
        double actualResult = converter.convert("mm", "m", 1);        double expectedResult = 0.001;        assertEquals(expectedResult, actualResult, 0.0001);
    }

    @Test
    @DisplayName("Очень большое значение")
    public void convert_WhenVeryLargeValue_ReturnsCorrectValue() {
        double actualResult = converter.convert("km", "m", 1);        double expectedResult = 1000;        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Дробное значение")
    public void convert_WhenDecimalValue_ReturnsCorrectValue() {
        double actualResult = converter.convert("m", "cm", 1.25);        double expectedResult = 125;        assertEquals(expectedResult, actualResult, 0.001);
    }

    // ========== ВАЛИДАЦИЯ ==========

    @Test
    @DisplayName("Отрицательное значение - исключение")
    public void convert_WhenNegativeValue_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.convert("m", "cm", -1);
        });
    }

    @Test
    @DisplayName("Null исходная единица - исключение")
    public void convert_WhenNullFromUnit_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.convert(null, "cm", 1);
        });
    }

    @Test
    @DisplayName("Null целевая единица - исключение")
    public void convert_WhenNullToUnit_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.convert("m", null, 1);
        });
    }

    @Test
    @DisplayName("Неизвестная исходная единица - исключение")
    public void convert_WhenUnknownFromUnit_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.convert("unknown", "cm", 1);
        });
    }

    @Test
    @DisplayName("Неизвестная целевая единица - исключение")
    public void convert_WhenUnknownToUnit_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.convert("m", "unknown", 1);
        });
    }

    // ========== ВАЛИДАЦИЯ МЕТОДОВ ОБРАТНОЙ СОВМЕСТИМОСТИ ==========

    @Test
    @DisplayName("toMillimeters: отрицательное значение - исключение")
    public void toMillimeters_WhenNegativeValue_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.toMillimeters(-1);
        });
    }

    @Test
    @DisplayName("toCentimeters: отрицательное значение - исключение")
    public void toCentimeters_WhenNegativeValue_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.toCentimeters(-1);
        });
    }

    @Test
    @DisplayName("toDecimeters: отрицательное значение - исключение")
    public void toDecimeters_WhenNegativeValue_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.toDecimeters(-1);
        });
    }

    @Test
    @DisplayName("toMeters: отрицательное значение - исключение")
    public void toMeters_WhenNegativeValue_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.toMeters(-1);
        });
    }

    @Test
    @DisplayName("toKilometers: отрицательное значение - исключение")
    public void toKilometers_WhenNegativeValue_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.toKilometers(-1);
        });
    }

    // ========== ИНТЕГРАЦИОННЫЕ ТЕСТЫ ==========

    @Test
    @DisplayName("Интеграционный тест: конвертация по кругу mm->cm->dm->m->km->mm")
    public void convert_WhenRoundTripConversion_ReturnsOriginalValue() {
        double value = 1000;
        double cm = converter.convert("mm", "cm", value);
        double dm = converter.convert("cm", "dm", cm);
        double m = converter.convert("dm", "m", dm);
        double km = converter.convert("m", "km", m);
        double backToMm = converter.convert("km", "mm", km);
        assertEquals(value, backToMm, 0.1);
    }

    @Test
    @DisplayName("Интеграционный тест: обратная конвертация")
    public void convert_WhenReverseConversion_ReturnsCorrectValue() {
        double value = 100;
        double converted = converter.convert("cm", "m", value);
        double reversed = converter.convert("m", "cm", converted);
        assertEquals(value, reversed, 0.001);
    }
}

