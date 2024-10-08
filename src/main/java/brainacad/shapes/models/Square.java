package brainacad.shapes.models;


public class Square extends Shape {
    private double side;

    public Square() {}
    public Square(double side) {
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return side * side;
    }
}
