@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private OrderService orderService;
    
    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        User user = orderService.getUserById(order.getUserId());
        return orderRepository.save(order);
    }
    
    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        return orderRepository.findById(id).orElse(null);
    }
    
    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
