package sb.bisht.employeeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sb.bisht.employeeservice.entity.Employee;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

@SpringBootApplication
public class EmployeeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeServiceApplication.class, args);
    }

    @Bean
    public List<Employee> employeesSeeder() {
        List<Employee> employees = Arrays.asList(new Employee("1", "Subodh", "Bisht", "Tech Lead", 30, Calendar.getInstance().getTime(), Calendar.getInstance().getTime()),
                new Employee("2", "Sudarshan", "Bisht", "Analust", 31, Calendar.getInstance().getTime(), Calendar.getInstance().getTime()),
                new Employee("3", "Lata", "Giri", "Project Coordinator", 28, Calendar.getInstance().getTime(), Calendar.getInstance().getTime()),
                new Employee("4", "Vipin", "Bhatt", "Team Lead", 30, Calendar.getInstance().getTime(), Calendar.getInstance().getTime()),
                new Employee("5", "Naveen", "Bhati", "Module Lead", 32, Calendar.getInstance().getTime(), Calendar.getInstance().getTime()),
                new Employee("6", "Sweta Bisht", "Oli", "Human Resource", 28, Calendar.getInstance().getTime(), Calendar.getInstance().getTime()));

        return employees;
    }

}
