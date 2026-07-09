import java.util.ArrayList;
import java.util.List;

public class Exercise4_CriteriaQueryDemo {
    public static void main(String[] args) {
        CriteriaQueryService service = new CriteriaQueryService();
        List<String> filters = new ArrayList<>();
        filters.add("laptop");
        filters.add("8GB RAM");

        List<Product> products = service.searchProducts(filters);
        System.out.println("Products matching criteria:");
        products.forEach(System.out::println);
    }
}

class Product {
    private String name;

    public Product(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + '\'' + '}';
    }
}

class CriteriaQueryService {
    public List<Product> searchProducts(List<String> filters) {
        List<Product> result = new ArrayList<>();
        result.add(new Product("Laptop"));
        return result;
    }
}
