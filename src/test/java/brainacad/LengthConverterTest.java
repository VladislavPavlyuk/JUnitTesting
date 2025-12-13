package brainacad;

import static org.junit.jupiter.api.Assertions.*;

import brainacad.lengths.model.LengthConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты для конвертации единиц длины")
public class LengthConverterTest {
    private LengthConverter converter;

    @BeforeEach
    void setUp() {
        converter = new LengthConverter();
    }

    // ========== КОНВЕРТАЦИЯ ИЗ МЕТРОВ (обратная совместимость) ==========

    @Test
    @DisplayName("Метры -> Миллиметры: 1 метр = 1000 мм")
    public void testToMillimeters() {
        assertEquals(1000, converter.toMillimeters(1), 0.001);
    }

    @Test
    @DisplayName("Метры -> Сантиметры: 1 метр = 100 см")
    public void testToCentimeters() {
        assertEquals(100, converter.toCentimeters(1), 0.001);
    }

    @Test
    @DisplayName("Метры -> Дециметры: 1 метр = 10 дм")
    public void testToDecimeters() {
        assertEquals(10, converter.toDecimeters(1), 0.001);
    }

    @Test
    @DisplayName("Метры -> Метры: 1 метр = 1 м")
    public void testToMeters() {
        assertEquals(1, converter.toMeters(1), 0.001);
    }

    @Test
    @DisplayName("Метры -> Километры: 1 метр = 0.001 км")
    public void testToKilometers() {
        assertEquals(0.001, converter.toKilometers(1), 0.001);
    }

    // ========== УНИВЕРСАЛЬНАЯ КОНВЕРТАЦИЯ: МИЛЛИМЕТРЫ ==========

    @Test
    @DisplayName("Миллиметры -> Сантиметры")
    public void testConvert_MmToCm() {
        assertEquals(10, converter.convert("mm", "cm", 100), 0.001);
    }

    @Test
    @DisplayName("Миллиметры -> Дециметры")
    public void testConvert_MmToDm() {
        assertEquals(1, converter.convert("mm", "dm", 100), 0.001);
    }

    @Test
    @DisplayName("Миллиметры -> Метры")
    public void testConvert_MmToM() {
        assertEquals(1, converter.convert("mm", "m", 1000), 0.001);
    }

    @Test
    @DisplayName("Миллиметры -> Километры")
    public void testConvert_MmToKm() {
        assertEquals(1, converter.convert("mm", "km", 1000000), 0.001);
    }

    @Test
    @DisplayName("Миллиметры -> Миллиметры (та же единица)")
    public void testConvert_MmToMm() {
        assertEquals(1000, converter.convert("mm", "mm", 1000), 0.001);
    }

    // ========== УНИВЕРСАЛЬНАЯ КОНВЕРТАЦИЯ: САНТИМЕТРЫ ==========

    @Test
    @DisplayName("Сантиметры -> Миллиметры")
    public void testConvert_CmToMm() {
        assertEquals(100, converter.convert("cm", "mm", 10), 0.001);
    }

    @Test
    @DisplayName("Сантиметры -> Дециметры")
    public void testConvert_CmToDm() {
        assertEquals(1, converter.convert("cm", "dm", 10), 0.001);
    }

    @Test
    @DisplayName("Сантиметры -> Метры")
    public void testConvert_CmToM() {
        assertEquals(1, converter.convert("cm", "m", 100), 0.001);
    }

    @Test
    @DisplayName("Сантиметры -> Километры")
    public void testConvert_CmToKm() {
        assertEquals(1, converter.convert("cm", "km", 100000), 0.001);
    }

    @Test
    @DisplayName("Сантиметры -> Сантиметры (та же единица)")
    public void testConvert_CmToCm() {
        assertEquals(100, converter.convert("cm", "cm", 100), 0.001);
    }

    // ========== УНИВЕРСАЛЬНАЯ КОНВЕРТАЦИЯ: ДЕЦИМЕТРЫ ==========

    @Test
    @DisplayName("Дециметры -> Миллиметры")
    public void testConvert_DmToMm() {
        assertEquals(100, converter.convert("dm", "mm", 1), 0.001);
    }

    @Test
    @DisplayName("Дециметры -> Сантиметры")
    public void testConvert_DmToCm() {
        assertEquals(10, converter.convert("dm", "cm", 1), 0.001);
    }

    @Test
    @DisplayName("Дециметры -> Метры")
    public void testConvert_DmToM() {
        assertEquals(1, converter.convert("dm", "m", 10), 0.001);
    }

    @Test
    @DisplayName("Дециметры -> Километры")
    public void testConvert_DmToKm() {
        assertEquals(1, converter.convert("dm", "km", 10000), 0.001);
    }

    @Test
    @DisplayName("Дециметры -> Дециметры (та же единица)")
    public void testConvert_DmToDm() {
        assertEquals(10, converter.convert("dm", "dm", 10), 0.001);
    }

    // ========== УНИВЕРСАЛЬНАЯ КОНВЕРТАЦИЯ: МЕТРЫ ==========

    @Test
    @DisplayName("Метры -> Миллиметры")
    public void testConvert_MToMm() {
        assertEquals(1000, converter.convert("m", "mm", 1), 0.001);
    }

    @Test
    @DisplayName("Метры -> Сантиметры")
    public void testConvert_MToCm() {
        assertEquals(100, converter.convert("m", "cm", 1), 0.001);
    }

    @Test
    @DisplayName("Метры -> Дециметры")
    public void testConvert_MToDm() {
        assertEquals(10, converter.convert("m", "dm", 1), 0.001);
    }

    @Test
    @DisplayName("Метры -> Километры")
    public void testConvert_MToKm() {
        assertEquals(1, converter.convert("m", "km", 1000), 0.001);
    }

    @Test
    @DisplayName("Метры -> Метры (та же единица)")
    public void testConvert_MToM() {
        assertEquals(1, converter.convert("m", "m", 1), 0.001);
    }

    // ========== УНИВЕРСАЛЬНАЯ КОНВЕРТАЦИЯ: КИЛОМЕТРЫ ==========

    @Test
    @DisplayName("Километры -> Миллиметры")
    public void testConvert_KmToMm() {
        assertEquals(1000000, converter.convert("km", "mm", 1), 0.001);
    }

    @Test
    @DisplayName("Километры -> Сантиметры")
    public void testConvert_KmToCm() {
        assertEquals(100000, converter.convert("km", "cm", 1), 0.001);
    }

    @Test
    @DisplayName("Километры -> Дециметры")
    public void testConvert_KmToDm() {
        assertEquals(10000, converter.convert("km", "dm", 1), 0.001);
    }

    @Test
    @DisplayName("Километры -> Метры")
    public void testConvert_KmToM() {
        assertEquals(1000, converter.convert("km", "m", 1), 0.001);
    }

    @Test
    @DisplayName("Километры -> Километры (та же единица)")
    public void testConvert_KmToKm() {
        assertEquals(1, converter.convert("km", "km", 1), 0.001);
    }

    // ========== РАЗНЫЕ ФОРМАТЫ НАЗВАНИЙ ЕДИНИЦ ==========

    @Test
    @DisplayName("Полные названия единиц: millimeter -> centimeter")
    public void testConvert_FullNames() {
        assertEquals(10, converter.convert("millimeter", "centimeter", 100), 0.001);
    }

    @Test
    @DisplayName("Множественное число: millimeters -> centimeters")
    public void testConvert_PluralNames() {
        assertEquals(10, converter.convert("millimeters", "centimeters", 100), 0.001);
    }

    @Test
    @DisplayName("Смешанные форматы: mm -> meters")
    public void testConvert_MixedFormats() {
        assertEquals(1, converter.convert("mm", "meters", 1000), 0.001);
    }

    // ========== ГРАНИЧНЫЕ СЛУЧАИ ==========

    @Test
    @DisplayName("Нулевое значение")
    public void testConvert_Zero() {
        assertEquals(0, converter.convert("m", "cm", 0), 0.001);
    }

    @Test
    @DisplayName("Очень маленькое значение")
    public void testConvert_VerySmall() {
        assertEquals(0.001, converter.convert("mm", "m", 1), 0.0001);
    }

    @Test
    @DisplayName("Очень большое значение")
    public void testConvert_VeryLarge() {
        assertEquals(1000, converter.convert("km", "m", 1), 0.001);
    }

    @Test
    @DisplayName("Дробное значение")
    public void testConvert_Decimal() {
        assertEquals(125, converter.convert("m", "cm", 1.25), 0.001);
    }

    // ========== ВАЛИДАЦИЯ ==========

    @Test
    @DisplayName("Отрицательное значение - исключение")
    public void testConvert_NegativeValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.convert("m", "cm", -1);
        });
    }

    @Test
    @DisplayName("Null исходная единица - исключение")
    public void testConvert_NullFromUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.convert(null, "cm", 1);
        });
    }

    @Test
    @DisplayName("Null целевая единица - исключение")
    public void testConvert_NullToUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.convert("m", null, 1);
        });
    }

    @Test
    @DisplayName("Неизвестная исходная единица - исключение")
    public void testConvert_UnknownFromUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.convert("unknown", "cm", 1);
        });
    }

    @Test
    @DisplayName("Неизвестная целевая единица - исключение")
    public void testConvert_UnknownToUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.convert("m", "unknown", 1);
        });
    }

    // ========== ВАЛИДАЦИЯ МЕТОДОВ ОБРАТНОЙ СОВМЕСТИМОСТИ ==========

    @Test
    @DisplayName("toMillimeters: отрицательное значение - исключение")
    public void testToMillimeters_Negative() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.toMillimeters(-1);
        });
    }

    @Test
    @DisplayName("toCentimeters: отрицательное значение - исключение")
    public void testToCentimeters_Negative() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.toCentimeters(-1);
        });
    }

    @Test
    @DisplayName("toDecimeters: отрицательное значение - исключение")
    public void testToDecimeters_Negative() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.toDecimeters(-1);
        });
    }

    @Test
    @DisplayName("toMeters: отрицательное значение - исключение")
    public void testToMeters_Negative() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.toMeters(-1);
        });
    }

    @Test
    @DisplayName("toKilometers: отрицательное значение - исключение")
    public void testToKilometers_Negative() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.toKilometers(-1);
        });
    }

    // ========== ИНТЕГРАЦИОННЫЕ ТЕСТЫ ==========

    @Test
    @DisplayName("Интеграционный тест: конвертация по кругу mm->cm->dm->m->km->mm")
    public void testIntegration_RoundTrip() {
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
    public void testIntegration_Reverse() {
        double value = 100;
        double converted = converter.convert("cm", "m", value);
        double reversed = converter.convert("m", "cm", converted);
        assertEquals(value, reversed, 0.001);
    }
}

