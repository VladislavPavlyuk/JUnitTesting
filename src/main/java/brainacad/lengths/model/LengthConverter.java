package brainacad.lengths.model;

public class LengthConverter {
    
    // Константы для преобразования в метры
    private static final double MM_TO_M = 0.001;
    private static final double CM_TO_M = 0.01;
    private static final double DM_TO_M = 0.1;
    private static final double KM_TO_M = 1000.0;

    // Конвертация из миллиметров в метры
    private double mmToMeters(double millimeters) {
        return millimeters * MM_TO_M;
    }

    // Конвертация из сантиметров в метры
    private double cmToMeters(double centimeters) {
        return centimeters * CM_TO_M;
    }

    // Конвертация из дециметров в метры
    private double dmToMeters(double decimeters) {
        return decimeters * DM_TO_M;
    }

    // Конвертация из километров в метры
    private double kmToMeters(double kilometers) {
        return kilometers * KM_TO_M;
    }

    // Универсальный метод конвертации между любыми единицами
    public double convert(String fromUnit, String toUnit, double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Length cannot be negative");
        }
        if (fromUnit == null || toUnit == null) {
            throw new IllegalArgumentException("Unit names cannot be null");
        }

        String from = fromUnit.toLowerCase().trim();
        String to = toUnit.toLowerCase().trim();

        // Конвертируем в метры
        double meters;
        switch (from) {
            case "mm":
            case "millimeter":
            case "millimeters":
                meters = mmToMeters(value);
                break;
            case "cm":
            case "centimeter":
            case "centimeters":
                meters = cmToMeters(value);
                break;
            case "dm":
            case "decimeter":
            case "decimeters":
                meters = dmToMeters(value);
                break;
            case "m":
            case "meter":
            case "meters":
                meters = value;
                break;
            case "km":
            case "kilometer":
            case "kilometers":
                meters = kmToMeters(value);
                break;
            default:
                throw new IllegalArgumentException("Unknown source unit: " + fromUnit);
        }

        // Конвертируем из метров в целевую единицу
        switch (to) {
            case "mm":
            case "millimeter":
            case "millimeters":
                return meters / MM_TO_M;
            case "cm":
            case "centimeter":
            case "centimeters":
                return meters / CM_TO_M;
            case "dm":
            case "decimeter":
            case "decimeters":
                return meters / DM_TO_M;
            case "m":
            case "meter":
            case "meters":
                return meters;
            case "km":
            case "kilometer":
            case "kilometers":
                return meters / KM_TO_M;
            default:
                throw new IllegalArgumentException("Unknown target unit: " + toUnit);
        }
    }

    // Методы для обратной совместимости (конвертация из метров)
    public double toMillimeters(double meters) {
        if (meters < 0) {
            throw new IllegalArgumentException("Length cannot be negative");
        }
        return meters * 1000;
    }

    public double toCentimeters(double meters) {
        if (meters < 0) {
            throw new IllegalArgumentException("Length cannot be negative");
        }
        return meters * 100;
    }

    public double toDecimeters(double meters) {
        if (meters < 0) {
            throw new IllegalArgumentException("Length cannot be negative");
        }
        return meters * 10;
    }

    public double toMeters(double meters) {
        if (meters < 0) {
            throw new IllegalArgumentException("Length cannot be negative");
        }
        return meters;
    }

    public double toKilometers(double meters) {
        if (meters < 0) {
            throw new IllegalArgumentException("Length cannot be negative");
        }
        return meters / 1000;
    }
}

