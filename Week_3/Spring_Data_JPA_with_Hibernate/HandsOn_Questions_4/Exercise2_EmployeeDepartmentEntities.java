import java.util.ArrayList;
import java.util.List;

public class Exercise2_EmployeeDepartmentEntities {
    public static void main(String[] args) {
        Department department = new Department(1, "Engineering");
        Employee employee = new Employee(101, "Asha", department);
        System.out.println(employee);
    }
}

class Employee {
    private int id;
    private String name;
    private Department department;

    public Employee(int id, String name, Department department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + '\'' + ", department=" + department + '}';
    }
}

class Department {
    private int id;
    private String name;

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{id=" + id + ", name='" + name + '\'' + '}';
    }
}
