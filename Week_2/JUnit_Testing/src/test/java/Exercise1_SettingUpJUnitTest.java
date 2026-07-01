import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Exercise1_SettingUpJUnitTest {

    @Test
    public void sampleJUnitSetupTest() {
        assertEquals("JUnit setup is ready", 4, 2 + 2);
    }
}
