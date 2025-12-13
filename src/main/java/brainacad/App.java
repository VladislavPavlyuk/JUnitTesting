package brainacad;

import brainacad.currencies.models.CurrencyConverter;
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

        //Задание 5
        WeightConverter weightConverter = new WeightConverter();
        weightConverter.toCentners(100);
    }
}
