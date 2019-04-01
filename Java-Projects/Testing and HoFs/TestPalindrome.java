import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testisPalindrome() {
        assertTrue(palindrome.isPalindrome(null));
        assertTrue(palindrome.isPalindrome("o"));
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("oo"));
        assertTrue(palindrome.isPalindrome("lol"));
        assertTrue(palindrome.isPalindrome("lool"));
        assertTrue(palindrome.isPalindrome("lolol"));
        assertTrue(palindrome.isPalindrome("looool"));
        assertFalse(palindrome.isPalindrome("ar"));
        assertFalse(palindrome.isPalindrome("ary"));
        assertFalse(palindrome.isPalindrome("mary"));
        assertFalse(palindrome.isPalindrome("has"));
        assertFalse(palindrome.isPalindrome("little"));
        assertFalse(palindrome.isPalindrome("sheep"));
        assertFalse(palindrome.isPalindrome("yeah"));
        assertFalse(palindrome.isPalindrome("imdoingcs61binanretreat"));
        assertTrue(palindrome.isPalindrome("%&&%"));
    }


    @Test
    public void testEqualChar() {
        CharacterComparator cc = new OffByOne();
        //assertTrue(palindrome.isPalindrome("a", cc));
        assertTrue(palindrome.isPalindrome(null, cc));
        assertTrue(palindrome.isPalindrome("bdeca", cc));
        assertTrue(palindrome.isPalindrome("", cc));
        assertFalse(palindrome.isPalindrome("xosypy", cc));
        assertFalse(palindrome.isPalindrome("abcdefg", cc));
        assertFalse(palindrome.isPalindrome("snowflakes", cc));
        assertFalse(palindrome.isPalindrome("kungfu", cc));
        assertFalse(palindrome.isPalindrome("wushu", cc));
    }
}
