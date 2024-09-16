package brainacad;



import brainacad.currencies.utils.*;
import brainacad.lengths.utils.LengthConverterTest;
import brainacad.shapes.utils.*;
import brainacad.stringutils.utils.*;

public class App
{
    public static void main(String[] args) {

        ShapeTest shapeTest = new ShapeTest();
            shapeTest.testTriangleArea();
            shapeTest.testRectangleArea();
            shapeTest.testSquareArea();
            shapeTest.testRhombusArea();
/*
        CurrencyConverterTest testCurrencyConverter = new CurrencyConverterTest();
            testCurrencyConverter.testConvertUsdToEur();
            testCurrencyConverter.testConvertEurToGbp();
            testCurrencyConverter.testConvertGbpToJpy();
            testCurrencyConverter.testInvalidCurrency();

        StringUtilsTest testStringUtils = new StringUtilsTest();
            testStringUtils.testCountConsonants();
            testStringUtils.testIsPalindrome();
            testStringUtils.testCountVowels();
            testStringUtils.testCountWordOccurrences();
*/
        LengthConverterTest testLengthConverter = new LengthConverterTest();
            testLengthConverter.testToMillimeters();
            testLengthConverter.testToCentimeters();
            testLengthConverter.testToDecimeters();
            testLengthConverter.testToMeters();
            testLengthConverter.testToKilometers();


    }
}
