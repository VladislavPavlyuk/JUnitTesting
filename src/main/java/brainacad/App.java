package brainacad;

import brainacad.services.DemoService;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class App {
    public static void main(String[] args) {
        // Установка кодировки UTF-8 для корректного отображения кириллицы
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            System.err.println("Ошибка установки кодировки UTF-8: " + e.getMessage());
        }
        
        DemoService demoService = new DemoService();
        
        demoService.demonstrateShapes(); // Задание 1
        demoService.demonstrateCurrencyConversion();    //  Задание 2
        demoService.demonstrateStringUtils();   //  Задание 3
        demoService.demonstrateLengthConversion();  // Задание 4
        demoService.demonstrateWeightConversion();  // Задание 5
    }
}
