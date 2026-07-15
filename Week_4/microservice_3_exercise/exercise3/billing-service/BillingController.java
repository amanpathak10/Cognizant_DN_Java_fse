@RestController
public class BillingController {
    @Autowired
    private BillingRepository billingRepository;
    
    @PostMapping
    public Billing createBilling(@RequestBody Billing billing) {
        return billingRepository.save(billing);
    }
    
    @GetMapping("/{id}")
    public Billing getBilling(@PathVariable Long id) {
        return billingRepository.findById(id).orElse(null);
    }
    
    @GetMapping
    public List<Billing> getAllBillings() {
        return billingRepository.findAll();
    }
}
