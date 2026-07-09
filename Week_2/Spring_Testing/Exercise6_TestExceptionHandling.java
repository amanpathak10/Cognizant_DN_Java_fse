import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class Exercise6_TestExceptionHandling {

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    public void testGetUserByIdThrowsException() {
        when(userRepository.findById(999L))
                .thenThrow(new RuntimeException("User not found"));

        assertThrows(RuntimeException.class, () -> {
            userService.getUserById(999L);
        });

        verify(userRepository, times(1)).findById(999L);
    }

    @Test
    public void testHandleNullPointerException() {
        when(userRepository.findById(null))
                .thenThrow(new NullPointerException("ID cannot be null"));

        assertThrows(NullPointerException.class, () -> {
            userService.getUserById(null);
        });
    }

    @Test
    public void testGetUserReturnsNullWhenNotFound() {
        when(userRepository.findById(1L)).thenReturn(java.util.Optional.empty());

        User result = userService.getUserById(1L);

        assertNull(result);
    }
}
