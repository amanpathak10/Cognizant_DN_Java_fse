import java.util.List;

public class Exercise6_PaginationAndSorting {
    public static void main(String[] args) {
        EmployeeSearchService service = new EmployeeSearchService();
        List<EmployeeSearch> result = service.searchEmployees(0, 5, "name");
        System.out.println("Paginated result size: " + result.size());
    }
}

class EmployeeSearch {
    private int id;
    private String name;

    public EmployeeSearch(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class EmployeeSearchService {
    public List<EmployeeSearch> searchEmployees(int page, int size, String sortBy) {
        return List.of(new EmployeeSearch(1, "Asha"));
    }
}
