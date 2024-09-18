package brainacad;

import static org.junit.jupiter.api.Assertions.assertEquals;

import brainacad.weights.models.WeightConverter;
import org.junit.jupiter.api.Test;

public class WeightConverterTest {
    private final WeightConverter converter = new WeightConverter();

    @Test
    public void WeightConverterTest_should_return_1_000_000_if_called() {
        assertEquals(1_000_000, converter.toMilligrams(1), 0.001);
    }

    @Test
    public void WeightConverterTest_should_return_1_000_if_called() {
        assertEquals(1_000, converter.toGrams(1), 0.001);
    }

    @Test
    public void WeightConverterTest_should_return_1_if_called() {
        assertEquals(1, converter.toKilograms(1), 0.001);
    }

    @Test
    public void WeightConverterTest_should_return_01_if_called() {
        assertEquals(0.01, converter.toCentners(1), 0.001);
    }

    @Test
    public void WeightConverterTest_should_return_001_if_called() {

        assertEquals(0.001, converter.toTons(1), 0.001);
    }
}

