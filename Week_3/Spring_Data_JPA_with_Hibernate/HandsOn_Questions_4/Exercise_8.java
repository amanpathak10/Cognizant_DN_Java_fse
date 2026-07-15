package Week_3.Spring_Data_JPA_with_Hibernate.HandsOn_Questions_4;

import org.springframework.beans.factory.annotation.Value;

public class Exercise_8 {

    // Interface-based Projection
    interface EmployeeView {

        String getName();

        @Value("#{target.name + ' - ' + target.department}")
        String getEmployeeDetails();
    }

    // Class-based Projection
    static class EmployeeDTO {

        private String name;
        private String department;

        public EmployeeDTO(String name, String department) {
            this.name = name;
            this.department = department;
        }

        @Override
        public String toString() {
            return name + " - " + department;
        }
    }

    public static void main(String[] args) {
        System.out.println("Interface-based and Class-based Projections Example");
    }
}