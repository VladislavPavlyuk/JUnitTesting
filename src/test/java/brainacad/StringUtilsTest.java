package brainacad;

import static org.junit.jupiter.api.Assertions.*;

import brainacad.stringutils.models.StringUtils;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {

    @Test
    public void palindrometest_should_return_true_if_called() {
        String input = "A man a plan a canal Panama";
        boolean actualResult = StringUtils.isPalindrome(input);
        boolean expectedResult = true;
        assertEquals(expectedResult, actualResult);
    }
    
    @Test
    public void palindromeTest_should_return_false_if_called() {
        String input = "Hello World";
        boolean actualResult = StringUtils.isPalindrome(input);
        boolean expectedResult = false;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void palindromeTest_should_return_10_if_called() {
        String input = "A man a plan a canal Panama";
        int actualResult = StringUtils.countVowels(input);
        int expectedResult = 10;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void palindromeTest_should_return_3_if_called() {
        String input = "Hello World";
        int actualResult = StringUtils.countVowels(input);
        int expectedResult = 3;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void palindromeTest_should_return_11_if_called() {
        String input = "A man a plan a canal Panama";
        int actualResult = StringUtils.countConsonants(input);
        int expectedResult = 11;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void palindromeTest_should_return_7_if_called() {
        String input = "Hello World";
        int actualResult = StringUtils.countConsonants(input);
        int expectedResult = 7;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCountConsonants_MixedText() {
        String input = "Привет Hello";
        int actualResult = StringUtils.countConsonants(input);
        int expectedResult = 7;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void palindromeTest_should_return_1_if_called() {
        String text = "A man a plan a canal Panama";
        String word = "canal";
        int actualResult = StringUtils.countWordOccurrences(text, word);
        int expectedResult = 1;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void palindromeTest_should_return_2_if_called() {
        String text = "Hello World, Hello";
        String word = "Hello";
        int actualResult = StringUtils.countWordOccurrences(text, word);
        int expectedResult = 2;
        assertEquals(expectedResult, actualResult);
    }
}

