import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Exercise4_AAASetupTeardownTest {

    private StringBuilder message;

    @Before
    public void setUp() {
        message = new StringBuilder("Hello");
    }

    @After
    public void tearDown() {
        message = null;
    }

    @Test
    public void testAppendWithAAA() {
        message.append(" World");
        assertEquals("Hello World", message.toString());
    }

    @Test
    public void testReplaceWithAAA() {
        message.replace(0, message.length(), "JUnit");
        assertEquals("JUnit", message.toString());
    }
}
