package brainacad.services;

import brainacad.currencies.models.CurrencyConverter;
import brainacad.currencies.providers.DefaultExchangeRateProvider;
import brainacad.lengths.model.LengthConverter;
import brainacad.shapes.models.*;
import brainacad.stringutils.models.StringUtils;
import brainacad.weights.models.WeightConverter;

public class DemoService {
    
    public void demonstrateShapes() {
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
    }

    public void demonstrateCurrencyConversion() {
        CurrencyConverter currencyConverter = new CurrencyConverter(new DefaultExchangeRateProvider());
        currencyConverter.convert("EUR", "USD", 1);
        currencyConverter.getExchangeRate("EUR");
        currencyConverter.getSupportedCurrencies();
        currencyConverter.isCurrencySupported("EUR");
    }

    public void demonstrateStringUtils() {
        StringUtils.isPalindrome("А роза упала на лапу Азора");
        StringUtils.countVowels("А роза упала на лапу Азора");
        StringUtils.countConsonants("А роза упала на лапу Азора");
        StringUtils.countWordOccurrences("А роза упала на лапу Азора", "Азора");
    }

    public void demonstrateLengthConversion() {
        LengthConverter lengthConverter = new LengthConverter();
        lengthConverter.toCentimeters(100);
        lengthConverter.toMillimeters(100);
        lengthConverter.toDecimeters(100);
        lengthConverter.toMeters(100);
        lengthConverter.toKilometers(100);
        lengthConverter.convert("mm", "cm", 100);
    }

    public void demonstrateWeightConversion() {
        WeightConverter weightConverter = new WeightConverter();
        weightConverter.toCentners(100);
        weightConverter.toGrams(100);
        weightConverter.toKilograms(100);
        weightConverter.toMilligrams(100);
        weightConverter.convert("mg", "g", 100);
    }
}

