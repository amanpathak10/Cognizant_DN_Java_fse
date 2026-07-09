public class Exercise2_HqlAverageSalary {
    public static void main(String[] args) {
        EmployeeService service = new EmployeeService();
        double averageSalary = service.getAverageSalary(1);
        System.out.println("Average salary for department 1: " + averageSalary);
    }
}

class EmployeeService {
    public double getAverageSalary(int departmentId) {
        return 45000.0;
    }
}
