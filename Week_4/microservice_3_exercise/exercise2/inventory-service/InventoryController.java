@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private InventoryRepository inventoryRepository;
    
    @PostMapping
    public Inventory createInventory(@RequestBody Inventory inventory) {
        return inventoryRepository.save(inventory);
    }
    
    @GetMapping("/{id}")
    public Inventory getInventory(@PathVariable Long id) {
        return inventoryRepository.findById(id).orElse(null);
    }
    
    @GetMapping
    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }
    
    @PutMapping("/{id}")
    public Inventory updateInventory(@PathVariable Long id, @RequestBody Inventory inventory) {
        inventory.setId(id);
        return inventoryRepository.save(inventory);
    }
}
