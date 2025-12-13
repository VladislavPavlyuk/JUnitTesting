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

        /// Задание 1
        Rectangle rectangle = new Rectangle();
        rectangle.calculateArea();
        rectangle.getLength();
        rectangle.getWidth();

        Rhombus rhombus = new Rhombus();
        rhombus.calculateArea();

        Square square = new Square();
        square.calculateArea();

        Triangle triangle = new Triangle();
        triangle.calculateArea();

        //Задание 2
        CurrencyConverter currencyConverter = new CurrencyConverter();
        currencyConverter.convert("EUR","USD",1);
        currencyConverter.getExchangeRate("EUR");
        currencyConverter.getSupportedCurrencies();
        currencyConverter.isCurrencySupported("EUR");

        //Задание 3
        StringUtils stringUtils = new StringUtils();
        stringUtils.isPalindrome("А роза упала на лапу Азора");
        stringUtils.countVowels("А роза упала на лапу Азора");
        stringUtils.countConsonants("А роза упала на лапу Азора");  
        stringUtils.countWordOccurrences("А роза упала на лапу Азора", "Азора");


        //Задание 4
        LengthConverter lengthConverter = new LengthConverter();
        lengthConverter.toCentimeters(100);
        lengthConverter.toMillimeters(100);
        lengthConverter.toDecimeters(100);
        lengthConverter.toMeters(100);
        lengthConverter.toKilometers(100);
        lengthConverter.convert("mm", "cm", 100);
        lengthConverter.convert("cm", "mm", 100);
        lengthConverter.convert("dm", "mm", 100);
        lengthConverter.convert("m", "mm", 100);
        lengthConverter.convert("km", "mm", 100);
        lengthConverter.convert("mm", "dm", 100);
        lengthConverter.convert("cm", "dm", 100);
        lengthConverter.convert("m", "dm", 100);
        lengthConverter.convert("km", "dm", 100);
        lengthConverter.convert("mm", "m", 100);
        lengthConverter.convert("cm", "m", 100);
        lengthConverter.convert("dm", "m", 100);
        lengthConverter.convert("km", "m", 100);
        lengthConverter.convert("mm", "km", 100);
        lengthConverter.convert("cm", "km", 100);
        lengthConverter.convert("dm", "km", 100);
        lengthConverter.convert("m", "km", 100);

        //Задание 5
        WeightConverter weightConverter = new WeightConverter();
        weightConverter.toCentners(100);
        weightConverter.toGrams(100);
        weightConverter.toKilograms(100);
        weightConverter.toMilligrams(100);
        weightConverter.convert("mg", "g", 100);
        weightConverter.convert("g", "mg", 100);
        weightConverter.convert("kg", "mg", 100);
        weightConverter.convert("kg", "g", 100);
        weightConverter.convert("kg", "mg", 100);
        weightConverter.convert("mg", "kg", 100);
        weightConverter.convert("g", "kg", 100);
    }
}
