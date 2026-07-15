import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;

@WebMvcTest(UserController.class)
public class Exercise5_TestPostEndpoint {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testCreateUser() throws Exception {
        User newUser = new User();
        newUser.setName("New User");

        when(userService.saveUser(newUser)).thenReturn(newUser);

        String userJson = "{\"name\": \"New User\"}";

        mockMvc.perform(post("/users")
                .contentType("application/json")
                .content(userJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("New User"));

        verify(userService, times(1)).saveUser(newUser);
    }

    @Test
    public void testCreateUserWithValidation() throws Exception {
        String userJson = "{\"name\": \"Valid User\"}";

        mockMvc.perform(post("/users")
                .contentType("application/json")
                .content(userJson))
                .andExpect(status().isOk());
    }
}
