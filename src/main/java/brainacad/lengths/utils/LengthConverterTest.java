package brainacad.lengths.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import brainacad.lengths.model.LengthConverter;
import org.junit.jupiter.api.Test;

public class LengthConverterTest {
    LengthConverter converter = new LengthConverter();

    @Test
    public void testToMillimeters() {
        assertEquals(1000, converter.toMillimeters(1), 0.001);
    }

    @Test
    public void testToCentimeters() {
        assertEquals(100, converter.toCentimeters(1), 0.001);
    }

    @Test
    public void testToDecimeters() {
        assertEquals(10, converter.toDecimeters(1), 0.001);
    }

    @Test
    public void testToMeters() {
        assertEquals(1, converter.toMeters(1), 0.001);
    }

    @Test
    public void testToKilometers() {
        assertEquals(0.001, converter.toKilometers(1), 0.001);
    }
}

