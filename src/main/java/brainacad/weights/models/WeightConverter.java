package brainacad.weights.models;

import brainacad.converter.providers.UnitConversionProvider;
import brainacad.lengths.model.UnitConverter;
import brainacad.weights.providers.WeightUnitProvider;

public class WeightConverter extends UnitConverter {
    
    public WeightConverter() {
        this(new WeightUnitProvider());
    }

    public WeightConverter(UnitConversionProvider provider) {
        super(provider);
    }

    // Методы для обратной совместимости (конвертация из килограммов)
    public double toMilligrams(double kilograms) {
        return convert("kg", "mg", kilograms);
    }

    public double toGrams(double kilograms) {
        return convert("kg", "g", kilograms);
    }

    public double toKilograms(double kilograms) {
        return convert("kg", "kg", kilograms);
    }

    public double toCentners(double kilograms) {
        return convert("kg", "cwt", kilograms);
    }

    public double toTons(double kilograms) {
        return convert("kg", "t", kilograms);
    }
}

