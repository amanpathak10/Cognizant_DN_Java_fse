package Week_3.Spring_Data_JPA_with_Hibernate.HandsOn_Questions_4;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

public class Exercise7 {

    @Entity
    @EntityListeners(AuditingEntityListener.class)
    static class Employee {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;

        @CreatedBy
        private String createdBy;

        @CreatedDate
        private LocalDateTime createdDate;

        @LastModifiedBy
        private String lastModifiedBy;

        @LastModifiedDate
        private LocalDateTime lastModifiedDate;
    }

    @Entity
    @EntityListeners(AuditingEntityListener.class)
    static class Department {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String departmentName;

        @CreatedBy
        private String createdBy;

        @CreatedDate
        private LocalDateTime createdDate;

        @LastModifiedBy
        private String lastModifiedBy;

        @LastModifiedDate
        private LocalDateTime lastModifiedDate;
    }

    public static void main(String[] args) {
        System.out.println("Entity Auditing Enabled using:");
        System.out.println("@CreatedBy");
        System.out.println("@CreatedDate");
        System.out.println("@LastModifiedBy");
        System.out.println("@LastModifiedDate");
    }
}