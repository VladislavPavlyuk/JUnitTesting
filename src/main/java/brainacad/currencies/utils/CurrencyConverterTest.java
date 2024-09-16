package brainacad;

import currencies.models.CurrencyConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyConverterTest {
    private CurrencyConverter converter;

    @BeforeEach
    void setUp() {
        converter = new CurrencyConverter();
    }

    @Test
    void testConvertUsdToEur() {
        double result = converter.convert("USD", "EUR", 100);
        assertEquals(85, result, 0.001);
    }

    @Test
    void testConvertEurToGbp() {
        double result = converter.convert("EUR", "GBP", 100);
        assertEquals(88.235, result, 0.001);
    }

    @Test
    void testConvertGbpToJpy() {
        double result = converter.convert("GBP", "JPY", 100);
        assertEquals(14666.67, result, 0.01);
    }

    @Test
    void testInvalidCurrency() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.convert("USD", "ABC", 100);
        });
    }
}

