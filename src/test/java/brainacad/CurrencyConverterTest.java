package brainacad;

import brainacad.currencies.models.CurrencyConverter;
import brainacad.currencies.providers.DefaultExchangeRateProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тесты для конвертации валют")
public class CurrencyConverterTest {
    private CurrencyConverter converter;

    @BeforeEach
    void setUp() {
        converter = new CurrencyConverter(new DefaultExchangeRateProvider());
    }

    // ========== USD (Доллар) ==========

    @Test
    @DisplayName("USD -> EUR: конвертация 100 долларов в евро")
    public void convert_WhenUsdToEur_ReturnsCorrectAmount() {
        double actualResult = converter.convert("USD", "EUR", 100);
        double expectedResult = 85.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("USD -> GBP: конвертация 100 долларов в фунты")
    public void convert_WhenUsdToGbp_ReturnsCorrectAmount() {
        double actualResult = converter.convert("USD", "GBP", 100);
        double expectedResult = 75.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("USD -> JPY: конвертация 100 долларов в йены")
    public void convert_WhenUsdToJpy_ReturnsCorrectAmount() {
        double actualResult = converter.convert("USD", "JPY", 100);
        double expectedResult = 11000.0;
        assertEquals(expectedResult, actualResult, 0.01);
    }

    @Test
    @DisplayName("USD -> USD: конвертация в ту же валюту")
    public void convert_WhenSameCurrency_ReturnsSameAmount() {
        double actualResult = converter.convert("USD", "USD", 100);
        double expectedResult = 100.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("USD -> EUR: конвертация 1 доллара")
    public void convert_WhenOneDollarToEur_ReturnsCorrectAmount() {
        double actualResult = converter.convert("USD", "EUR", 1);
        double expectedResult = 0.85;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    // ========== EUR (Евро) ==========

    @Test
    @DisplayName("EUR -> USD: конвертация 100 евро в доллары")
    public void convert_WhenEurToUsd_ReturnsCorrectAmount() {
        double actualResult = converter.convert("EUR", "USD", 100);
        double expectedResult = 117.647;
        assertEquals(expectedResult, actualResult, 0.01);
    }

    @Test
    @DisplayName("EUR -> GBP: конвертация 100 евро в фунты")
    public void convert_WhenEurToGbp_ReturnsCorrectAmount() {
        double actualResult = converter.convert("EUR", "GBP", 100);        double expectedResult = 88.235;        assertEquals(expectedResult, actualResult, 0.01);
    }

    @Test
    @DisplayName("EUR -> JPY: конвертация 100 евро в йены")
    public void convert_WhenEurToJpy_ReturnsCorrectAmount() {
        double actualResult = converter.convert("EUR", "JPY", 100);        double expectedResult = 12941.176;        assertEquals(expectedResult, actualResult, 0.1);
    }

    @Test
    @DisplayName("EUR -> EUR: конвертация в ту же валюту")
    public void convert_WhenSameCurrencyEur_ReturnsSameAmount() {
        double actualResult = converter.convert("EUR", "EUR", 100);        double expectedResult = 100.0;        assertEquals(expectedResult, actualResult, 0.001);
    }

    // ========== GBP (Фунт стерлингов) ==========

    @Test
    @DisplayName("GBP -> USD: конвертация 100 фунтов в доллары")
    public void convert_WhenGbpToUsd_ReturnsCorrectAmount() {
        double actualResult = converter.convert("GBP", "USD", 100);        double expectedResult = 133.333;        assertEquals(expectedResult, actualResult, 0.01);
    }

    @Test
    @DisplayName("GBP -> EUR: конвертация 100 фунтов в евро")
    public void convert_WhenGbpToEur_ReturnsCorrectAmount() {
        double actualResult = converter.convert("GBP", "EUR", 100);        double expectedResult = 113.333;        assertEquals(expectedResult, actualResult, 0.01);
    }

    @Test
    @DisplayName("GBP -> JPY: конвертация 100 фунтов в йены")
    public void convert_WhenGbpToJpy_ReturnsCorrectAmount() {
        double actualResult = converter.convert("GBP", "JPY", 100);        double expectedResult = 14666.667;        assertEquals(expectedResult, actualResult, 0.1);
    }

    @Test
    @DisplayName("GBP -> GBP: конвертация в ту же валюту")
    public void convert_WhenSameCurrencyGbp_ReturnsSameAmount() {
        double actualResult = converter.convert("GBP", "GBP", 100);        double expectedResult = 100.0;        assertEquals(expectedResult, actualResult, 0.001);
    }

    // ========== JPY (Йена) ==========

    @Test
    @DisplayName("JPY -> USD: конвертация 11000 йен в доллары")
    public void convert_WhenJpyToUsd_ReturnsCorrectAmount() {
        double actualResult = converter.convert("JPY", "USD", 11000);        double expectedResult = 100.0;        assertEquals(expectedResult, actualResult, 0.01);
    }

    @Test
    @DisplayName("JPY -> EUR: конвертация 11000 йен в евро")
    public void convert_WhenJpyToEur_ReturnsCorrectAmount() {
        double actualResult = converter.convert("JPY", "EUR", 11000);        double expectedResult = 85.0;        assertEquals(expectedResult, actualResult, 0.01);
    }

    @Test
    @DisplayName("JPY -> GBP: конвертация 11000 йен в фунты")
    public void convert_WhenJpyToGbp_ReturnsCorrectAmount() {
        double actualResult = converter.convert("JPY", "GBP", 11000);        double expectedResult = 75.0;        assertEquals(expectedResult, actualResult, 0.01);
    }

    @Test
    @DisplayName("JPY -> JPY: конвертация в ту же валюту")
    public void convert_WhenSameCurrencyJpy_ReturnsSameAmount() {
        double actualResult = converter.convert("JPY", "JPY", 1000);        double expectedResult = 1000.0;        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("JPY -> USD: конвертация 1 йены")
    public void convert_WhenOneYenToUsd_ReturnsCorrectAmount() {
        double actualResult = converter.convert("JPY", "USD", 1);        double expectedResult = 0.00909;        assertEquals(expectedResult, actualResult, 0.0001);
    }

    // ========== Граничные случаи ==========

    @Test
    @DisplayName("Конвертация нулевой суммы")
    public void convert_WhenZeroAmount_ReturnsZero() {
        double actualResult = converter.convert("USD", "EUR", 0);        double expectedResult = 0.0;        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Конвертация очень маленькой суммы")
    public void convert_WhenVerySmallAmount_ReturnsCorrectAmount() {
        double actualResult = converter.convert("USD", "EUR", 0.01);        double expectedResult = 0.0085;        assertEquals(expectedResult, actualResult, 0.0001);
    }

    @Test
    @DisplayName("Конвертация большой суммы")
    public void convert_WhenLargeAmount_ReturnsCorrectAmount() {
        double actualResult = converter.convert("USD", "EUR", 1000000);        double expectedResult = 850000.0;        assertEquals(expectedResult, actualResult, 0.1);
    }

    @Test
    @DisplayName("Конвертация дробной суммы")
    public void convert_WhenDecimalAmount_ReturnsCorrectAmount() {
        double actualResult = converter.convert("USD", "EUR", 123.45);        double expectedResult = 104.9325;        assertEquals(expectedResult, actualResult, 0.001);
    }

    // ========== Валидация входных данных ==========

    @Test
    @DisplayName("Отрицательная сумма - исключение")
    public void convert_WhenNegativeAmount_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.convert("USD", "EUR", -100);
        });
    }

    @Test
    @DisplayName("Несуществующая исходная валюта - исключение")
    public void convert_WhenInvalidSourceCurrency_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.convert("ABC", "EUR", 100);
        });
    }

    @Test
    @DisplayName("Несуществующая целевая валюта - исключение")
    public void convert_WhenInvalidTargetCurrency_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.convert("USD", "XYZ", 100);
        });
    }

    @Test
    @DisplayName("Null исходная валюта - исключение")
    public void convert_WhenNullSourceCurrency_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.convert(null, "EUR", 100);
        });
    }

    @Test
    @DisplayName("Null целевая валюта - исключение")
    public void convert_WhenNullTargetCurrency_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.convert("USD", null, 100);
        });
    }

    // ========== Регистронезависимость ==========

    @Test
    @DisplayName("Регистронезависимость: usd -> eur")
    public void convert_WhenLowercaseCurrencies_ReturnsCorrectAmount() {
        double actualResult = converter.convert("usd", "eur", 100);        double expectedResult = 85.0;        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Регистронезависимость: Usd -> Eur")
    public void convert_WhenMixedCaseCurrencies_ReturnsCorrectAmount() {
        double actualResult = converter.convert("Usd", "Eur", 100);        double expectedResult = 85.0;        assertEquals(expectedResult, actualResult, 0.001);
    }

    // ========== Методы получения информации ==========

    @Test
    @DisplayName("Получение курса USD")
    public void getExchangeRate_WhenUsd_ReturnsOne() {
        double actualResult = converter.getExchangeRate("USD");
        double expectedResult = 1.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Получение курса EUR")
    public void getExchangeRate_WhenEur_ReturnsCorrectRate() {
        double actualResult = converter.getExchangeRate("EUR");
        double expectedResult = 0.85;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Получение курса GBP")
    public void getExchangeRate_WhenGbp_ReturnsCorrectRate() {
        double actualResult = converter.getExchangeRate("GBP");
        double expectedResult = 0.75;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Получение курса JPY")
    public void getExchangeRate_WhenJpy_ReturnsCorrectRate() {
        double actualResult = converter.getExchangeRate("JPY");
        double expectedResult = 110.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("Получение курса несуществующей валюты - исключение")
    public void getExchangeRate_WhenInvalidCurrency_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.getExchangeRate("ABC");
        });
    }

    @Test
    @DisplayName("Получение курса null - исключение")
    public void getExchangeRate_WhenNullCurrency_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.getExchangeRate(null);
        });
    }

    @Test
    @DisplayName("Проверка поддержки валюты: USD")
    public void isCurrencySupported_WhenUsd_ReturnsTrue() {
        boolean actualResult = converter.isCurrencySupported("USD");
        boolean expectedResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Проверка поддержки валюты: EUR")
    public void isCurrencySupported_WhenEur_ReturnsTrue() {
        boolean actualResult = converter.isCurrencySupported("EUR");
        boolean expectedResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Проверка поддержки валюты: GBP")
    public void isCurrencySupported_WhenGbp_ReturnsTrue() {
        boolean actualResult = converter.isCurrencySupported("GBP");
        boolean expectedResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Проверка поддержки валюты: JPY")
    public void isCurrencySupported_WhenJpy_ReturnsTrue() {
        boolean actualResult = converter.isCurrencySupported("JPY");
        boolean expectedResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Проверка поддержки несуществующей валюты")
    public void isCurrencySupported_WhenInvalidCurrency_ReturnsFalse() {
        boolean actualResult = converter.isCurrencySupported("ABC");
        boolean expectedResult = false;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Проверка поддержки null валюты")
    public void isCurrencySupported_WhenNullCurrency_ReturnsFalse() {
        boolean actualResult = converter.isCurrencySupported(null);
        boolean expectedResult = false;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Получение списка поддерживаемых валют")
    public void getSupportedCurrencies_WhenCalled_ReturnsFourCurrencies() {
        java.util.Set<String> currencies = converter.getSupportedCurrencies();
        assertTrue(currencies.contains("USD"));
        assertTrue(currencies.contains("EUR"));
        assertTrue(currencies.contains("GBP"));
        assertTrue(currencies.contains("JPY"));
        int actualResult = currencies.size();
        int expectedResult = 4;
        assertEquals(expectedResult, actualResult);
    }

    // ========== Интеграционные тесты ==========

    @Test
    @DisplayName("Интеграционный тест: конвертация по кругу USD->EUR->GBP->JPY->USD")
    public void convert_WhenRoundTripConversion_ReturnsOriginalAmount() {
        double amount = 100;
        double eur = converter.convert("USD", "EUR", amount);
        double gbp = converter.convert("EUR", "GBP", eur);
        double jpy = converter.convert("GBP", "JPY", gbp);
        double backToUsd = converter.convert("JPY", "USD", jpy);
        double expectedResult = 100.0;
        assertEquals(expectedResult, backToUsd, 0.1);
    }

    @Test
    @DisplayName("Интеграционный тест: обратная конвертация")
    public void convert_WhenReverseConversion_ReturnsCorrectAmount() {
        double amount = 100;
        double converted = converter.convert("USD", "EUR", amount);
        double reversed = converter.convert("EUR", "USD", converted);
        double expectedResult = amount;
        assertEquals(expectedResult, reversed, 0.01);
    }
}


