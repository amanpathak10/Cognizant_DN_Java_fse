import java.util.HashSet;
import java.util.Set;

public class Exercise4_RelationshipMappingsDemo {
    public static void main(String[] args) {
        EmployeeWithDepartment employee = new EmployeeWithDepartment();
        employee.setName("Ravi");

        DepartmentWithEmployees department = new DepartmentWithEmployees();
        department.setName("Finance");
        employee.setDepartment(department);

        department.setEmployeeList(new HashSet<>(Set.of(employee)));

        System.out.println("Employee: " + employee);
        System.out.println("Department employees: " + department.getEmployeeList());
    }
}

class EmployeeWithDepartment {
    private int id;
    private String name;
    private DepartmentWithEmployees department;

    public void setName(String name) { this.name = name; }
    public void setDepartment(DepartmentWithEmployees department) { this.department = department; }

    @Override
    public String toString() {
        return "EmployeeWithDepartment{name='" + name + '\'' + ", department=" + department + '}';
    }
}

class DepartmentWithEmployees {
    private int id;
    private String name;
    private Set<EmployeeWithDepartment> employeeList = new HashSet<>();

    public void setName(String name) { this.name = name; }
    public void setEmployeeList(Set<EmployeeWithDepartment> employeeList) { this.employeeList = employeeList; }
    public Set<EmployeeWithDepartment> getEmployeeList() { return employeeList; }

    @Override
    public String toString() {
        return "DepartmentWithEmployees{name='" + name + '\'' + '}';
    }
}
