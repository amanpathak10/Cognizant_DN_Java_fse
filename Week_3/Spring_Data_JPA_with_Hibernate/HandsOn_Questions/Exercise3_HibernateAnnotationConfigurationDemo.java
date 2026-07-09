import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public class Exercise3_HibernateAnnotationConfigurationDemo {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setId(101);
        employee.setName("Asha");
        employee.setDepartment("IT");

        System.out.println("Employee entity ready for persistence:");
        System.out.println(employee);
    }
}

@Entity
@Table(name = "employee")
class Employee {
    @Id
    private int id;

    @Column(name = "employee_name")
    private String name;

    @Column(name = "department")
    private String department;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name='" + name + '\'' + ", department='" + department + '\'' + '}';
    }
}
