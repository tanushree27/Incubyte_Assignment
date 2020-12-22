import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {
    @Test
    void emptyStringTest() {
        StringCalculator stringCalculator = new StringCalculator();

        assertEquals(0, stringCalculator.add(""));
    }
}