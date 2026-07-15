import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Exercise3_PayrollMappingDemo {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setName("Asha");
        employee.setSalary(50000.0);
        employee.setPermanent(true);
        employee.setDateOfBirth(new Date());

        Department department = new Department();
        department.setName("IT");
        employee.setDepartment(department);

        Skill skill = new Skill();
        skill.setName("Java");
        employee.setSkillList(new HashSet<>(Set.of(skill)));

        System.out.println(employee);
    }
}

class Employee {
    private int id;
    private String name;
    private double salary;
    private boolean permanent;
    private Date dateOfBirth;
    private Department department;
    private Set<Skill> skillList = new HashSet<>();

    public void setName(String name) { this.name = name; }
    public void setSalary(double salary) { this.salary = salary; }
    public void setPermanent(boolean permanent) { this.permanent = permanent; }
    public void setDateOfBirth(Date dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    public void setDepartment(Department department) { this.department = department; }
    public void setSkillList(Set<Skill> skillList) { this.skillList = skillList; }

    @Override
    public String toString() {
        return "Employee{" + "name='" + name + '\'' + ", salary=" + salary + ", permanent=" + permanent + ", department=" + department + ", skills=" + skillList + '}';
    }
}

class Department {
    private int id;
    private String name;

    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "Department{" + "name='" + name + '\'' + '}';
    }
}

class Skill {
    private int id;
    private String name;

    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "Skill{" + "name='" + name + '\'' + '}';
    }
}
