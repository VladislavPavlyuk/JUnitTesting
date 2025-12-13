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
        
        try {
            Rectangle rectangle = new Rectangle(10, 5);
            double rectangleArea = rectangle.calculateArea();
            double rectangleLength = rectangle.getLength();
            double rectangleWidth = rectangle.getWidth();
            System.out.println("Прямоугольник (длина=" + rectangleLength + ", ширина=" + rectangleWidth + "):");
            System.out.println("  Площадь: " + rectangleArea);
            System.out.println("  Длина: " + rectangleLength);
            System.out.println("  Ширина: " + rectangleWidth);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка создания прямоугольника: " + e.getMessage());
        }

        try {
            // Демонстрация защиты от неправильных параметров
            @SuppressWarnings("unused")
            Rectangle invalidRectangle = new Rectangle(-10, 5);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка создания прямоугольника с отрицательной длиной: " + e.getMessage());
        }

        try {
            Rhombus rhombus = new Rhombus(4, 5);
            double rhombusArea = rhombus.calculateArea();
            System.out.println("\nРомб (диагональ1=4, диагональ2=5):");
            System.out.println("  Площадь: " + rhombusArea);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка создания ромба: " + e.getMessage());
        }

        try {
            Square square = new Square(6);
            double squareArea = square.calculateArea();
            System.out.println("\nКвадрат (сторона=6):");
            System.out.println("  Площадь: " + squareArea);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка создания квадрата: " + e.getMessage());
        }

        try {
            // Демонстрация защиты от неправильных параметров
            @SuppressWarnings("unused")
            Square invalidSquare = new Square(-6);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка создания квадрата с отрицательной стороной: " + e.getMessage());
        }

        try {
            Triangle triangle = new Triangle(10, 5);
            double triangleArea = triangle.calculateArea();
            System.out.println("\nТреугольник (основание=10, высота=5):");
            System.out.println("  Площадь: " + triangleArea);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка создания треугольника: " + e.getMessage());
        }
        System.out.println();
    }

    public void demonstrateCurrencyConversion() {
        System.out.println("=== Демонстрация конвертации валют ===");
        
        CurrencyConverter currencyConverter = new CurrencyConverter(new DefaultExchangeRateProvider());
        
        try {
            double conversionResult = currencyConverter.convert("EUR", "USD", 1);
            System.out.println("Конвертация 1 EUR в USD: " + conversionResult);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка конвертации EUR -> USD: " + e.getMessage());
        }

        try {
            double conversionResult = currencyConverter.convert("USD", "GBP", 1);
            System.out.println("Конвертация 1 USD в GBP: " + conversionResult);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка конвертации USD -> GBP: " + e.getMessage());
        }

        try {
            double conversionResult = currencyConverter.convert("GBP", "JPY", 1);
            System.out.println("Конвертация 1 GBP в JPY: " + conversionResult);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка конвертации GBP -> JPY: " + e.getMessage());
        }

        try {
            double conversionResult = currencyConverter.convert("JPY", "EUR", 1);
            System.out.println("Конвертация 1 JPY в EUR: " + conversionResult);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка конвертации JPY -> EUR: " + e.getMessage());
        }

        try {
            double conversionResult = currencyConverter.convert("EUR", "CAD", 1);
            System.out.println("Конвертация 1 EUR в CAD: " + conversionResult);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка конвертации EUR -> CAD: " + e.getMessage());
        }

        try {
            double exchangeRate = currencyConverter.getExchangeRate("EUR");
            System.out.println("Курс EUR: " + exchangeRate);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка получения курса EUR: " + e.getMessage());
        }

        try {
            double exchangeRate = currencyConverter.getExchangeRate("USD");
            System.out.println("Курс USD: " + exchangeRate);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка получения курса USD: " + e.getMessage());
        }

        try {
            double exchangeRate = currencyConverter.getExchangeRate("GBP");
            System.out.println("Курс GBP: " + exchangeRate);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка получения курса GBP: " + e.getMessage());
        }

        try {
            double exchangeRate = currencyConverter.getExchangeRate("JPY");
            System.out.println("Курс JPY: " + exchangeRate);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка получения курса JPY: " + e.getMessage());
        }

        try {
            double exchangeRate = currencyConverter.getExchangeRate("CAD");
            System.out.println("Курс CAD: " + exchangeRate);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка получения курса CAD: " + e.getMessage());
        }
        
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
        
        try {
            double centimeters = lengthConverter.toCentimeters(100);
            System.out.println("100 метров в сантиметры: " + centimeters);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка конвертации метров в сантиметры: " + e.getMessage());
        }
        
        try {
            double millimeters = lengthConverter.toMillimeters(100);
            System.out.println("100 метров в миллиметры: " + millimeters);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка конвертации метров в миллиметры: " + e.getMessage());
        }
        
        try {
            double decimeters = lengthConverter.toDecimeters(100);
            System.out.println("100 метров в дециметры: " + decimeters);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка конвертации метров в дециметры: " + e.getMessage());
        }
        
        try {
            double kilometers = lengthConverter.toKilometers(100);
            System.out.println("100 метров в километры: " + kilometers);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка конвертации метров в километры: " + e.getMessage());
        }
        
        try {
            double convertResult = lengthConverter.convert("mm", "cm", 100);
            System.out.println("100 мм в см: " + convertResult);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка конвертации мм в см: " + e.getMessage());
        }
        
        try {
            double convertResult = lengthConverter.convert("unknown", "cm", 100);
            System.out.println("100 unknown в см: " + convertResult);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка конвертации unknown в см: " + e.getMessage());
        }
        
        try {
            double convertResult = lengthConverter.convert("mm", "cm", -100);
            System.out.println("-100 мм в см: " + convertResult);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка конвертации отрицательного значения: " + e.getMessage());
        }
        
        System.out.println();
    }

    public void demonstrateWeightConversion() {
        System.out.println("=== Демонстрация конвертации веса ===");
        
        WeightConverter weightConverter = new WeightConverter();
        
        try {
            double centners = weightConverter.toCentners(100);
            System.out.println("100 кг в центнеры: " + centners);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка конвертации кг в центнеры: " + e.getMessage());
        }
        
        try {
            double grams = weightConverter.toGrams(100);
            System.out.println("100 кг в граммы: " + grams);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка конвертации кг в граммы: " + e.getMessage());
        }
        
        try {
            double kilograms = weightConverter.toKilograms(100);
            System.out.println("100 кг в килограммы: " + kilograms);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка конвертации кг в килограммы: " + e.getMessage());
        }
        
        try {
            double milligrams = weightConverter.toMilligrams(100);
            System.out.println("100 кг в миллиграммы: " + milligrams);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка конвертации кг в миллиграммы: " + e.getMessage());
        }
        
        try {
            double convertResult = weightConverter.convert("mg", "g", 100);
            System.out.println("100 мг в г: " + convertResult);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка конвертации мг в г: " + e.getMessage());
        }
        
        try {
            double convertResult = weightConverter.convert("unknown", "g", 100);
            System.out.println("100 unknown в г: " + convertResult);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка конвертации unknown в г: " + e.getMessage());
        }
        
        try {
            double convertResult = weightConverter.convert("mg", "g", -100);
            System.out.println("-100 мг в г: " + convertResult);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка конвертации отрицательного значения: " + e.getMessage());
        }
        
        System.out.println();
    }
}

