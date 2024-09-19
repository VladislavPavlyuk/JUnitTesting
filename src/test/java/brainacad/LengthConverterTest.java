package brainacad;

import static org.junit.jupiter.api.Assertions.assertEquals;

import brainacad.lengths.model.LengthConverter;
import org.junit.jupiter.api.Test;

public class LengthConverterTest {
    LengthConverter converter = new LengthConverter();

    @Test
    public void toMillimeters_ConverterTest_should_return_1000_if_called() {
        assertEquals(1000, converter.toMillimeters(1), 0.001);
    }

    @Test
    public void toCentimeters_ConverterTest_should_return_100_if_called() {
        assertEquals(100, converter.toCentimeters(1), 0.001);
    }

    @Test
    public void toDecimeters_ConverterTest_should_return_10_if_called() {
        assertEquals(10, converter.toDecimeters(1), 0.001);
    }

    @Test
    public void toMeters_ConverterTest_should_return_1_if_called() {
        assertEquals(1, converter.toMeters(1), 0.001);
    }

    @Test
    public void toKilometers_ConverterTest_should_return_001_if_called() {
        assertEquals(0.001, converter.toKilometers(1), 0.001);
    }
}

