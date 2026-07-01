import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ExceptionThrowerTest {

    private final ExceptionThrower thrower = new ExceptionThrower();

    @Test
    void shouldThrowExpectedException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, thrower::throwException);
        org.junit.jupiter.api.Assertions.assertEquals("This is a test exception", exception.getMessage());
    }
}
