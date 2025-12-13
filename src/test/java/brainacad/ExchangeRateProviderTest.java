package brainacad;

import brainacad.currencies.providers.DefaultExchangeRateProvider;
import brainacad.currencies.providers.ExchangeRateProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

@DisplayName("Тесты для провайдера курсов валют")
public class ExchangeRateProviderTest {
    private ExchangeRateProvider provider;

    @BeforeEach
    void setUp() {
        provider = new DefaultExchangeRateProvider();
    }

    @Test
    @DisplayName("getExchangeRates возвращает не-null карту")
    public void testGetExchangeRates_NotNull() {
        Map<String, Double> rates = provider.getExchangeRates();
        assertNotNull(rates);
    }

    @Test
    @DisplayName("getExchangeRates возвращает карту с курсами валют")
    public void testGetExchangeRates_ContainsCurrencies() {
        Map<String, Double> rates = provider.getExchangeRates();
        assertTrue(rates.containsKey("USD"));
        assertTrue(rates.containsKey("EUR"));
        assertTrue(rates.containsKey("GBP"));
        assertTrue(rates.containsKey("JPY"));
    }

    @Test
    @DisplayName("getExchangeRates: USD имеет курс 1.0")
    public void testGetExchangeRates_UsdRate() {
        Map<String, Double> rates = provider.getExchangeRates();
        double actualResult = rates.get("USD");
        double expectedResult = 1.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("getExchangeRates: EUR имеет курс 0.85")
    public void testGetExchangeRates_EurRate() {
        Map<String, Double> rates = provider.getExchangeRates();
        double actualResult = rates.get("EUR");
        double expectedResult = 0.85;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("getExchangeRates: GBP имеет курс 0.75")
    public void testGetExchangeRates_GbpRate() {
        Map<String, Double> rates = provider.getExchangeRates();
        double actualResult = rates.get("GBP");
        double expectedResult = 0.75;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("getExchangeRates: JPY имеет курс 110.0")
    public void testGetExchangeRates_JpyRate() {
        Map<String, Double> rates = provider.getExchangeRates();
        double actualResult = rates.get("JPY");
        double expectedResult = 110.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("getExchangeRates возвращает 4 валюты")
    public void testGetExchangeRates_Size() {
        Map<String, Double> rates = provider.getExchangeRates();
        int actualResult = rates.size();
        int expectedResult = 4;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("getExchangeRates: все курсы положительные")
    public void testGetExchangeRates_AllRatesPositive() {
        Map<String, Double> rates = provider.getExchangeRates();
        for (Double rate : rates.values()) {
            assertTrue(rate > 0, "Rate should be positive: " + rate);
        }
    }
}

