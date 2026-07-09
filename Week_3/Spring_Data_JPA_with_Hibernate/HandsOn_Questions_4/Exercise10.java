package Week_3.Spring_Data_JPA_with_Hibernate.HandsOn_Questions_4;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;

public class Exercise10 {

    @Entity
    @Table(name = "employee")
    @DynamicUpdate   // Hibernate-specific annotation
    static class Employee {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, length = 50)
        private String name;

        private double salary;
    }

    public static void main(String[] args) {
        System.out.println("Hibernate-Specific Features");
        System.out.println("1. @DynamicUpdate used for efficient updates.");
        System.out.println("2. Configure Hibernate dialect in application.properties.");
        System.out.println("3. Enable batch processing for bulk operations.");
    }
}