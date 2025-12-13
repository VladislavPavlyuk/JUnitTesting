package brainacad;

import static org.junit.jupiter.api.Assertions.*;

import brainacad.weights.models.WeightConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@DisplayName("Тесты для конвертации единиц веса")
@ExtendWith(TestResultLogger.class)
public class WeightConverterTest {
    private WeightConverter converter;

    @BeforeEach
    void setUp() {
        converter = new WeightConverter();
    }

    // ========== КОНВЕРТАЦИЯ ИЗ КИЛОГРАММОВ (обратная совместимость) ==========

    @Test
    @DisplayName("Килограммы -> Миллиграммы: 1 кг = 1 000 000 мг")
    public void toMilligrams_WhenOneKilogram_ReturnsOneMillionMilligrams() {
        double actualResult = converter.toMilligrams(1);
        double expectedResult = 1_000_000;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Килограммы -> Граммы: 1 кг = 1000 г")
    public void toGrams_WhenOneKilogram_ReturnsThousandGrams() {
        double actualResult = converter.toGrams(1);
        double expectedResult = 1_000;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Килограммы -> Килограммы: 1 кг = 1 кг")
    public void toKilograms_WhenOneKilogram_ReturnsOneKilogram() {
        double actualResult = converter.toKilograms(1);
        double expectedResult = 1;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Килограммы -> Центнеры: 1 кг = 0.01 ц")
    public void toCentners_WhenOneKilogram_ReturnsZeroPointZeroOneCentners() {
        double actualResult = converter.toCentners(1);
        double expectedResult = 0.01;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Килограммы -> Тонны: 1 кг = 0.001 т")
    public void toTons_WhenOneKilogram_ReturnsZeroPointZeroZeroOneTons() {
        double actualResult = converter.toTons(1);
        double expectedResult = 0.001;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    // ========== УНИВЕРСАЛЬНАЯ КОНВЕРТАЦИЯ: МИЛЛИГРАММЫ ==========

    @Test
    @DisplayName("Миллиграммы -> Граммы")
    public void convert_WhenMilligramsToGrams_ReturnsCorrectValue() {
        double actualResult = converter.convert("mg", "g", 1000);
        double expectedResult = 1;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Миллиграммы -> Килограммы")
    public void convert_WhenMilligramsToKilograms_ReturnsCorrectValue() {
        double actualResult = converter.convert("mg", "kg", 1_000_000);
        double expectedResult = 1;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Миллиграммы -> Центнеры")
    public void convert_WhenMilligramsToCentners_ReturnsCorrectValue() {
        double actualResult = converter.convert("mg", "cwt", 100_000_000);
        double expectedResult = 1;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Миллиграммы -> Тонны")
    public void convert_WhenMilligramsToTons_ReturnsCorrectValue() {
        double actualResult = converter.convert("mg", "t", 1_000_000_000);
        double expectedResult = 1;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Миллиграммы -> Миллиграммы (та же единица)")
    public void convert_WhenMilligramsToMilligrams_ReturnsSameValue() {
        double actualResult = converter.convert("mg", "mg", 1000);
        double expectedResult = 1000;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    // ========== УНИВЕРСАЛЬНАЯ КОНВЕРТАЦИЯ: ГРАММЫ ==========

    @Test
    @DisplayName("Граммы -> Миллиграммы")
    public void convert_WhenGramsToMilligrams_ReturnsCorrectValue() {
        double actualResult = converter.convert("g", "mg", 1);
        double expectedResult = 1000;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Граммы -> Килограммы")
    public void convert_WhenGramsToKilograms_ReturnsCorrectValue() {
        double actualResult = converter.convert("g", "kg", 1000);
        double expectedResult = 1;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Граммы -> Центнеры")
    public void convert_WhenGramsToCentners_ReturnsCorrectValue() {
        double actualResult = converter.convert("g", "cwt", 100_000);
        double expectedResult = 1;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Граммы -> Тонны")
    public void convert_WhenGramsToTons_ReturnsCorrectValue() {
        double actualResult = converter.convert("g", "t", 1_000_000);
        double expectedResult = 1;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Граммы -> Граммы (та же единица)")
    public void convert_WhenGramsToGrams_ReturnsSameValue() {
        double actualResult = converter.convert("g", "g", 100);        double expectedResult = 100;        assertEquals(expectedResult, actualResult, 0.001);
    }

    // ========== УНИВЕРСАЛЬНАЯ КОНВЕРТАЦИЯ: КИЛОГРАММЫ ==========

    @Test
    @DisplayName("Килограммы -> Миллиграммы")
    public void convert_WhenKilogramsToMilligrams_ReturnsCorrectValue() {
        double actualResult = converter.convert("kg", "mg", 1);        double expectedResult = 1_000_000;        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Килограммы -> Граммы")
    public void convert_WhenKilogramsToGrams_ReturnsCorrectValue() {
        double actualResult = converter.convert("kg", "g", 1);        double expectedResult = 1000;        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Килограммы -> Центнеры")
    public void convert_WhenKilogramsToCentners_ReturnsCorrectValue() {
        double actualResult = converter.convert("kg", "cwt", 100);        double expectedResult = 1;        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Килограммы -> Тонны")
    public void convert_WhenKilogramsToTons_ReturnsCorrectValue() {
        double actualResult = converter.convert("kg", "t", 1000);        double expectedResult = 1;        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Килограммы -> Килограммы (та же единица)")
    public void convert_WhenKilogramsToKilograms_ReturnsSameValue() {
        double actualResult = converter.convert("kg", "kg", 1);        double expectedResult = 1;        assertEquals(expectedResult, actualResult, 0.001);
    }

    // ========== УНИВЕРСАЛЬНАЯ КОНВЕРТАЦИЯ: ЦЕНТНЕРЫ ==========

    @Test
    @DisplayName("Центнеры -> Миллиграммы")
    public void convert_WhenCentnersToMilligrams_ReturnsCorrectValue() {
        double actualResult = converter.convert("cwt", "mg", 1);        double expectedResult = 100_000_000;        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Центнеры -> Граммы")
    public void convert_WhenCentnersToGrams_ReturnsCorrectValue() {
        double actualResult = converter.convert("cwt", "g", 1);        double expectedResult = 100_000;        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Центнеры -> Килограммы")
    public void convert_WhenCentnersToKilograms_ReturnsCorrectValue() {
        double actualResult = converter.convert("cwt", "kg", 1);        double expectedResult = 100;        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Центнеры -> Тонны")
    public void convert_WhenCentnersToTons_ReturnsCorrectValue() {
        double actualResult = converter.convert("cwt", "t", 1);        double expectedResult = 0.1;        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Центнеры -> Центнеры (та же единица)")
    public void convert_WhenCentnersToCentners_ReturnsSameValue() {
        double actualResult = converter.convert("cwt", "cwt", 1);        double expectedResult = 1;        assertEquals(expectedResult, actualResult, 0.001);
    }

    // ========== УНИВЕРСАЛЬНАЯ КОНВЕРТАЦИЯ: ТОННЫ ==========

    @Test
    @DisplayName("Тонны -> Миллиграммы")
    public void convert_WhenTonsToMilligrams_ReturnsCorrectValue() {
        double actualResult = converter.convert("t", "mg", 1);        double expectedResult = 1_000_000_000;        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Тонны -> Граммы")
    public void convert_WhenTonsToGrams_ReturnsCorrectValue() {
        double actualResult = converter.convert("t", "g", 1);        double expectedResult = 1_000_000;        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Тонны -> Килограммы")
    public void convert_WhenTonsToKilograms_ReturnsCorrectValue() {
        double actualResult = converter.convert("t", "kg", 1);        double expectedResult = 1000;        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Тонны -> Центнеры")
    public void convert_WhenTonsToCentners_ReturnsCorrectValue() {
        double actualResult = converter.convert("t", "cwt", 1);        double expectedResult = 10;        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Тонны -> Тонны (та же единица)")
    public void convert_WhenTonsToTons_ReturnsSameValue() {
        double actualResult = converter.convert("t", "t", 1);        double expectedResult = 1;        assertEquals(expectedResult, actualResult, 0.001);
    }

    // ========== РАЗНЫЕ ФОРМАТЫ НАЗВАНИЙ ЕДИНИЦ ==========

    @Test
    @DisplayName("Полные названия единиц: milligram -> gram")
    public void convert_WhenFullNames_ReturnsCorrectValue() {
        double actualResult = converter.convert("milligram", "gram", 1000);        double expectedResult = 1;        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Множественное число: milligrams -> grams")
    public void convert_WhenPluralNames_ReturnsCorrectValue() {
        double actualResult = converter.convert("milligrams", "grams", 1000);        double expectedResult = 1;        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Смешанные форматы: mg -> kilograms")
    public void convert_WhenMixedFormats_ReturnsCorrectValue() {
        double actualResult = converter.convert("mg", "kilograms", 1_000_000);        double expectedResult = 1;        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Тонны: разные варианты написания (ton, tonne)")
    public void convert_WhenTonVariants_ReturnsCorrectValue() {
        double actualResultTon = converter.convert("ton", "kg", 1);
        double expectedResultTon = 1000;
        assertEquals(expectedResultTon, actualResultTon, 0.001);
        
        double actualResultTonne = converter.convert("tonne", "kg", 1);
        double expectedResultTonne = 1000;
        assertEquals(expectedResultTonne, actualResultTonne, 0.001);
        
        double actualResultTons = converter.convert("tons", "kg", 1);
        double expectedResultTons = 1000;
        assertEquals(expectedResultTons, actualResultTons, 0.001);
        
        double actualResultTonnes = converter.convert("tonnes", "kg", 1);
        double expectedResultTonnes = 1000;
        assertEquals(expectedResultTonnes, actualResultTonnes, 0.001);
    }

    // ========== ГРАНИЧНЫЕ СЛУЧАИ ==========

    @Test
    @DisplayName("Нулевое значение")
    public void convert_WhenZeroValue_ReturnsZero() {
        double actualResult = converter.convert("kg", "g", 0);        double expectedResult = 0;        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Очень маленькое значение")
    public void convert_WhenVerySmallValue_ReturnsCorrectValue() {
        double actualResult = converter.convert("mg", "g", 1);        double expectedResult = 0.001;        assertEquals(expectedResult, actualResult, 0.0001);
    }

    @Test
    @DisplayName("Очень большое значение")
    public void convert_WhenVeryLargeValue_ReturnsCorrectValue() {
        double actualResult = converter.convert("t", "kg", 1);        double expectedResult = 1000;        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Дробное значение")
    public void convert_WhenDecimalValue_ReturnsCorrectValue() {
        double actualResult = converter.convert("kg", "g", 1.25);        double expectedResult = 1250;        assertEquals(expectedResult, actualResult, 0.001);
    }

    // ========== ВАЛИДАЦИЯ ==========

    @Test
    @DisplayName("Отрицательное значение - исключение")
    public void convert_WhenNegativeValue_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.convert("kg", "g", -1);
        });
    }

    @Test
    @DisplayName("Null исходная единица - исключение")
    public void convert_WhenNullFromUnit_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.convert(null, "g", 1);
        });
    }

    @Test
    @DisplayName("Null целевая единица - исключение")
    public void convert_WhenNullToUnit_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.convert("kg", null, 1);
        });
    }

    @Test
    @DisplayName("Неизвестная исходная единица - исключение")
    public void convert_WhenUnknownFromUnit_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.convert("unknown", "g", 1);
        });
    }

    @Test
    @DisplayName("Неизвестная целевая единица - исключение")
    public void convert_WhenUnknownToUnit_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.convert("kg", "unknown", 1);
        });
    }

    // ========== ВАЛИДАЦИЯ МЕТОДОВ ОБРАТНОЙ СОВМЕСТИМОСТИ ==========

    @Test
    @DisplayName("toMilligrams: отрицательное значение - исключение")
    public void toMilligrams_WhenNegativeValue_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.toMilligrams(-1);
        });
    }

    @Test
    @DisplayName("toGrams: отрицательное значение - исключение")
    public void toGrams_WhenNegativeValue_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.toGrams(-1);
        });
    }

    @Test
    @DisplayName("toKilograms: отрицательное значение - исключение")
    public void toKilograms_WhenNegativeValue_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.toKilograms(-1);
        });
    }

    @Test
    @DisplayName("toCentners: отрицательное значение - исключение")
    public void toCentners_WhenNegativeValue_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.toCentners(-1);
        });
    }

    @Test
    @DisplayName("toTons: отрицательное значение - исключение")
    public void toTons_WhenNegativeValue_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.toTons(-1);
        });
    }

    // ========== ИНТЕГРАЦИОННЫЕ ТЕСТЫ ==========

    @Test
    @DisplayName("Интеграционный тест: конвертация по кругу mg->g->kg->cwt->t->mg")
    public void convert_WhenRoundTripConversion_ReturnsOriginalValue() {
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
    public void convert_WhenReverseConversion_ReturnsCorrectValue() {
        double value = 100;
        double converted = converter.convert("kg", "g", value);
        double reversed = converter.convert("g", "kg", converted);
        assertEquals(value, reversed, 0.001);
    }

    // ========== ПРАКТИЧЕСКИЕ ПРИМЕРЫ ==========

    @Test
    @DisplayName("Практический пример: конвертация веса человека")
    public void convert_WhenPersonWeight_ReturnsCorrectValue() {
        // 70 кг в граммы
        double actualResultGrams = converter.convert("kg", "g", 70);
        double expectedResultGrams = 70_000;
        assertEquals(expectedResultGrams, actualResultGrams, 0.001);
        // 70 кг в миллиграммы
        double actualResultMilligrams = converter.convert("kg", "mg", 70);
        double expectedResultMilligrams = 70_000_000;
        assertEquals(expectedResultMilligrams, actualResultMilligrams, 0.001);
    }

    @Test
    @DisplayName("Практический пример: конвертация груза")
    public void convert_WhenCargoWeight_ReturnsCorrectValue() {
        // 5 тонн в килограммы
        double actualResultKilograms = converter.convert("t", "kg", 5);
        double expectedResultKilograms = 5000;
        assertEquals(expectedResultKilograms, actualResultKilograms, 0.001);
        // 5 тонн в центнеры
        double actualResultCentners = converter.convert("t", "cwt", 5);
        double expectedResultCentners = 50;
        assertEquals(expectedResultCentners, actualResultCentners, 0.001);
    }
}

