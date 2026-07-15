import java.util.ArrayList;
import java.util.List;

public class Exercise4_CrudOperations {
    public static void main(String[] args) {
        EmployeeCrudService service = new EmployeeCrudService();
        service.create(new EmployeeCrud(1, "Nisha"));
        service.read(1);
        service.update(1, "Nisha Updated");
        service.delete(1);
    }
}

class EmployeeCrud {
    private int id;
    private String name;

    public EmployeeCrud(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}

class EmployeeCrudService {
    private final List<EmployeeCrud> employees = new ArrayList<>();

    public void create(EmployeeCrud employee) {
        employees.add(employee);
        System.out.println("Created: " + employee.getName());
    }

    public void read(int id) {
        System.out.println("Read employee with id: " + id);
    }

    public void update(int id, String newName) {
        System.out.println("Updated employee id " + id + " to " + newName);
    }

    public void delete(int id) {
        System.out.println("Deleted employee id: " + id);
    }
}
