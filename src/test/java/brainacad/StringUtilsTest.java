package brainacad;

import static org.junit.jupiter.api.Assertions.*;

import brainacad.stringutils.models.StringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TestResultLogger.class)
public class StringUtilsTest {

    @Test
    public void isPalindrome_WhenPalindromeString_ReturnsTrue() {
        String input = "A man a plan a canal Panama";
        boolean actualResult = StringUtils.isPalindrome(input);
        boolean expectedResult = true;
        assertEquals(expectedResult, actualResult);
    }
    
    @Test
    public void isPalindrome_WhenNonPalindromeString_ReturnsFalse() {
        String input = "Hello World";
        boolean actualResult = StringUtils.isPalindrome(input);
        boolean expectedResult = false;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void countVowels_WhenPalindromeString_ReturnsTen() {
        String input = "A man a plan a canal Panama";
        int actualResult = StringUtils.countVowels(input);
        int expectedResult = 10;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void countVowels_WhenNormalString_ReturnsThree() {
        String input = "Hello World";
        int actualResult = StringUtils.countVowels(input);
        int expectedResult = 3;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void countConsonants_WhenPalindromeString_ReturnsEleven() {
        String input = "A man a plan a canal Panama";
        int actualResult = StringUtils.countConsonants(input);
        int expectedResult = 11;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void countConsonants_WhenNormalString_ReturnsSeven() {
        String input = "Hello World";
        int actualResult = StringUtils.countConsonants(input);
        int expectedResult = 7;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void countConsonants_WhenMixedText_ReturnsSeven() {
        String input = "Привет Hello";
        int actualResult = StringUtils.countConsonants(input);
        int expectedResult = 7;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void countWordOccurrences_WhenWordExistsOnce_ReturnsOne() {
        String text = "A man a plan a canal Panama";
        String word = "canal";
        int actualResult = StringUtils.countWordOccurrences(text, word);
        int expectedResult = 1;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void countWordOccurrences_WhenWordExistsTwice_ReturnsTwo() {
        String text = "Hello World, Hello";
        String word = "Hello";
        int actualResult = StringUtils.countWordOccurrences(text, word);
        int expectedResult = 2;
        assertEquals(expectedResult, actualResult);
    }
}

