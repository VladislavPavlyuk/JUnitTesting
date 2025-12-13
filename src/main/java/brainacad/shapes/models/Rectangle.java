package brainacad.shapes.models;

public class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(){}
    
    public Rectangle(double length, double width) {
        setLength(length);
        setWidth(width);
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        if (length < 0) {
            throw new IllegalArgumentException("Length cannot be negative");
        }
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (width < 0) {
            throw new IllegalArgumentException("Width cannot be negative");
        }
        this.width = width;
    }

    @Override
    public double calculateArea() {
        if (length <= 0 || width <= 0) {
            return 0;
        }
        return length * width;
    }
}