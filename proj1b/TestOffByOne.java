import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new offByOne();

    // Your tests go here.
   // Uncomment this class once you've created your CharacterComparator interface and OffByOne class. **/
    @Test
    public void TestequalChars(){
        assertTrue(OffByOne.equalChars('a','b'));
        assertTrue(OffByN.equalChars('b','a'));
        assertFalse(OffByOne.equalChars('a','a'));
        assertFalse(OffByOne.equalChars('a','z'));
        assertTrue(OffByOne.equalChars('%','&'));
       // System.out.println("Well Down");
        return ;
    }

    public static void main(String[] args){
        TestOffByOne T=new TestOffByOne();
        T.TestequalChars();
       // System.out.println('a'-'A');

    }
}
