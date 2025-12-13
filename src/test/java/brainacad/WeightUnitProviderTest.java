package brainacad;

import brainacad.converter.providers.UnitConversionProvider;
import brainacad.weights.providers.WeightUnitProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

@DisplayName("Тесты для провайдера единиц веса")
public class WeightUnitProviderTest {
    private UnitConversionProvider provider;

    @BeforeEach
    void setUp() {
        provider = new WeightUnitProvider();
    }

    @Test
    @DisplayName("getConversionRates возвращает не-null карту")
    public void testGetConversionRates_NotNull() {
        Map<String, Double> rates = provider.getConversionRates();
        assertNotNull(rates);
    }

    @Test
    @DisplayName("getConversionRates содержит все единицы веса")
    public void testGetConversionRates_ContainsAllUnits() {
        Map<String, Double> rates = provider.getConversionRates();
        assertTrue(rates.containsKey("mg"));
        assertTrue(rates.containsKey("g"));
        assertTrue(rates.containsKey("kg"));
        assertTrue(rates.containsKey("cwt"));
        assertTrue(rates.containsKey("t"));
    }

    @Test
    @DisplayName("getConversionRates: килограммы имеют коэффициент 1.0")
    public void testGetConversionRates_KilogramRate() {
        Map<String, Double> rates = provider.getConversionRates();
        assertEquals(1.0, rates.get("kg"), 0.001);
        assertEquals(1.0, rates.get("kilogram"), 0.001);
        assertEquals(1.0, rates.get("kilograms"), 0.001);
    }

    @Test
    @DisplayName("getConversionRates: миллиграммы имеют коэффициент 0.000001")
    public void testGetConversionRates_MilligramRate() {
        Map<String, Double> rates = provider.getConversionRates();
        assertEquals(0.000001, rates.get("mg"), 0.0000001);
    }

    @Test
    @DisplayName("getConversionRates: граммы имеют коэффициент 0.001")
    public void testGetConversionRates_GramRate() {
        Map<String, Double> rates = provider.getConversionRates();
        assertEquals(0.001, rates.get("g"), 0.001);
    }

    @Test
    @DisplayName("getConversionRates: центнеры имеют коэффициент 100.0")
    public void testGetConversionRates_CentnerRate() {
        Map<String, Double> rates = provider.getConversionRates();
        assertEquals(100.0, rates.get("cwt"), 0.001);
    }

    @Test
    @DisplayName("getConversionRates: тонны имеют коэффициент 1000.0")
    public void testGetConversionRates_TonRate() {
        Map<String, Double> rates = provider.getConversionRates();
        assertEquals(1000.0, rates.get("t"), 0.001);
        assertEquals(1000.0, rates.get("ton"), 0.001);
        assertEquals(1000.0, rates.get("tonne"), 0.001);
    }

    @Test
    @DisplayName("getBaseUnit возвращает 'kg'")
    public void testGetBaseUnit() {
        assertEquals("kg", provider.getBaseUnit());
    }

    @Test
    @DisplayName("getConversionRates: все коэффициенты положительные")
    public void testGetConversionRates_AllRatesPositive() {
        Map<String, Double> rates = provider.getConversionRates();
        for (Double rate : rates.values()) {
            assertTrue(rate > 0, "Rate should be positive: " + rate);
        }
    }
}

