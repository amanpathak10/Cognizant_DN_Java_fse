package Week_3.Spring_Data_JPA_with_Hibernate.HandsOn_Questions_4;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;

@SpringBootApplication
public class Exercise9 {

    @Configuration
    static class DataSourceConfig {

        @Bean
        @ConfigurationProperties(prefix = "spring.datasource.primary")
        public DataSource primaryDataSource() {
            return DataSourceBuilder.create().build();
        }

        @Bean
        @ConfigurationProperties(prefix = "spring.datasource.secondary")
        public DataSource secondaryDataSource() {
            return DataSourceBuilder.create().build();
        }
    }

    public static void main(String[] args) {
        System.out.println("Spring Boot Auto-Configuration with Multiple Data Sources");
    }
}