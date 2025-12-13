package brainacad;

import brainacad.converter.providers.UnitConversionProvider;
import brainacad.lengths.providers.LengthUnitProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

@DisplayName("Тесты для провайдера единиц длины")
public class LengthUnitProviderTest {
    private UnitConversionProvider provider;

    @BeforeEach
    void setUp() {
        provider = new LengthUnitProvider();
    }

    @Test
    @DisplayName("getConversionRates возвращает не-null карту")
    public void testGetConversionRates_NotNull() {
        Map<String, Double> rates = provider.getConversionRates();
        assertNotNull(rates);
    }

    @Test
    @DisplayName("getConversionRates содержит все единицы длины")
    public void testGetConversionRates_ContainsAllUnits() {
        Map<String, Double> rates = provider.getConversionRates();
        assertTrue(rates.containsKey("mm"));
        assertTrue(rates.containsKey("cm"));
        assertTrue(rates.containsKey("dm"));
        assertTrue(rates.containsKey("m"));
        assertTrue(rates.containsKey("km"));
    }

    @Test
    @DisplayName("getConversionRates: метры имеют коэффициент 1.0")
    public void testGetConversionRates_MeterRate() {
        Map<String, Double> rates = provider.getConversionRates();
        double actualResultM = rates.get("m");
        double expectedResultM = 1.0;
        assertEquals(expectedResultM, actualResultM, 0.001);
        
        double actualResultMeter = rates.get("meter");
        double expectedResultMeter = 1.0;
        assertEquals(expectedResultMeter, actualResultMeter, 0.001);
        
        double actualResultMeters = rates.get("meters");
        double expectedResultMeters = 1.0;
        assertEquals(expectedResultMeters, actualResultMeters, 0.001);
    }

    @Test
    @DisplayName("getConversionRates: миллиметры имеют коэффициент 0.001")
    public void testGetConversionRates_MillimeterRate() {
        Map<String, Double> rates = provider.getConversionRates();
        double actualResult = rates.get("mm");
        double expectedResult = 0.001;
        assertEquals(expectedResult, actualResult, 0.0001);
    }

    @Test
    @DisplayName("getConversionRates: сантиметры имеют коэффициент 0.01")
    public void testGetConversionRates_CentimeterRate() {
        Map<String, Double> rates = provider.getConversionRates();
        double actualResult = rates.get("cm");
        double expectedResult = 0.01;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("getConversionRates: дециметры имеют коэффициент 0.1")
    public void testGetConversionRates_DecimeterRate() {
        Map<String, Double> rates = provider.getConversionRates();
        double actualResult = rates.get("dm");
        double expectedResult = 0.1;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("getConversionRates: километры имеют коэффициент 1000.0")
    public void testGetConversionRates_KilometerRate() {
        Map<String, Double> rates = provider.getConversionRates();
        double actualResult = rates.get("km");
        double expectedResult = 1000.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("getBaseUnit возвращает 'm'")
    public void testGetBaseUnit() {
        assertEquals("m", provider.getBaseUnit());
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

