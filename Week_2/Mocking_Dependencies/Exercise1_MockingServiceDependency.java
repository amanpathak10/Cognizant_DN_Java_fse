import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;

@WebMvcTest(UserController.class)
public class Exercise1_MockingServiceDependency {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testGetUserEndpoint() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setName("John Doe");

        when(userService.getUserById(1L)).thenReturn(user);

        mockMvc.perform(get("/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.id").value(1));

        verify(userService, times(1)).getUserById(1L);
    }

    @Test
    public void testGetUserNotFound() throws Exception {
        when(userService.getUserById(999L)).thenReturn(null);

        mockMvc.perform(get("/users/999"))
                .andExpect(status().isOk());

        verify(userService, times(1)).getUserById(999L);
    }

    @Test
    public void testMultipleUserCalls() throws Exception {
        User user1 = new User();
        user1.setId(1L);
        user1.setName("Alice");

        User user2 = new User();
        user2.setId(2L);
        user2.setName("Bob");

        when(userService.getUserById(1L)).thenReturn(user1);
        when(userService.getUserById(2L)).thenReturn(user2);

        mockMvc.perform(get("/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Alice"));

        mockMvc.perform(get("/users/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Bob"));

        verify(userService, times(1)).getUserById(1L);
        verify(userService, times(1)).getUserById(2L);
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

interface UserService {
    User getUserById(Long id);
}

class UserController {
    private UserService userService;
    public ResponseEntity<User> getUser(Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }
}
