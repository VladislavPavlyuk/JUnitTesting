package brainacad.stringutils.utils;

import static org.junit.jupiter.api.Assertions.*;
import brainacad.stringutils.models.StringUtils;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {

    @Test
    public void testIsPalindrome() {
        assertTrue(StringUtils.isPalindrome("A man a plan a canal Panama"));
        assertFalse(StringUtils.isPalindrome("Hello World"));
    }

    @Test
    public void testCountVowels() {
        assertEquals(10, StringUtils.countVowels("A man a plan a canal Panama"));
        assertEquals(3, StringUtils.countVowels("Hello World"));
    }

    @Test
    public void testCountConsonants() {
        assertEquals(11, StringUtils.countConsonants("A man a plan a canal Panama"));
        assertEquals(7, StringUtils.countConsonants("Hello World"));
    }


    @Test
    public void testCountWordOccurrences() {
        assertEquals(2, StringUtils.countWordOccurrences("Hello World, Hello", "Hello"));
        assertEquals(1, StringUtils.countWordOccurrences("A man a plan a canal Panama", "canal"));
    }
}

