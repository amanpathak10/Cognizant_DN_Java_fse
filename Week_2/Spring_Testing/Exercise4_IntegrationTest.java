import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class Exercise4_IntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFullFlowFromControllerToDatabase() throws Exception {
        User user = new User();
        user.setName("Integration Test User");
        userRepository.save(user);

        mockMvc.perform(get("/users/" + user.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Integration Test User"));
    }

    @Test
    public void testCreateAndRetrieveUser() throws Exception {
        String userJson = "{\"name\": \"New User\"}";

        mockMvc.perform(post("/users")
                .contentType("application/json")
                .content(userJson))
                .andExpect(status().isOk());
    }
}
