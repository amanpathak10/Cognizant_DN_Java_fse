import java.util.ArrayList;
import java.util.List;

public class Exercise3_EmployeeDepartmentRepositories {
    public static void main(String[] args) {
        EmployeeRepository employeeRepository = new EmployeeRepository();
        DepartmentRepository departmentRepository = new DepartmentRepository();

        employeeRepository.save(new EmployeeEntity(1, "Ravi"));
        departmentRepository.save(new DepartmentEntity(1, "HR"));

        System.out.println("Repositories configured for CRUD operations.");
    }
}

class EmployeeEntity {
    private int id;
    private String name;

    public EmployeeEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class DepartmentEntity {
    private int id;
    private String name;

    public DepartmentEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class EmployeeRepository {
    public void save(EmployeeEntity employee) {
        System.out.println("Saved employee: " + employee);
    }
}

class DepartmentRepository {
    public void save(DepartmentEntity department) {
        System.out.println("Saved department: " + department);
    }
}
