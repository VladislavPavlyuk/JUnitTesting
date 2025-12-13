package brainacad.shapes.models;

public class Rhombus extends Shape {
    private double diagonal1;
    private double diagonal2;

    public Rhombus(){}

    public Rhombus(double diagonal1, double diagonal2) {
        setDiagonal1(diagonal1);
        setDiagonal2(diagonal2);
    }

    public double getDiagonal1() {
        return diagonal1;
    }

    public void setDiagonal1(double diagonal1) {
        if (diagonal1 < 0) {
            throw new IllegalArgumentException("Diagonal1 cannot be negative");
        }
        this.diagonal1 = diagonal1;
    }

    public double getDiagonal2() {
        return diagonal2;
    }

    public void setDiagonal2(double diagonal2) {
        if (diagonal2 < 0) {
            throw new IllegalArgumentException("Diagonal2 cannot be negative");
        }
        this.diagonal2 = diagonal2;
    }

    @Override
    public double calculateArea() {
        if (diagonal1 <= 0 || diagonal2 <= 0) {
            return 0;
        }
        return 0.5 * diagonal1 * diagonal2;
    }
}
