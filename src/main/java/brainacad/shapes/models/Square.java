package brainacad.shapes.models;

public class Square extends Shape {
    private double side;

    public Square() {}
    
    public Square(double side) {
        setSide(side);
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        if (side < 0) {
            throw new IllegalArgumentException("Side cannot be negative");
        }
        this.side = side;
    }

    @Override
    public double calculateArea() {
        if (side <= 0) {
            return 0;
        }
        return side * side;
    }
}
