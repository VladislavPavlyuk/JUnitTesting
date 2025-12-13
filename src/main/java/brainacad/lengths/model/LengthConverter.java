package brainacad.lengths.model;

import brainacad.converter.providers.UnitConversionProvider;
import brainacad.lengths.providers.LengthUnitProvider;

public class LengthConverter extends UnitConverter {
    
    public LengthConverter() {
        this(new LengthUnitProvider());
    }

    public LengthConverter(UnitConversionProvider provider) {
        super(provider);
    }

    // Методы для обратной совместимости (конвертация из метров)
    public double toMillimeters(double meters) {
        return convert("m", "mm", meters);
    }

    public double toCentimeters(double meters) {
        return convert("m", "cm", meters);
    }

    public double toDecimeters(double meters) {
        return convert("m", "dm", meters);
    }

    public double toMeters(double meters) {
        return convert("m", "m", meters);
    }

    public double toKilometers(double meters) {
        return convert("m", "km", meters);
    }
}

