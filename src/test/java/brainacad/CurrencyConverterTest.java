package brainacad;

import brainacad.currencies.models.CurrencyConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.*;

public class CurrencyConverterTest {
    private CurrencyConverter converter;

    @BeforeEach
    void setUp() {
        converter = new CurrencyConverter();
    }

    @Test
    public void CurrencyConverterTest_should_return_85_if_called() {
        if (converter!=null) {
            double result = converter.convert("USD", "EUR", 100);
            assertEquals(85, result, 0.001);
        }
    }

    @Test
    public void CurrencyConverterTest_should_return_88_235_if_called() {
        if (converter!=null) {
            double result = converter.convert("EUR", "GBP", 100);
            assertEquals(88.235, result, 0.001);
        }
    }

    @Test
    public void CurrencyConverterTest_should_return_14666_67_if_called() {
        if (converter!=null) {
        double result = converter.convert("GBP", "JPY", 100);
        assertEquals(14666.67, result, 0.01);
        }
    }

    @Test
    public void CurrencyConverterTest_should_return_InvalidCurrency_if_called() {
        if (converter!=null) {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.convert("USD", "ABC", 100);
        });
    }
    }
}

