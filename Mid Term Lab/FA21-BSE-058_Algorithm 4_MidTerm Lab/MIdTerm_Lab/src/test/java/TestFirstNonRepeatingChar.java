import org.example.FirstNonRepeatingChar;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestFirstNonRepeatingChar {
    @Test
    public void firstNonRepeatingChar() {
        System.out.println("First Non-Repeating Character");
        String str = "swiss";
        char result = FirstNonRepeatingChar.firstNonRepeatingChar(str);
        assertEquals('w', result);
    }
    @Test
    public void stringHavingNoNonRepeatingCharacters(){
        System.out.println("No Non-Repeating Character");
        String str = "aabbcc";
        char result = FirstNonRepeatingChar.firstNonRepeatingChar(str);
        assertEquals('\0', result);
    }
    @Test
    public void emptyString() {
        System.out.println("Empty String");
        String str = "";
        char result = FirstNonRepeatingChar.firstNonRepeatingChar(str);
        assertEquals('\0', result);
    }
}
