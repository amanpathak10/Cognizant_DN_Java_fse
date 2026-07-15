import java.util.List;

public class Exercise3_NativeQueryDemo {
    public static void main(String[] args) {
        EmployeeNativeRepository repository = new EmployeeNativeRepository();
        List<EmployeeNative> employees = repository.getAllEmployeesNative();
        System.out.println("All employees using native query:");
        employees.forEach(System.out::println);
    }
}

class EmployeeNative {
    private int id;
    private String name;

    public EmployeeNative(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "EmployeeNative{id=" + id + ", name='" + name + '\'' + '}';
    }
}

class EmployeeNativeRepository {
    public List<EmployeeNative> getAllEmployeesNative() {
        return List.of(new EmployeeNative(1, "Asha"), new EmployeeNative(2, "Ravi"));
    }
}
