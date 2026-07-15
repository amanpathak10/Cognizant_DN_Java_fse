@Service
public class OrderService {
    @Autowired
    private WebClient.Builder webClientBuilder;
    
    public User getUserById(Long userId) {
        return webClientBuilder.build()
            .get()
            .uri("http://localhost:8081/users/" + userId)
            .retrieve()
            .bodyToMono(User.class)
            .block();
    }
}
