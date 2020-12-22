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
}