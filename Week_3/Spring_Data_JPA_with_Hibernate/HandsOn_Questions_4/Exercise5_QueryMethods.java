import java.util.List;

public class Exercise5_QueryMethods {
    public static void main(String[] args) {
        EmployeeQueryRepository repository = new EmployeeQueryRepository();
        List<EmployeeQuery> employees = repository.findByNameContaining("a");
        System.out.println("Employees matching query: " + employees.size());
    }
}

class EmployeeQuery {
    private int id;
    private String name;

    public EmployeeQuery(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class EmployeeQueryRepository {
    public List<EmployeeQuery> findByNameContaining(String keyword) {
        return List.of(new EmployeeQuery(1, "Asha"));
    }
}
