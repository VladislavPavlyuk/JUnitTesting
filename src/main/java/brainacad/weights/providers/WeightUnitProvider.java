package brainacad.weights.providers;

import brainacad.converter.providers.UnitConversionProvider;
import java.util.HashMap;
import java.util.Map;

public class WeightUnitProvider implements UnitConversionProvider {
    @Override
    public Map<String, Double> getConversionRates() {
        Map<String, Double> rates = new HashMap<>();
        rates.put("mg", 0.000001);
        rates.put("milligram", 0.000001);
        rates.put("milligrams", 0.000001);
        rates.put("g", 0.001);
        rates.put("gram", 0.001);
        rates.put("grams", 0.001);
        rates.put("kg", 1.0);
        rates.put("kilogram", 1.0);
        rates.put("kilograms", 1.0);
        rates.put("cwt", 100.0);
        rates.put("centner", 100.0);
        rates.put("centners", 100.0);
        rates.put("t", 1000.0);
        rates.put("ton", 1000.0);
        rates.put("tons", 1000.0);
        rates.put("tonne", 1000.0);
        rates.put("tonnes", 1000.0);
        return rates;
    }

    @Override
    public String getBaseUnit() {
        return "kg";
    }
}

