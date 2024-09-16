package brainacad.weights.models;

public class WeightConverter {
    public double toMilligrams(double kilograms) {
        return kilograms * 1_000_000;
    }

    public double toGrams(double kilograms) {
        return kilograms * 1_000;
    }

    public double toKilograms(double kilograms) {
        return kilograms;
    }

    public double toCentners(double kilograms) {
        return kilograms / 100;
    }

    public double toTons(double kilograms) {
        return kilograms / 1_000;
    }
}

