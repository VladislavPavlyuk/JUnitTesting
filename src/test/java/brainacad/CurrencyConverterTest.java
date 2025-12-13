package brainacad;

import brainacad.currencies.models.CurrencyConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тесты для конвертации валют")
public class CurrencyConverterTest {
    private CurrencyConverter converter;

    @BeforeEach
    void setUp() {
        converter = new CurrencyConverter();
    }

    // ========== USD (Доллар) ==========

    @Test
    @DisplayName("USD -> EUR: конвертация 100 долларов в евро")
    public void testUsdToEur() {
        double result = converter.convert("USD", "EUR", 100);
        assertEquals(85.0, result, 0.001);
    }

    @Test
    @DisplayName("USD -> GBP: конвертация 100 долларов в фунты")
    public void testUsdToGbp() {
        double result = converter.convert("USD", "GBP", 100);
        assertEquals(75.0, result, 0.001);
    }

    @Test
    @DisplayName("USD -> JPY: конвертация 100 долларов в йены")
    public void testUsdToJpy() {
        double result = converter.convert("USD", "JPY", 100);
        assertEquals(11000.0, result, 0.01);
    }

    @Test
    @DisplayName("USD -> USD: конвертация в ту же валюту")
    public void testUsdToUsd() {
        double result = converter.convert("USD", "USD", 100);
        assertEquals(100.0, result, 0.001);
    }

    @Test
    @DisplayName("USD -> EUR: конвертация 1 доллара")
    public void testUsdToEurOneDollar() {
        double result = converter.convert("USD", "EUR", 1);
        assertEquals(0.85, result, 0.001);
    }

    // ========== EUR (Евро) ==========

    @Test
    @DisplayName("EUR -> USD: конвертация 100 евро в доллары")
    public void testEurToUsd() {
        double result = converter.convert("EUR", "USD", 100);
        assertEquals(117.647, result, 0.01);
    }

    @Test
    @DisplayName("EUR -> GBP: конвертация 100 евро в фунты")
    public void testEurToGbp() {
        double result = converter.convert("EUR", "GBP", 100);
        assertEquals(88.235, result, 0.01);
    }

    @Test
    @DisplayName("EUR -> JPY: конвертация 100 евро в йены")
    public void testEurToJpy() {
        double result = converter.convert("EUR", "JPY", 100);
        assertEquals(12941.176, result, 0.1);
    }

    @Test
    @DisplayName("EUR -> EUR: конвертация в ту же валюту")
    public void testEurToEur() {
        double result = converter.convert("EUR", "EUR", 100);
        assertEquals(100.0, result, 0.001);
    }

    // ========== GBP (Фунт стерлингов) ==========

    @Test
    @DisplayName("GBP -> USD: конвертация 100 фунтов в доллары")
    public void testGbpToUsd() {
        double result = converter.convert("GBP", "USD", 100);
        assertEquals(133.333, result, 0.01);
    }

    @Test
    @DisplayName("GBP -> EUR: конвертация 100 фунтов в евро")
    public void testGbpToEur() {
        double result = converter.convert("GBP", "EUR", 100);
        assertEquals(113.333, result, 0.01);
    }

    @Test
    @DisplayName("GBP -> JPY: конвертация 100 фунтов в йены")
    public void testGbpToJpy() {
        double result = converter.convert("GBP", "JPY", 100);
        assertEquals(14666.667, result, 0.1);
    }

    @Test
    @DisplayName("GBP -> GBP: конвертация в ту же валюту")
    public void testGbpToGbp() {
        double result = converter.convert("GBP", "GBP", 100);
        assertEquals(100.0, result, 0.001);
    }

    // ========== JPY (Йена) ==========

    @Test
    @DisplayName("JPY -> USD: конвертация 11000 йен в доллары")
    public void testJpyToUsd() {
        double result = converter.convert("JPY", "USD", 11000);
        assertEquals(100.0, result, 0.01);
    }

    @Test
    @DisplayName("JPY -> EUR: конвертация 11000 йен в евро")
    public void testJpyToEur() {
        double result = converter.convert("JPY", "EUR", 11000);
        assertEquals(85.0, result, 0.01);
    }

    @Test
    @DisplayName("JPY -> GBP: конвертация 11000 йен в фунты")
    public void testJpyToGbp() {
        double result = converter.convert("JPY", "GBP", 11000);
        assertEquals(75.0, result, 0.01);
    }

    @Test
    @DisplayName("JPY -> JPY: конвертация в ту же валюту")
    public void testJpyToJpy() {
        double result = converter.convert("JPY", "JPY", 1000);
        assertEquals(1000.0, result, 0.001);
    }

    @Test
    @DisplayName("JPY -> USD: конвертация 1 йены")
    public void testJpyToUsdOneYen() {
        double result = converter.convert("JPY", "USD", 1);
        assertEquals(0.00909, result, 0.0001);
    }

    // ========== Граничные случаи ==========

    @Test
    @DisplayName("Конвертация нулевой суммы")
    public void testZeroAmount() {
        double result = converter.convert("USD", "EUR", 0);
        assertEquals(0.0, result, 0.001);
    }

    @Test
    @DisplayName("Конвертация очень маленькой суммы")
    public void testVerySmallAmount() {
        double result = converter.convert("USD", "EUR", 0.01);
        assertEquals(0.0085, result, 0.0001);
    }

    @Test
    @DisplayName("Конвертация большой суммы")
    public void testLargeAmount() {
        double result = converter.convert("USD", "EUR", 1000000);
        assertEquals(850000.0, result, 0.1);
    }

    @Test
    @DisplayName("Конвертация дробной суммы")
    public void testDecimalAmount() {
        double result = converter.convert("USD", "EUR", 123.45);
        assertEquals(104.9325, result, 0.001);
    }

    // ========== Валидация входных данных ==========

    @Test
    @DisplayName("Отрицательная сумма - исключение")
    public void testNegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.convert("USD", "EUR", -100);
        });
    }

    @Test
    @DisplayName("Несуществующая исходная валюта - исключение")
    public void testInvalidSourceCurrency() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.convert("ABC", "EUR", 100);
        });
    }

    @Test
    @DisplayName("Несуществующая целевая валюта - исключение")
    public void testInvalidTargetCurrency() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.convert("USD", "XYZ", 100);
        });
    }

    @Test
    @DisplayName("Null исходная валюта - исключение")
    public void testNullSourceCurrency() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.convert(null, "EUR", 100);
        });
    }

    @Test
    @DisplayName("Null целевая валюта - исключение")
    public void testNullTargetCurrency() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.convert("USD", null, 100);
        });
    }

    // ========== Регистронезависимость ==========

    @Test
    @DisplayName("Регистронезависимость: usd -> eur")
    public void testCaseInsensitiveLowercase() {
        double result = converter.convert("usd", "eur", 100);
        assertEquals(85.0, result, 0.001);
    }

    @Test
    @DisplayName("Регистронезависимость: Usd -> Eur")
    public void testCaseInsensitiveMixed() {
        double result = converter.convert("Usd", "Eur", 100);
        assertEquals(85.0, result, 0.001);
    }

    // ========== Методы получения информации ==========

    @Test
    @DisplayName("Получение курса USD")
    public void testGetExchangeRateUsd() {
        double rate = converter.getExchangeRate("USD");
        assertEquals(1.0, rate, 0.001);
    }

    @Test
    @DisplayName("Получение курса EUR")
    public void testGetExchangeRateEur() {
        double rate = converter.getExchangeRate("EUR");
        assertEquals(0.85, rate, 0.001);
    }

    @Test
    @DisplayName("Получение курса GBP")
    public void testGetExchangeRateGbp() {
        double rate = converter.getExchangeRate("GBP");
        assertEquals(0.75, rate, 0.001);
    }

    @Test
    @DisplayName("Получение курса JPY")
    public void testGetExchangeRateJpy() {
        double rate = converter.getExchangeRate("JPY");
        assertEquals(110.0, rate, 0.001);
    }

    @Test
    @DisplayName("Получение курса несуществующей валюты - исключение")
    public void testGetExchangeRateInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.getExchangeRate("ABC");
        });
    }

    @Test
    @DisplayName("Получение курса null - исключение")
    public void testGetExchangeRateNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.getExchangeRate(null);
        });
    }

    @Test
    @DisplayName("Проверка поддержки валюты: USD")
    public void testIsCurrencySupportedUsd() {
        assertTrue(converter.isCurrencySupported("USD"));
    }

    @Test
    @DisplayName("Проверка поддержки валюты: EUR")
    public void testIsCurrencySupportedEur() {
        assertTrue(converter.isCurrencySupported("EUR"));
    }

    @Test
    @DisplayName("Проверка поддержки валюты: GBP")
    public void testIsCurrencySupportedGbp() {
        assertTrue(converter.isCurrencySupported("GBP"));
    }

    @Test
    @DisplayName("Проверка поддержки валюты: JPY")
    public void testIsCurrencySupportedJpy() {
        assertTrue(converter.isCurrencySupported("JPY"));
    }

    @Test
    @DisplayName("Проверка поддержки несуществующей валюты")
    public void testIsCurrencySupportedInvalid() {
        assertFalse(converter.isCurrencySupported("ABC"));
    }

    @Test
    @DisplayName("Проверка поддержки null валюты")
    public void testIsCurrencySupportedNull() {
        assertFalse(converter.isCurrencySupported(null));
    }

    @Test
    @DisplayName("Получение списка поддерживаемых валют")
    public void testGetSupportedCurrencies() {
        java.util.Set<String> currencies = converter.getSupportedCurrencies();
        assertTrue(currencies.contains("USD"));
        assertTrue(currencies.contains("EUR"));
        assertTrue(currencies.contains("GBP"));
        assertTrue(currencies.contains("JPY"));
        assertEquals(4, currencies.size());
    }

    // ========== Интеграционные тесты ==========

    @Test
    @DisplayName("Интеграционный тест: конвертация по кругу USD->EUR->GBP->JPY->USD")
    public void testRoundTripConversion() {
        double amount = 100;
        double eur = converter.convert("USD", "EUR", amount);
        double gbp = converter.convert("EUR", "GBP", eur);
        double jpy = converter.convert("GBP", "JPY", gbp);
        double backToUsd = converter.convert("JPY", "USD", jpy);
        assertEquals(100.0, backToUsd, 0.1);
    }

    @Test
    @DisplayName("Интеграционный тест: обратная конвертация")
    public void testReverseConversion() {
        double amount = 100;
        double converted = converter.convert("USD", "EUR", amount);
        double reversed = converter.convert("EUR", "USD", converted);
        assertEquals(amount, reversed, 0.01);
    }
}

