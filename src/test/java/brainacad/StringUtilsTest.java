package brainacad;

import static org.junit.jupiter.api.Assertions.*;

import brainacad.stringutils.models.StringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты для работы со строками")
public class StringUtilsTest {

    // ========== ПРОВЕРКА НА ПАЛИНДРОМ ==========

    @Test
    @DisplayName("Палиндром: классический пример на английском")
    public void testIsPalindrome_ClassicEnglish() {
        assertTrue(StringUtils.isPalindrome("A man a plan a canal Panama"));
    }

    @Test
    @DisplayName("Палиндром: простая строка")
    public void testIsPalindrome_Simple() {
        assertTrue(StringUtils.isPalindrome("racecar"));
    }

    @Test
    @DisplayName("Палиндром: одно слово")
    public void testIsPalindrome_SingleWord() {
        assertTrue(StringUtils.isPalindrome("radar"));
    }

    @Test
    @DisplayName("Палиндром: с цифрами")
    public void testIsPalindrome_WithNumbers() {
        assertTrue(StringUtils.isPalindrome("12321"));
    }

    @Test
    @DisplayName("Палиндром: с пробелами и знаками препинания")
    public void testIsPalindrome_WithPunctuation() {
        assertTrue(StringUtils.isPalindrome("A Santa at NASA"));
    }

    @Test
    @DisplayName("Палиндром: русский текст")
    public void testIsPalindrome_Russian() {
        assertTrue(StringUtils.isPalindrome("А роза упала на лапу Азора"));
    }

    @Test
    @DisplayName("Палиндром: не палиндром")
    public void testIsPalindrome_NotPalindrome() {
        assertFalse(StringUtils.isPalindrome("Hello World"));
    }

    @Test
    @DisplayName("Палиндром: пустая строка")
    public void testIsPalindrome_EmptyString() {
        assertTrue(StringUtils.isPalindrome(""));
    }

    @Test
    @DisplayName("Палиндром: только пробелы")
    public void testIsPalindrome_OnlySpaces() {
        assertTrue(StringUtils.isPalindrome("   "));
    }

    @Test
    @DisplayName("Палиндром: один символ")
    public void testIsPalindrome_SingleCharacter() {
        assertTrue(StringUtils.isPalindrome("a"));
    }

    @Test
    @DisplayName("Палиндром: два одинаковых символа")
    public void testIsPalindrome_TwoSameCharacters() {
        assertTrue(StringUtils.isPalindrome("aa"));
    }

    @Test
    @DisplayName("Палиндром: два разных символа")
    public void testIsPalindrome_TwoDifferentCharacters() {
        assertFalse(StringUtils.isPalindrome("ab"));
    }

    @Test
    @DisplayName("Палиндром: null значение")
    public void testIsPalindrome_Null() {
        assertFalse(StringUtils.isPalindrome(null));
    }

    @Test
    @DisplayName("Палиндром: только знаки препинания")
    public void testIsPalindrome_OnlyPunctuation() {
        assertTrue(StringUtils.isPalindrome("!!!"));
    }

    @Test
    @DisplayName("Палиндром: регистронезависимость")
    public void testIsPalindrome_CaseInsensitive() {
        assertTrue(StringUtils.isPalindrome("RaceCar"));
    }

    // ========== ПОДСЧЕТ ГЛАСНЫХ ==========

    @Test
    @DisplayName("Гласные: классический пример")
    public void testCountVowels_ClassicExample() {
        assertEquals(10, StringUtils.countVowels("A man a plan a canal Panama"));
    }

    @Test
    @DisplayName("Гласные: простая строка")
    public void testCountVowels_SimpleString() {
        assertEquals(3, StringUtils.countVowels("Hello World"));
    }

    @Test
    @DisplayName("Гласные: только гласные")
    public void testCountVowels_OnlyVowels() {
        assertEquals(5, StringUtils.countVowels("aeiou"));
    }

    @Test
    @DisplayName("Гласные: только согласные")
    public void testCountVowels_OnlyConsonants() {
        assertEquals(0, StringUtils.countVowels("bcdfg"));
    }

    @Test
    @DisplayName("Гласные: пустая строка")
    public void testCountVowels_EmptyString() {
        assertEquals(0, StringUtils.countVowels(""));
    }

    @Test
    @DisplayName("Гласные: null значение")
    public void testCountVowels_Null() {
        assertEquals(0, StringUtils.countVowels(null));
    }

    @Test
    @DisplayName("Гласные: с цифрами и знаками")
    public void testCountVowels_WithNumbersAndPunctuation() {
        assertEquals(2, StringUtils.countVowels("Hello123!@#"));
    }

    @Test
    @DisplayName("Гласные: русские гласные")
    public void testCountVowels_RussianVowels() {
        assertEquals(5, StringUtils.countVowels("аеёио"));
    }

    @Test
    @DisplayName("Гласные: смешанный текст")
    public void testCountVowels_MixedText() {
        assertEquals(4, StringUtils.countVowels("Привет Hello"));
    }

    @Test
    @DisplayName("Гласные: заглавные и строчные")
    public void testCountVowels_MixedCase() {
        assertEquals(5, StringUtils.countVowels("AEiou"));
    }

    @Test
    @DisplayName("Гласные: один символ - гласная")
    public void testCountVowels_SingleVowel() {
        assertEquals(1, StringUtils.countVowels("a"));
    }

    @Test
    @DisplayName("Гласные: один символ - согласная")
    public void testCountVowels_SingleConsonant() {
        assertEquals(0, StringUtils.countVowels("b"));
    }

    // ========== ПОДСЧЕТ СОГЛАСНЫХ ==========

    @Test
    @DisplayName("Согласные: классический пример")
    public void testCountConsonants_ClassicExample() {
        assertEquals(11, StringUtils.countConsonants("A man a plan a canal Panama"));
    }

    @Test
    @DisplayName("Согласные: простая строка")
    public void testCountConsonants_SimpleString() {
        assertEquals(7, StringUtils.countConsonants("Hello World"));
    }

    @Test
    @DisplayName("Согласные: только согласные")
    public void testCountConsonants_OnlyConsonants() {
        assertEquals(5, StringUtils.countConsonants("bcdfg"));
    }

    @Test
    @DisplayName("Согласные: только гласные")
    public void testCountConsonants_OnlyVowels() {
        assertEquals(0, StringUtils.countConsonants("aeiou"));
    }

    @Test
    @DisplayName("Согласные: пустая строка")
    public void testCountConsonants_EmptyString() {
        assertEquals(0, StringUtils.countConsonants(""));
    }

    @Test
    @DisplayName("Согласные: null значение")
    public void testCountConsonants_Null() {
        assertEquals(0, StringUtils.countConsonants(null));
    }

    @Test
    @DisplayName("Согласные: с цифрами и знаками")
    public void testCountConsonants_WithNumbersAndPunctuation() {
        assertEquals(3, StringUtils.countConsonants("Hello123!@#"));
    }

    @Test
    @DisplayName("Согласные: русские согласные")
    public void testCountConsonants_RussianConsonants() {
        assertEquals(5, StringUtils.countConsonants("бвгдж"));
    }

    @Test
    @DisplayName("Согласные: смешанный текст")
    public void testCountConsonants_MixedText() {
        assertEquals(8, StringUtils.countConsonants("Привет Hello"));
    }

    @Test
    @DisplayName("Согласные: заглавные и строчные")
    public void testCountConsonants_MixedCase() {
        assertEquals(3, StringUtils.countConsonants("BCd"));
    }

    @Test
    @DisplayName("Согласные: один символ - согласная")
    public void testCountConsonants_SingleConsonant() {
        assertEquals(1, StringUtils.countConsonants("b"));
    }

    @Test
    @DisplayName("Согласные: один символ - гласная")
    public void testCountConsonants_SingleVowel() {
        assertEquals(0, StringUtils.countConsonants("a"));
    }

    // ========== ПОДСЧЕТ ВХОЖДЕНИЙ СЛОВА ==========

    @Test
    @DisplayName("Вхождения слова: классический пример")
    public void testCountWordOccurrences_ClassicExample() {
        assertEquals(1, StringUtils.countWordOccurrences("A man a plan a canal Panama", "canal"));
    }

    @Test
    @DisplayName("Вхождения слова: несколько вхождений")
    public void testCountWordOccurrences_MultipleOccurrences() {
        assertEquals(2, StringUtils.countWordOccurrences("Hello World, Hello", "Hello"));
    }

    @Test
    @DisplayName("Вхождения слова: регистронезависимость")
    public void testCountWordOccurrences_CaseInsensitive() {
        assertEquals(3, StringUtils.countWordOccurrences("Hello hello HELLO", "hello"));
    }

    @Test
    @DisplayName("Вхождения слова: слово в начале строки")
    public void testCountWordOccurrences_AtStart() {
        assertEquals(1, StringUtils.countWordOccurrences("Hello world", "Hello"));
    }

    @Test
    @DisplayName("Вхождения слова: слово в конце строки")
    public void testCountWordOccurrences_AtEnd() {
        assertEquals(1, StringUtils.countWordOccurrences("Hello world", "world"));
    }

    @Test
    @DisplayName("Вхождения слова: слово в середине")
    public void testCountWordOccurrences_InMiddle() {
        assertEquals(1, StringUtils.countWordOccurrences("Hello beautiful world", "beautiful"));
    }

    @Test
    @DisplayName("Вхождения слова: нет вхождений")
    public void testCountWordOccurrences_NoOccurrences() {
        assertEquals(0, StringUtils.countWordOccurrences("Hello world", "test"));
    }

    @Test
    @DisplayName("Вхождения слова: пустая строка")
    public void testCountWordOccurrences_EmptyString() {
        assertEquals(0, StringUtils.countWordOccurrences("", "test"));
    }

    @Test
    @DisplayName("Вхождения слова: null строка")
    public void testCountWordOccurrences_NullString() {
        assertEquals(0, StringUtils.countWordOccurrences(null, "test"));
    }

    @Test
    @DisplayName("Вхождения слова: null слово")
    public void testCountWordOccurrences_NullWord() {
        assertEquals(0, StringUtils.countWordOccurrences("Hello world", null));
    }

    @Test
    @DisplayName("Вхождения слова: пустое слово")
    public void testCountWordOccurrences_EmptyWord() {
        assertEquals(0, StringUtils.countWordOccurrences("Hello world", ""));
    }

    @Test
    @DisplayName("Вхождения слова: слово как часть другого слова не считается")
    public void testCountWordOccurrences_NotPartOfWord() {
        assertEquals(1, StringUtils.countWordOccurrences("Hello helloworld", "hello"));
    }

    @Test
    @DisplayName("Вхождения слова: со знаками препинания")
    public void testCountWordOccurrences_WithPunctuation() {
        assertEquals(2, StringUtils.countWordOccurrences("Hello, world! Hello.", "Hello"));
    }

    @Test
    @DisplayName("Вхождения слова: русское слово")
    public void testCountWordOccurrences_RussianWord() {
        assertEquals(2, StringUtils.countWordOccurrences("Привет мир, привет", "привет"));
    }

    @Test
    @DisplayName("Вхождения слова: специальные символы в слове")
    public void testCountWordOccurrences_SpecialCharacters() {
        assertEquals(2, StringUtils.countWordOccurrences("test-test test", "test-test"));
    }

    @Test
    @DisplayName("Вхождения слова: только одно слово в строке")
    public void testCountWordOccurrences_SingleWord() {
        assertEquals(1, StringUtils.countWordOccurrences("Hello", "Hello"));
    }

    @Test
    @DisplayName("Вхождения слова: повторяющиеся слова подряд")
    public void testCountWordOccurrences_ConsecutiveWords() {
        assertEquals(3, StringUtils.countWordOccurrences("test test test", "test"));
    }

    @Test
    @DisplayName("Вхождения слова: слово с цифрами")
    public void testCountWordOccurrences_WordWithNumbers() {
        assertEquals(2, StringUtils.countWordOccurrences("test123 test123", "test123"));
    }

    // ========== ИНТЕГРАЦИОННЫЕ ТЕСТЫ ==========

    @Test
    @DisplayName("Интеграционный тест: полный анализ строки")
    public void testIntegration_FullAnalysis() {
        String text = "A man a plan a canal Panama";
        assertTrue(StringUtils.isPalindrome(text));
        assertEquals(10, StringUtils.countVowels(text));
        assertEquals(11, StringUtils.countConsonants(text));
        assertEquals(1, StringUtils.countWordOccurrences(text, "canal"));
    }

    @Test
    @DisplayName("Интеграционный тест: проверка всех методов на одной строке")
    public void testIntegration_AllMethods() {
        String text = "Hello world hello";
        assertFalse(StringUtils.isPalindrome(text));
        assertEquals(5, StringUtils.countVowels(text));
        assertEquals(8, StringUtils.countConsonants(text));
        assertEquals(2, StringUtils.countWordOccurrences(text, "hello"));
    }
}

