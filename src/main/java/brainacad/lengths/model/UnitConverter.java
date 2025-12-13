package brainacad.lengths.model;

import brainacad.converter.providers.UnitConversionProvider;
import java.util.Map;

public abstract class UnitConverter {
    protected final Map<String, Double> conversionRates;
    protected final String baseUnit;

    protected UnitConverter(UnitConversionProvider provider) {
        if (provider == null) {
            throw new IllegalArgumentException("UnitConversionProvider cannot be null");
        }
        this.conversionRates = provider.getConversionRates();
        this.baseUnit = provider.getBaseUnit();
    }

    public double convert(String fromUnit, String toUnit, double value) {
        validateInput(value, fromUnit, toUnit);
        
        String from = normalizeUnit(fromUnit);
        String to = normalizeUnit(toUnit);
        
        if (from.equals(to)) {
            return value;
        }
        
        double baseValue = convertToBase(from, value);
        return convertFromBase(to, baseValue);
    }

    protected double convertToBase(String unit, double value) {
        Double rate = conversionRates.get(unit);
        if (rate == null) {
            throw new IllegalArgumentException("Unknown source unit: " + unit);
        }
        return value * rate;
    }

    protected double convertFromBase(String unit, double baseValue) {
        Double rate = conversionRates.get(unit);
        if (rate == null) {
            throw new IllegalArgumentException("Unknown target unit: " + unit);
        }
        return baseValue / rate;
    }

    protected String normalizeUnit(String unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        return unit.toLowerCase().trim();
    }

    protected void validateInput(double value, String fromUnit, String toUnit) {
        if (value < 0) {
            throw new IllegalArgumentException("Value cannot be negative");
        }
        if (fromUnit == null || toUnit == null) {
            throw new IllegalArgumentException("Unit names cannot be null");
        }
    }
}

