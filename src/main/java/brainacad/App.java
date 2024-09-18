package brainacad;

import brainacad.currencies.models.CurrencyConverter;
import brainacad.lengths.model.LengthConverter;
import brainacad.shapes.models.Rectangle;
import brainacad.shapes.models.Rhombus;
import brainacad.shapes.models.Square;
import brainacad.shapes.models.Triangle;
import brainacad.stringutils.models.StringUtils;
import brainacad.weights.models.WeightConverter;

public class App
{
    public static void main(String[] args) {

        Rectangle rectangle = new Rectangle();
        rectangle.calculateArea();

        Rhombus rhombus = new Rhombus();
        rhombus.calculateArea();

        Square square = new Square();
        square.calculateArea();

        Triangle triangle = new Triangle();
        triangle.calculateArea();

        CurrencyConverter currencyConverter = new CurrencyConverter();
        currencyConverter.convert("EUR","USD",1);

        LengthConverter lengthConverter = new LengthConverter();
        lengthConverter.toCentimeters(100);

        StringUtils stringUtils = new StringUtils();
        stringUtils.isPalindrome("А роза упала на лапу Азора");

        WeightConverter weightConverter = new WeightConverter();
        weightConverter.toCentners(100);
    }
}
