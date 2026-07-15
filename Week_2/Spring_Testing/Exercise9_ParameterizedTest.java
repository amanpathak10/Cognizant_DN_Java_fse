import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class Exercise9_ParameterizedTest {

    public int add(int a, int b) {
        return a + b;
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3, 4, 5 })
    public void testAddWithMultipleInputs(int value) {
        int result = add(value, 1);
        assertTrue(result > 0);
    }

    @ParameterizedTest
    @CsvSource({
        "1, 1, 2",
        "2, 3, 5",
        "10, 5, 15",
        "-1, -1, -2",
        "0, 0, 0"
    })
    public void testAddWithMultipleValues(int a, int b, int expected) {
        int result = add(a, b);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @ValueSource(strings = { "John", "Jane", "Bob" })
    public void testUserNames(String name) {
        assertNotNull(name);
        assertTrue(name.length() > 0);
    }
}
