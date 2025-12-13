package brainacad;

import static org.junit.jupiter.api.Assertions.*;

import brainacad.weights.models.WeightConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты для конвертации единиц веса")
public class WeightConverterTest {
    private WeightConverter converter;

    @BeforeEach
    void setUp() {
        converter = new WeightConverter();
    }

    // ========== КОНВЕРТАЦИЯ ИЗ КИЛОГРАММОВ (обратная совместимость) ==========

    @Test
    @DisplayName("Килограммы -> Миллиграммы: 1 кг = 1 000 000 мг")
    public void testToMilligrams() {
        assertEquals(1_000_000, converter.toMilligrams(1), 0.001);
    }

    @Test
    @DisplayName("Килограммы -> Граммы: 1 кг = 1000 г")
    public void testToGrams() {
        assertEquals(1_000, converter.toGrams(1), 0.001);
    }

    @Test
    @DisplayName("Килограммы -> Килограммы: 1 кг = 1 кг")
    public void testToKilograms() {
        assertEquals(1, converter.toKilograms(1), 0.001);
    }

    @Test
    @DisplayName("Килограммы -> Центнеры: 1 кг = 0.01 ц")
    public void testToCentners() {
        assertEquals(0.01, converter.toCentners(1), 0.001);
    }

    @Test
    @DisplayName("Килограммы -> Тонны: 1 кг = 0.001 т")
    public void testToTons() {
        assertEquals(0.001, converter.toTons(1), 0.001);
    }

    // ========== УНИВЕРСАЛЬНАЯ КОНВЕРТАЦИЯ: МИЛЛИГРАММЫ ==========

    @Test
    @DisplayName("Миллиграммы -> Граммы")
    public void testConvert_MgToG() {
        assertEquals(1, converter.convert("mg", "g", 1000), 0.001);
    }

    @Test
    @DisplayName("Миллиграммы -> Килограммы")
    public void testConvert_MgToKg() {
        assertEquals(1, converter.convert("mg", "kg", 1_000_000), 0.001);
    }

    @Test
    @DisplayName("Миллиграммы -> Центнеры")
    public void testConvert_MgToCwt() {
        assertEquals(1, converter.convert("mg", "cwt", 100_000_000), 0.001);
    }

    @Test
    @DisplayName("Миллиграммы -> Тонны")
    public void testConvert_MgToT() {
        assertEquals(1, converter.convert("mg", "t", 1_000_000_000), 0.001);
    }

    @Test
    @DisplayName("Миллиграммы -> Миллиграммы (та же единица)")
    public void testConvert_MgToMg() {
        assertEquals(1000, converter.convert("mg", "mg", 1000), 0.001);
    }

    // ========== УНИВЕРСАЛЬНАЯ КОНВЕРТАЦИЯ: ГРАММЫ ==========

    @Test
    @DisplayName("Граммы -> Миллиграммы")
    public void testConvert_GToMg() {
        assertEquals(1000, converter.convert("g", "mg", 1), 0.001);
    }

    @Test
    @DisplayName("Граммы -> Килограммы")
    public void testConvert_GToKg() {
        assertEquals(1, converter.convert("g", "kg", 1000), 0.001);
    }

    @Test
    @DisplayName("Граммы -> Центнеры")
    public void testConvert_GToCwt() {
        assertEquals(1, converter.convert("g", "cwt", 100_000), 0.001);
    }

    @Test
    @DisplayName("Граммы -> Тонны")
    public void testConvert_GToT() {
        assertEquals(1, converter.convert("g", "t", 1_000_000), 0.001);
    }

    @Test
    @DisplayName("Граммы -> Граммы (та же единица)")
    public void testConvert_GToG() {
        assertEquals(100, converter.convert("g", "g", 100), 0.001);
    }

    // ========== УНИВЕРСАЛЬНАЯ КОНВЕРТАЦИЯ: КИЛОГРАММЫ ==========

    @Test
    @DisplayName("Килограммы -> Миллиграммы")
    public void testConvert_KgToMg() {
        assertEquals(1_000_000, converter.convert("kg", "mg", 1), 0.001);
    }

    @Test
    @DisplayName("Килограммы -> Граммы")
    public void testConvert_KgToG() {
        assertEquals(1000, converter.convert("kg", "g", 1), 0.001);
    }

    @Test
    @DisplayName("Килограммы -> Центнеры")
    public void testConvert_KgToCwt() {
        assertEquals(1, converter.convert("kg", "cwt", 100), 0.001);
    }

    @Test
    @DisplayName("Килограммы -> Тонны")
    public void testConvert_KgToT() {
        assertEquals(1, converter.convert("kg", "t", 1000), 0.001);
    }

    @Test
    @DisplayName("Килограммы -> Килограммы (та же единица)")
    public void testConvert_KgToKg() {
        assertEquals(1, converter.convert("kg", "kg", 1), 0.001);
    }

    // ========== УНИВЕРСАЛЬНАЯ КОНВЕРТАЦИЯ: ЦЕНТНЕРЫ ==========

    @Test
    @DisplayName("Центнеры -> Миллиграммы")
    public void testConvert_CwtToMg() {
        assertEquals(100_000_000, converter.convert("cwt", "mg", 1), 0.001);
    }

    @Test
    @DisplayName("Центнеры -> Граммы")
    public void testConvert_CwtToG() {
        assertEquals(100_000, converter.convert("cwt", "g", 1), 0.001);
    }

    @Test
    @DisplayName("Центнеры -> Килограммы")
    public void testConvert_CwtToKg() {
        assertEquals(100, converter.convert("cwt", "kg", 1), 0.001);
    }

    @Test
    @DisplayName("Центнеры -> Тонны")
    public void testConvert_CwtToT() {
        assertEquals(10, converter.convert("cwt", "t", 1), 0.001);
    }

    @Test
    @DisplayName("Центнеры -> Центнеры (та же единица)")
    public void testConvert_CwtToCwt() {
        assertEquals(1, converter.convert("cwt", "cwt", 1), 0.001);
    }

    // ========== УНИВЕРСАЛЬНАЯ КОНВЕРТАЦИЯ: ТОННЫ ==========

    @Test
    @DisplayName("Тонны -> Миллиграммы")
    public void testConvert_TToMg() {
        assertEquals(1_000_000_000, converter.convert("t", "mg", 1), 0.001);
    }

    @Test
    @DisplayName("Тонны -> Граммы")
    public void testConvert_TToG() {
        assertEquals(1_000_000, converter.convert("t", "g", 1), 0.001);
    }

    @Test
    @DisplayName("Тонны -> Килограммы")
    public void testConvert_TToKg() {
        assertEquals(1000, converter.convert("t", "kg", 1), 0.001);
    }

    @Test
    @DisplayName("Тонны -> Центнеры")
    public void testConvert_TToCwt() {
        assertEquals(10, converter.convert("t", "cwt", 1), 0.001);
    }

    @Test
    @DisplayName("Тонны -> Тонны (та же единица)")
    public void testConvert_TToT() {
        assertEquals(1, converter.convert("t", "t", 1), 0.001);
    }

    // ========== РАЗНЫЕ ФОРМАТЫ НАЗВАНИЙ ЕДИНИЦ ==========

    @Test
    @DisplayName("Полные названия единиц: milligram -> gram")
    public void testConvert_FullNames() {
        assertEquals(1, converter.convert("milligram", "gram", 1000), 0.001);
    }

    @Test
    @DisplayName("Множественное число: milligrams -> grams")
    public void testConvert_PluralNames() {
        assertEquals(1, converter.convert("milligrams", "grams", 1000), 0.001);
    }

    @Test
    @DisplayName("Смешанные форматы: mg -> kilograms")
    public void testConvert_MixedFormats() {
        assertEquals(1, converter.convert("mg", "kilograms", 1_000_000), 0.001);
    }

    @Test
    @DisplayName("Тонны: разные варианты написания (ton, tonne)")
    public void testConvert_TonVariants() {
        assertEquals(1000, converter.convert("ton", "kg", 1), 0.001);
        assertEquals(1000, converter.convert("tonne", "kg", 1), 0.001);
        assertEquals(1000, converter.convert("tons", "kg", 1), 0.001);
        assertEquals(1000, converter.convert("tonnes", "kg", 1), 0.001);
    }

    // ========== ГРАНИЧНЫЕ СЛУЧАИ ==========

    @Test
    @DisplayName("Нулевое значение")
    public void testConvert_Zero() {
        assertEquals(0, converter.convert("kg", "g", 0), 0.001);
    }

    @Test
    @DisplayName("Очень маленькое значение")
    public void testConvert_VerySmall() {
        assertEquals(0.001, converter.convert("mg", "g", 1), 0.0001);
    }

    @Test
    @DisplayName("Очень большое значение")
    public void testConvert_VeryLarge() {
        assertEquals(1000, converter.convert("t", "kg", 1), 0.001);
    }

    @Test
    @DisplayName("Дробное значение")
    public void testConvert_Decimal() {
        assertEquals(1250, converter.convert("kg", "g", 1.25), 0.001);
    }

    // ========== ВАЛИДАЦИЯ ==========

    @Test
    @DisplayName("Отрицательное значение - исключение")
    public void testConvert_NegativeValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.convert("kg", "g", -1);
        });
    }

    @Test
    @DisplayName("Null исходная единица - исключение")
    public void testConvert_NullFromUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.convert(null, "g", 1);
        });
    }

    @Test
    @DisplayName("Null целевая единица - исключение")
    public void testConvert_NullToUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.convert("kg", null, 1);
        });
    }

    @Test
    @DisplayName("Неизвестная исходная единица - исключение")
    public void testConvert_UnknownFromUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.convert("unknown", "g", 1);
        });
    }

    @Test
    @DisplayName("Неизвестная целевая единица - исключение")
    public void testConvert_UnknownToUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.convert("kg", "unknown", 1);
        });
    }

    // ========== ВАЛИДАЦИЯ МЕТОДОВ ОБРАТНОЙ СОВМЕСТИМОСТИ ==========

    @Test
    @DisplayName("toMilligrams: отрицательное значение - исключение")
    public void testToMilligrams_Negative() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.toMilligrams(-1);
        });
    }

    @Test
    @DisplayName("toGrams: отрицательное значение - исключение")
    public void testToGrams_Negative() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.toGrams(-1);
        });
    }

    @Test
    @DisplayName("toKilograms: отрицательное значение - исключение")
    public void testToKilograms_Negative() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.toKilograms(-1);
        });
    }

    @Test
    @DisplayName("toCentners: отрицательное значение - исключение")
    public void testToCentners_Negative() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.toCentners(-1);
        });
    }

    @Test
    @DisplayName("toTons: отрицательное значение - исключение")
    public void testToTons_Negative() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.toTons(-1);
        });
    }

    // ========== ИНТЕГРАЦИОННЫЕ ТЕСТЫ ==========

    @Test
    @DisplayName("Интеграционный тест: конвертация по кругу mg->g->kg->cwt->t->mg")
    public void testIntegration_RoundTrip() {
        double value = 1_000_000;
        double g = converter.convert("mg", "g", value);
        double kg = converter.convert("g", "kg", g);
        double cwt = converter.convert("kg", "cwt", kg);
        double t = converter.convert("cwt", "t", cwt);
        double backToMg = converter.convert("t", "mg", t);
        assertEquals(value, backToMg, 0.1);
    }

    @Test
    @DisplayName("Интеграционный тест: обратная конвертация")
    public void testIntegration_Reverse() {
        double value = 100;
        double converted = converter.convert("kg", "g", value);
        double reversed = converter.convert("g", "kg", converted);
        assertEquals(value, reversed, 0.001);
    }

    // ========== ПРАКТИЧЕСКИЕ ПРИМЕРЫ ==========

    @Test
    @DisplayName("Практический пример: конвертация веса человека")
    public void testPracticalExample_PersonWeight() {
        // 70 кг в граммы
        assertEquals(70_000, converter.convert("kg", "g", 70), 0.001);
        // 70 кг в миллиграммы
        assertEquals(70_000_000, converter.convert("kg", "mg", 70), 0.001);
    }

    @Test
    @DisplayName("Практический пример: конвертация груза")
    public void testPracticalExample_Cargo() {
        // 5 тонн в килограммы
        assertEquals(5000, converter.convert("t", "kg", 5), 0.001);
        // 5 тонн в центнеры
        assertEquals(50, converter.convert("t", "cwt", 5), 0.001);
    }
}

