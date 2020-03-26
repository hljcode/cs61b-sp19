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
        System.out.println(actual);
        assertEquals("persiflage", actual);
    } //Uncomment this class once you've created your Palindrome class. */

    @Test
    public void testisPalindrome(){

        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("A"));

        //"Horse","aaaaab","Aa".etc shouldn't pass the test
        assertFalse(palindrome.isPalindrome("Horse"));
        assertFalse(palindrome.isPalindrome("aaaab"));
        assertFalse(palindrome.isPalindrome("Aa"));
        assertTrue(palindrome.isPalindrome("HOH"));
        assertFalse(palindrome.isPalindrome("Fook"));
        assertTrue(palindrome.isPalindrome("aaaacaaaa"));
        assertTrue(palindrome.isPalindrome("baabbaab"));
        assertTrue(palindrome.isPalindrome("FFFOFFF"));
        System.out.println("Well Down");
    }

    public static void main(String[] args){
        TestPalindrome testPalindrome=new TestPalindrome();
      // testPalindrome.testWordToDeque();
      testPalindrome.testisPalindrome();
    }
}
