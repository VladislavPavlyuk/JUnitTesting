package brainacad.shapes.models;

public class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(){}
    
    public Triangle(double base, double height) {
        setBase(base);
        setHeight(height);
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        if (base < 0) {
            throw new IllegalArgumentException("Base cannot be negative");
        }
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height < 0) {
            throw new IllegalArgumentException("Height cannot be negative");
        }
        this.height = height;
    }

    @Override
    public double calculateArea() {
        if (base <= 0 || height <= 0) {
            return 0;
        }
        return 0.5 * base * height;
    }
}
