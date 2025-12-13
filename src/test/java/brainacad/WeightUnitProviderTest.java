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
    public void getConversionRates_WhenCalled_ReturnsNotNull() {
        Map<String, Double> rates = provider.getConversionRates();
        assertNotNull(rates);
    }

    @Test
    @DisplayName("getConversionRates содержит все единицы веса")
    public void getConversionRates_WhenCalled_ContainsAllUnits() {
        Map<String, Double> rates = provider.getConversionRates();
        assertTrue(rates.containsKey("mg"));
        assertTrue(rates.containsKey("g"));
        assertTrue(rates.containsKey("kg"));
        assertTrue(rates.containsKey("cwt"));
        assertTrue(rates.containsKey("t"));
    }

    @Test
    @DisplayName("getConversionRates: килограммы имеют коэффициент 1.0")
    public void getConversionRates_WhenKilogram_ReturnsOne() {
        Map<String, Double> rates = provider.getConversionRates();
        double actualResultKg = rates.get("kg");
        double expectedResultKg = 1.0;
        assertEquals(expectedResultKg, actualResultKg, 0.001);
        
        double actualResultKilogram = rates.get("kilogram");
        double expectedResultKilogram = 1.0;
        assertEquals(expectedResultKilogram, actualResultKilogram, 0.001);
        
        double actualResultKilograms = rates.get("kilograms");
        double expectedResultKilograms = 1.0;
        assertEquals(expectedResultKilograms, actualResultKilograms, 0.001);
    }

    @Test
    @DisplayName("getConversionRates: миллиграммы имеют коэффициент 0.000001")
    public void getConversionRates_WhenMilligram_ReturnsZeroPointZeroZeroZeroZeroZeroOne() {
        Map<String, Double> rates = provider.getConversionRates();
        double actualResult = rates.get("mg");
        double expectedResult = 0.000001;
        assertEquals(expectedResult, actualResult, 0.0000001);
    }

    @Test
    @DisplayName("getConversionRates: граммы имеют коэффициент 0.001")
    public void getConversionRates_WhenGram_ReturnsZeroPointZeroZeroOne() {
        Map<String, Double> rates = provider.getConversionRates();
        double actualResult = rates.get("g");
        double expectedResult = 0.001;
        assertEquals(expectedResult, actualResult, 0.0001);
    }

    @Test
    @DisplayName("getConversionRates: центнеры имеют коэффициент 100.0")
    public void getConversionRates_WhenCentner_ReturnsHundred() {
        Map<String, Double> rates = provider.getConversionRates();
        double actualResult = rates.get("cwt");
        double expectedResult = 100.0;
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    @DisplayName("getConversionRates: тонны имеют коэффициент 1000.0")
    public void getConversionRates_WhenTon_ReturnsThousand() {
        Map<String, Double> rates = provider.getConversionRates();
        double actualResultT = rates.get("t");
        double expectedResultT = 1000.0;
        assertEquals(expectedResultT, actualResultT, 0.001);
        
        double actualResultTon = rates.get("ton");
        double expectedResultTon = 1000.0;
        assertEquals(expectedResultTon, actualResultTon, 0.001);
        
        double actualResultTonne = rates.get("tonne");
        double expectedResultTonne = 1000.0;
        assertEquals(expectedResultTonne, actualResultTonne, 0.001);
    }

    @Test
    @DisplayName("getBaseUnit возвращает 'kg'")
    public void getBaseUnit_WhenCalled_ReturnsKilogram() {
        assertEquals("kg", provider.getBaseUnit());
    }

    @Test
    @DisplayName("getConversionRates: все коэффициенты положительные")
    public void getConversionRates_WhenCalled_AllRatesArePositive() {
        Map<String, Double> rates = provider.getConversionRates();
        for (Double rate : rates.values()) {
            assertTrue(rate > 0, "Rate should be positive: " + rate);
        }
    }
}

