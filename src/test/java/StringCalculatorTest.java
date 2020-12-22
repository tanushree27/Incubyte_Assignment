import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {
    @Test
    void emptyStringTest() {
        StringCalculator stringCalculator = new StringCalculator();

        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    void singleNumberStringTest() {
        StringCalculator stringCalculator = new StringCalculator();

        assertEquals(124, stringCalculator.add("124"));
    }

    @Test
    void TwoNumberStringTest() {
        StringCalculator stringCalculator = new StringCalculator();

        assertEquals(200, stringCalculator.add("150,50"));
    }

    @Test
    void AnyNumberStringTest() {
        StringCalculator stringCalculator = new StringCalculator();

        assertEquals(250, stringCalculator.add("150,50,25,25"));
        assertEquals(500, stringCalculator.add("150,50,25,25,150,50,25,25"));
    }

    @Test
    void newLinesBetweenNumbersTest() {
        StringCalculator stringCalculator = new StringCalculator();

        assertEquals(20, stringCalculator.add("1\n2,17"));
        assertEquals(250, stringCalculator.add("150,50\n25,25"));
        assertEquals(500, stringCalculator.add("150,50\n25,25,150,50,25\n25"));
    }

    @Test
    void supportforDelimitersTest() {
        StringCalculator stringCalculator = new StringCalculator();

        assertEquals(200, stringCalculator.add("//@\n150@50"));
        assertEquals(3, stringCalculator.add("//;\n1;2"));
    }

    @Test
    void negativesNotAllowedTest() {
        StringCalculator stringCalculator = new StringCalculator();
        try
        {
            stringCalculator.add("-1,2,3");
            fail("Exception expected.");
        }
        catch(RuntimeException ex)
        {
            assertEquals("Negatives not allowed : -1", ex.getMessage());
        }
    }

    @Test
    void numberGreaterThanThousandIsIgnoredTest() {
        StringCalculator stringCalculator = new StringCalculator();

        assertEquals(1003, stringCalculator.add("1000,2000,3"));
    }
}