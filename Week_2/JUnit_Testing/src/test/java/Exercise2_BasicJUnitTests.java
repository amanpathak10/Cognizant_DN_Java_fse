import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Exercise2_BasicJUnitTests {

    private final Calculator calculator = new Calculator();

    @Test
    public void addReturnsSum() {
        assertEquals(8, calculator.add(3, 5));
    }

    @Test
    public void multiplyReturnsProduct() {
        assertEquals(12, calculator.multiply(3, 4));
    }

    static class Calculator {
        int add(int a, int b) {
            return a + b;
        }

        int multiply(int a, int b) {
            return a * b;
        }
    }
}
