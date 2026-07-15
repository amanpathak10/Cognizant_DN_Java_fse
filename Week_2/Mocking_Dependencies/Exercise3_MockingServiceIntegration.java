import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

@SpringBootTest
@AutoConfigureMockMvc
public class Exercise3_MockingServiceIntegration {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    public void testFullIntegrationFlow() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setName("Integration User");

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        mockMvc.perform(get("/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Integration User"))
                .andExpect(jsonPath("$.id").value(1));

        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    public void testIntegrationWithNullResult() throws Exception {
        when(userRepository.findById(999L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/users/999"))
                .andExpect(status().isOk());

        verify(userRepository, times(1)).findById(999L);
    }

    @Test
    public void testIntegrationWithMultipleRequests() throws Exception {
        User user1 = new User();
        user1.setId(1L);
        user1.setName("User One");

        User user2 = new User();
        user2.setId(2L);
        user2.setName("User Two");

        when(userRepository.findById(1L)).thenReturn(Optional.of(user1));
        when(userRepository.findById(2L)).thenReturn(Optional.of(user2));

        mockMvc.perform(get("/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("User One"));

        mockMvc.perform(get("/users/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("User Two"));

        verify(userRepository, times(1)).findById(1L);
        verify(userRepository, times(1)).findById(2L);
    }

    @Test
    public void testIntegrationWithRepositoryException() throws Exception {
        when(userRepository.findById(1L))
                .thenThrow(new RuntimeException("Database error"));

        mockMvc.perform(get("/users/1"))
                .andExpect(status().isInternalServerError());

        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    public void testServiceDirectly() {
        User user = new User();
        user.setId(1L);
        user.setName("Direct Call");

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        User result = userService.getUserById(1L);

        assert result != null;
        assert result.getName().equals("Direct Call");

        verify(userRepository, times(1)).findById(1L);
    }
}

class User {
    private Long id;
    private String name;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}

interface UserRepository {
    Optional<User> findById(Long id);
}

class UserService {
    private UserRepository userRepository;

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}

class UserController {
    private UserService userService;
}
