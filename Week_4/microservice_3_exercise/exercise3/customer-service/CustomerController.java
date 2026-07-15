@RestController
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;
    
    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }
    
    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return customerRepository.findById(id).orElse(null);
    }
    
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
