package brainacad.lengths.providers;

import brainacad.converter.providers.UnitConversionProvider;
import java.util.HashMap;
import java.util.Map;

public class LengthUnitProvider implements UnitConversionProvider {
    @Override
    public Map<String, Double> getConversionRates() {
        Map<String, Double> rates = new HashMap<>();
        rates.put("mm", 0.001);
        rates.put("millimeter", 0.001);
        rates.put("millimeters", 0.001);
        rates.put("cm", 0.01);
        rates.put("centimeter", 0.01);
        rates.put("centimeters", 0.01);
        rates.put("dm", 0.1);
        rates.put("decimeter", 0.1);
        rates.put("decimeters", 0.1);
        rates.put("m", 1.0);
        rates.put("meter", 1.0);
        rates.put("meters", 1.0);
        rates.put("km", 1000.0);
        rates.put("kilometer", 1000.0);
        rates.put("kilometers", 1000.0);
        return rates;
    }

    @Override
    public String getBaseUnit() {
        return "m";
    }
}

