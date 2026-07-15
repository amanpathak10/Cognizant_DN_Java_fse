@RestController
public class PaymentController {
    @Autowired
    private WebClient.Builder webClientBuilder;
    
    @CircuitBreaker(name = "paymentService", fallbackMethod = "paymentFallback")
    @Retry(name = "paymentService")
    @GetMapping("/payment/{amount}")
    public String processPayment(@PathVariable Double amount) {
        String response = webClientBuilder.build()
            .get()
            .uri("http://slow-third-party-api.com/process?amount=" + amount)
            .retrieve()
            .bodyToMono(String.class)
            .block();
        return response;
    }
    
    public String paymentFallback(Double amount, Exception e) {
        System.out.println("Fallback triggered for payment: " + e.getMessage());
        return "Payment processing failed. Please try again later.";
    }
}
