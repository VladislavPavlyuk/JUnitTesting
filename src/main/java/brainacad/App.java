package brainacad;

import brainacad.services.DemoService;

public class App {
    public static void main(String[] args) {
        DemoService demoService = new DemoService();
        
        demoService.demonstrateShapes(); // Задание 1
        demoService.demonstrateCurrencyConversion();    //  Задание 2
        demoService.demonstrateStringUtils();   //  Задание 3
        demoService.demonstrateLengthConversion();  // Задание 4
        demoService.demonstrateWeightConversion();  // Задание 5
    }
}
