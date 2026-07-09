public class Exercise4_MavenProject {
    
    public static void main(String[] args) {
        System.out.println("Maven Project Structure:");
        System.out.println("library-management/");
        System.out.println("├── pom.xml");
        System.out.println("├── src/");
        System.out.println("│   ├── main/");
        System.out.println("│   │   ├── java/");
        System.out.println("│   │   │   └── com/library/");
        System.out.println("│   │   │       ├── service/");
        System.out.println("│   │   │       └── repository/");
        System.out.println("│   │   └── resources/");
        System.out.println("│   │       └── applicationContext.xml");
        System.out.println("│   └── test/");
        System.out.println("│       ├── java/");
        System.out.println("│       └── resources/");
        System.out.println("└── target/");
        System.out.println("\nMaven Lifecycle Commands:");
        System.out.println("mvn clean");
        System.out.println("mvn compile");
        System.out.println("mvn test");
        System.out.println("mvn package");
        System.out.println("mvn install");
    }
}

class MavenConfig {
    public static void displayPomContent() {
        System.out.println("\npom.xml Content:");
        System.out.println("<project>");
        System.out.println("  <modelVersion>4.0.0</modelVersion>");
        System.out.println("  <groupId>com.library</groupId>");
        System.out.println("  <artifactId>library-management</artifactId>");
        System.out.println("  <version>1.0.0</version>");
        System.out.println("  <packaging>jar</packaging>");
        System.out.println("  <dependencies>");
        System.out.println("    <dependency>");
        System.out.println("      <groupId>org.springframework</groupId>");
        System.out.println("      <artifactId>spring-core</artifactId>");
        System.out.println("      <version>5.3.0</version>");
        System.out.println("    </dependency>");
        System.out.println("  </dependencies>");
        System.out.println("</project>");
    }
}
