import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public int add(int a, int b) {
        return a + b;
    }
}

public class CalculatorServiceTest {
    @Test
    public void testAdd() {
        CalculatorService service = new CalculatorService();
        int result = service.add(5, 3);
        assertEquals(8, result);
    }

    @Test
    public void testAddNegativeNumbers() {
        CalculatorService service = new CalculatorService();
        int result = service.add(-5, -3);
        assertEquals(-8, result);
    }

    @Test
    public void testAddWithZero() {
        CalculatorService service = new CalculatorService();
        int result = service.add(5, 0);
        assertEquals(5, result);
    }
}
