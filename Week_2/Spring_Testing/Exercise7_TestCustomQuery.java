import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class Exercise7_TestCustomQuery {

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    public void testFindByName() {
        User user1 = new User();
        user1.setId(1L);
        user1.setName("John Doe");

        User user2 = new User();
        user2.setId(2L);
        user2.setName("John Smith");

        List<User> users = Arrays.asList(user1, user2);

        when(userRepository.findByName("John")).thenReturn(users);

        List<User> result = userRepository.findByName("John");

        assertEquals(2, result.size());
        assertEquals("John Doe", result.get(0).getName());
        assertEquals("John Smith", result.get(1).getName());

        verify(userRepository, times(1)).findByName("John");
    }

    @Test
    public void testFindByNameReturnsEmpty() {
        when(userRepository.findByName("NonExistent")).thenReturn(Arrays.asList());

        List<User> result = userRepository.findByName("NonExistent");

        assertTrue(result.isEmpty());
        verify(userRepository, times(1)).findByName("NonExistent");
    }
}
