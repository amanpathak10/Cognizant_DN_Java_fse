import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTimeout;

class PerformanceTesterTest {

    private final PerformanceTester tester = new PerformanceTester();

    @Test
    void shouldCompleteWithinTimeout() {
        assertTimeout(java.time.Duration.ofMillis(500), () -> tester.performTask());
    }
}
