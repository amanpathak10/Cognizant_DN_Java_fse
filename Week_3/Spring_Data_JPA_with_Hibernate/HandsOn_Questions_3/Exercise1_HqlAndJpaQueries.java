import java.util.List;

public class Exercise1_HqlAndJpaQueries {
    public static void main(String[] args) {
        EmployeeRepository repository = new EmployeeRepository();
        List<Employee> permanentEmployees = repository.getAllPermanentEmployees();
        System.out.println("Permanent Employees:");
        permanentEmployees.forEach(System.out::println);
    }
}

class Employee {
    private int id;
    private String name;
    private boolean permanent;

    public Employee(int id, String name, boolean permanent) {
        this.id = id;
        this.name = name;
        this.permanent = permanent;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public boolean isPermanent() { return permanent; }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name='" + name + '\'' + ", permanent=" + permanent + '}';
    }
}

class EmployeeRepository {
    public List<Employee> getAllPermanentEmployees() {
        return List.of(new Employee(1, "Asha", true), new Employee(2, "Ravi", true));
    }
}
