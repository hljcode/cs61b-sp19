import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new offByOne();

    // Your tests go here.
   // Uncomment this class once you've created your CharacterComparator interface and OffByOne class. **/
    public void TestequalChars(){
        assertTrue(offByOne.equalChars('a','b'));
        assertTrue(offByOne.equalChars('b','a'));
        assertFalse(offByOne.equalChars('a','a'));
        assertFalse(offByOne.equalChars('a','z'));
        assertTrue(offByOne.equalChars('%','&'));
        System.out.println("Well Down");
        return ;
    }

    public static void main(String[] args){
        TestOffByOne T=new TestOffByOne();
        T.TestequalChars();
        System.out.println('a'-'A');

    }
}
