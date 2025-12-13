package brainacad.stringutils.models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    // Проверка строки на палиндром
    public static boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }
        if (str.trim().isEmpty()) {
            return true; // Пустая строка считается палиндромом
        }
        String cleanStr = str.replaceAll("[^a-zA-Zа-яА-Я0-9]", "").toLowerCase();
        if (cleanStr.isEmpty()) {
            return true; // Строка без букв/цифр считается палиндромом
        }
        String reversedStr = new StringBuilder(cleanStr).reverse().toString();
        return cleanStr.equals(reversedStr);
    }

    // Проверка количества гласных
    public static int countVowels(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        int count = 0;
        String vowels = "aeiouаеёиоуыэюяAEIOUАЕЁИОУЫЭЮЯ";
        for (char c : str.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    // Проверка количества согласных
    public static int countConsonants(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        int count = 0;
        String consonants = "bcdfghjklmnpqrstvwxyzбвгджзйклмнпрстфхцчшщBCDFGHJKLMNPQRSTVWXYZБВГДЖЗЙКЛМНПРСТФХЦЧШЩ";
        for (char c : str.toCharArray()) {
            if (consonants.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    // Подсчет количества вхождений слова в строку
    public static int countWordOccurrences(String str, String word) {
        if (str == null || word == null) {
            return 0;
        }
        if (str.isEmpty() || word.isEmpty()) {
            return 0;
        }
        // Экранируем специальные символы регулярных выражений
        String escapedWord = Pattern.quote(word);
        Pattern pattern = Pattern.compile("\\b" + escapedWord + "\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }
}

