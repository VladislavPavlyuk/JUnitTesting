package brainacad.weights.models;

public class WeightConverter {
    
    // Константы для преобразования в килограммы
    private static final double MG_TO_KG = 0.000001;
    private static final double G_TO_KG = 0.001;
    private static final double CWT_TO_KG = 100.0;
    private static final double T_TO_KG = 1000.0;

    // Конвертация из миллиграммов в килограммы
    private double mgToKilograms(double milligrams) {
        return milligrams * MG_TO_KG;
    }

    // Конвертация из граммов в килограммы
    private double gToKilograms(double grams) {
        return grams * G_TO_KG;
    }

    // Конвертация из центнеров в килограммы
    private double cwtToKilograms(double centners) {
        return centners * CWT_TO_KG;
    }

    // Конвертация из тонн в килограммы
    private double tToKilograms(double tons) {
        return tons * T_TO_KG;
    }

    // Универсальный метод конвертации между любыми единицами
    public double convert(String fromUnit, String toUnit, double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Weight cannot be negative");
        }
        if (fromUnit == null || toUnit == null) {
            throw new IllegalArgumentException("Unit names cannot be null");
        }

        String from = fromUnit.toLowerCase().trim();
        String to = toUnit.toLowerCase().trim();

        // Конвертируем в килограммы
        double kilograms;
        switch (from) {
            case "mg":
            case "milligram":
            case "milligrams":
                kilograms = mgToKilograms(value);
                break;
            case "g":
            case "gram":
            case "grams":
                kilograms = gToKilograms(value);
                break;
            case "kg":
            case "kilogram":
            case "kilograms":
                kilograms = value;
                break;
            case "cwt":
            case "centner":
            case "centners":
                kilograms = cwtToKilograms(value);
                break;
            case "t":
            case "ton":
            case "tons":
            case "tonne":
            case "tonnes":
                kilograms = tToKilograms(value);
                break;
            default:
                throw new IllegalArgumentException("Unknown source unit: " + fromUnit);
        }

        // Конвертируем из килограммов в целевую единицу
        switch (to) {
            case "mg":
            case "milligram":
            case "milligrams":
                return kilograms / MG_TO_KG;
            case "g":
            case "gram":
            case "grams":
                return kilograms / G_TO_KG;
            case "kg":
            case "kilogram":
            case "kilograms":
                return kilograms;
            case "cwt":
            case "centner":
            case "centners":
                return kilograms / CWT_TO_KG;
            case "t":
            case "ton":
            case "tons":
            case "tonne":
            case "tonnes":
                return kilograms / T_TO_KG;
            default:
                throw new IllegalArgumentException("Unknown target unit: " + toUnit);
        }
    }

    // Методы для обратной совместимости (конвертация из килограммов)
    public double toMilligrams(double kilograms) {
        if (kilograms < 0) {
            throw new IllegalArgumentException("Weight cannot be negative");
        }
        return kilograms * 1_000_000;
    }

    public double toGrams(double kilograms) {
        if (kilograms < 0) {
            throw new IllegalArgumentException("Weight cannot be negative");
        }
        return kilograms * 1_000;
    }

    public double toKilograms(double kilograms) {
        if (kilograms < 0) {
            throw new IllegalArgumentException("Weight cannot be negative");
        }
        return kilograms;
    }

    public double toCentners(double kilograms) {
        if (kilograms < 0) {
            throw new IllegalArgumentException("Weight cannot be negative");
        }
        return kilograms / 100;
    }

    public double toTons(double kilograms) {
        if (kilograms < 0) {
            throw new IllegalArgumentException("Weight cannot be negative");
        }
        return kilograms / 1_000;
    }
}

