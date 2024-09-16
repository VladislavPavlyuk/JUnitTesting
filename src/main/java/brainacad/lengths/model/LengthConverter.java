package brainacad.lengths.model;

public class LengthConverter {
    public double toMillimeters(double meters) {
        return meters * 1000;
    }

    public double toCentimeters(double meters) {
        return meters * 100;
    }

    public double toDecimeters(double meters) {
        return meters * 10;
    }

    public double toMeters(double meters) {
        return meters;
    }

    public double toKilometers(double meters) {
        return meters / 1000;
    }
}

