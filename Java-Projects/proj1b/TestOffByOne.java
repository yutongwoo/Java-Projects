import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testOffByOne() {
        assertTrue(offByOne.equalChars('a', 'b'));
        assertTrue(offByOne.equalChars('A', 'B'));
        assertFalse(offByOne.equalChars('a', 'B'));
        assertFalse(offByOne.equalChars('a', 'f'));
        assertFalse(offByOne.equalChars('C', '*'));
        assertFalse(offByOne.equalChars('$', '&'));
        assertFalse(offByOne.equalChars('(', '3'));
    }
    // Your tests go here.
}
