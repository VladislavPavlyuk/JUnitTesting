package brainacad.converter.providers;

import java.util.Map;

public interface UnitConversionProvider {
    Map<String, Double> getConversionRates();
    String getBaseUnit();
}


