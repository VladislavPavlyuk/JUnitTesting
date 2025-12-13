package brainacad.services;

import brainacad.currencies.models.CurrencyConverter;
import brainacad.currencies.providers.DefaultExchangeRateProvider;
import brainacad.lengths.model.LengthConverter;
import brainacad.shapes.models.*;
import brainacad.stringutils.models.StringUtils;
import brainacad.weights.models.WeightConverter;

public class DemoService {
    
    public void demonstrateShapes() {
        System.out.println("=== Демонстрация работы с геометрическими фигурами ===");
        
        Rectangle rectangle = new Rectangle(10, 5);
        double rectangleArea = rectangle.calculateArea();
        double rectangleLength = rectangle.getLength();
        double rectangleWidth = rectangle.getWidth();
        System.out.println("Прямоугольник (длина=" + rectangleLength + ", ширина=" + rectangleWidth + "):");
        System.out.println("  Площадь: " + rectangleArea);
        System.out.println("  Длина: " + rectangleLength);
        System.out.println("  Ширина: " + rectangleWidth);

        Rhombus rhombus = new Rhombus(4, 5);
        double rhombusArea = rhombus.calculateArea();
        System.out.println("\nРомб (диагональ1=4, диагональ2=5):");
        System.out.println("  Площадь: " + rhombusArea);

        Square square = new Square(6);
        double squareArea = square.calculateArea();
        System.out.println("\nКвадрат (сторона=6):");
        System.out.println("  Площадь: " + squareArea);

        Triangle triangle = new Triangle(10, 5);
        double triangleArea = triangle.calculateArea();
        System.out.println("\nТреугольник (основание=10, высота=5):");
        System.out.println("  Площадь: " + triangleArea);
        System.out.println();
    }

    public void demonstrateCurrencyConversion() {
        System.out.println("=== Демонстрация конвертации валют ===");
        
        CurrencyConverter currencyConverter = new CurrencyConverter(new DefaultExchangeRateProvider());
        
        double conversionResult = currencyConverter.convert("EUR", "USD", 1);
        System.out.println("Конвертация 1 EUR в USD: " + conversionResult);

        conversionResult = currencyConverter.convert("USD", "GBP", 1);
        System.out.println("Конвертация 1 USD в GBP: " + conversionResult);

        conversionResult = currencyConverter.convert("GBP", "JPY", 1);
        System.out.println("Конвертация 1 GBP в JPY: " + conversionResult);

        conversionResult = currencyConverter.convert("JPY", "EUR", 1);
        System.out.println("Конвертация 1 JPY в EUR: " + conversionResult);

        conversionResult = currencyConverter.convert("EUR", "CAD", 1);
        System.out.println("Конвертация 1 EUR в CAD: " + conversionResult);

        double exchangeRate = currencyConverter.getExchangeRate("EUR");
        System.out.println("Курс EUR: " + exchangeRate);

        exchangeRate = currencyConverter.getExchangeRate("USD");
        System.out.println("Курс USD: " + exchangeRate);

        exchangeRate = currencyConverter.getExchangeRate("GBP");
        System.out.println("Курс GBP: " + exchangeRate);

        exchangeRate = currencyConverter.getExchangeRate("JPY");
        System.out.println("Курс JPY: " + exchangeRate);

        exchangeRate = currencyConverter.getExchangeRate("CAD");
        System.out.println("Курс CAD: " + exchangeRate);
        
        java.util.Set<String> supportedCurrencies = currencyConverter.getSupportedCurrencies();
        System.out.println("Поддерживаемые валюты: " + supportedCurrencies);
        
        boolean isSupported = currencyConverter.isCurrencySupported("EUR");
        System.out.println("Поддерживается ли EUR: " + isSupported);

        isSupported = currencyConverter.isCurrencySupported("USD");
        System.out.println("Поддерживается ли USD: " + isSupported);

        isSupported = currencyConverter.isCurrencySupported("GBP");
        System.out.println("Поддерживается ли GBP: " + isSupported);

        isSupported = currencyConverter.isCurrencySupported("JPY");
        System.out.println("Поддерживается ли JPY: " + isSupported);

        isSupported = currencyConverter.isCurrencySupported("CAD");
        System.out.println("Поддерживается ли CAD: " + isSupported);
        System.out.println();
    }

    public void demonstrateStringUtils() {
        System.out.println("=== Демонстрация работы со кириллическими строками ===");

        String testString = "А роза упала на лапу Азора";
        boolean isPalindrome = StringUtils.isPalindrome(testString);
        System.out.println("Строка: \"" + testString + "\"");
        System.out.println("  Является палиндромом: " + isPalindrome);
        
        int vowelsCount = StringUtils.countVowels(testString);
        System.out.println("  Количество гласных: " + vowelsCount);
        
        int consonantsCount = StringUtils.countConsonants(testString);
        System.out.println("  Количество согласных: " + consonantsCount);
        
        int wordOccurrences = StringUtils.countWordOccurrences(testString, "Азора");
        System.out.println("  Количество вхождений слова 'Азора': " + wordOccurrences);
        System.out.println();

        System.out.println("=== Demonstrating method with latin string ===");

        testString = "A man, a plan, a canal: Panama!";
        isPalindrome = StringUtils.isPalindrome(testString);
        System.out.println("String: \"" + testString + "\"");
        System.out.println("  Is the palindrome: " + isPalindrome);

        vowelsCount = StringUtils.countVowels(testString);
        System.out.println("  Vowels count: " + vowelsCount);

        consonantsCount = StringUtils.countConsonants(testString);
        System.out.println("  Consonants count: " + consonantsCount);

        wordOccurrences = StringUtils.countWordOccurrences(testString, "Panama");
        System.out.println("  'Panama' word occurrences: " + wordOccurrences);
        System.out.println();
    }

    public void demonstrateLengthConversion() {
        System.out.println("=== Демонстрация конвертации длины ===");
        
        LengthConverter lengthConverter = new LengthConverter();
        
        double centimeters = lengthConverter.toCentimeters(100);
        System.out.println("100 метров в сантиметры: " + centimeters);
        
        double millimeters = lengthConverter.toMillimeters(100);
        System.out.println("100 метров в миллиметры: " + millimeters);
        
        double decimeters = lengthConverter.toDecimeters(100);
        System.out.println("100 метров в дециметры: " + decimeters);
        
        double kilometers = lengthConverter.toKilometers(100);
        System.out.println("100 метров в километры: " + kilometers);
        
        double convertResult = lengthConverter.convert("mm", "cm", 100);
        System.out.println("100 мм в см: " + convertResult);
        System.out.println();
    }

    public void demonstrateWeightConversion() {
        System.out.println("=== Демонстрация конвертации веса ===");
        
        WeightConverter weightConverter = new WeightConverter();
        
        double centners = weightConverter.toCentners(100);
        System.out.println("100 кг в центнеры: " + centners);
        
        double grams = weightConverter.toGrams(100);
        System.out.println("100 кг в граммы: " + grams);
        
        double kilograms = weightConverter.toKilograms(100);
        System.out.println("100 кг в килограммы: " + kilograms);
        
        double milligrams = weightConverter.toMilligrams(100);
        System.out.println("100 кг в миллиграммы: " + milligrams);
        
        double convertResult = weightConverter.convert("mg", "g", 100);
        System.out.println("100 мг в г: " + convertResult);
        System.out.println();
    }
}

