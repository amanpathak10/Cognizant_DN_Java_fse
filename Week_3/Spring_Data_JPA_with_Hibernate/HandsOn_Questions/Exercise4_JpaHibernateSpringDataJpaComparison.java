public class Exercise4_JpaHibernateSpringDataJpaComparison {
    public static void main(String[] args) {
        System.out.println("JPA: specification for persistence");
        System.out.println("Hibernate: ORM framework implementing JPA");
        System.out.println("Spring Data JPA: repository abstraction over Hibernate/JPA");

        EmployeeRepository repository = new EmployeeRepository();
        repository.save(new EmployeeRecord(1, "Ravi"));
    }
}

class EmployeeRecord {
    private int id;
    private String name;

    public EmployeeRecord(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class EmployeeRepository {
    public void save(EmployeeRecord employee) {
        System.out.println("Saved employee: " + employee.getName());
    }
}
