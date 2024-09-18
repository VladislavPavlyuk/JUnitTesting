package brainacad;

import static org.junit.jupiter.api.Assertions.*;

import brainacad.stringutils.models.StringUtils;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {

    @Test
    public void test_should_return_true_if_called() {
        assertTrue(StringUtils.isPalindrome("A man a plan a canal Panama"));
    }
    @Test
    public void StringUtilsTest_should_return_false_if_called() {
        assertFalse(StringUtils.isPalindrome("Hello World"));
    }

    @Test
    public void StringUtilsTest_should_return_10_if_called() {
        assertEquals(10, StringUtils.countVowels("A man a plan a canal Panama"));
    }

    @Test
    public void StringUtilsTest_should_return_3_if_called() {
        assertEquals(3, StringUtils.countVowels("Hello World"));
    }

    @Test
    public void StringUtilsTest_should_return_11_if_called() {
        assertEquals(11, StringUtils.countConsonants("A man a plan a canal Panama"));
    }

    @Test
    public void StringUtilsTest_should_return_7_if_called() {
        assertEquals(7, StringUtils.countConsonants("Hello World"));
    }

    @Test
    public void StringUtilsTest_should_return_1_if_called() {
        assertEquals(1, StringUtils.countWordOccurrences("A man a plan a canal Panama", "canal"));
    }

    @Test
    public void StringUtilsTest_should_return_2_if_called() {
        assertEquals(2, StringUtils.countWordOccurrences("Hello World, Hello", "Hello"));
    }
}

