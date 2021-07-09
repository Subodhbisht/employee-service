package sb.bisht.employeeservice.dao;

import sb.bisht.employeeservice.entity.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeCustomDao {

    List<Employee> searchEmployeeByCriteria(Map<String, String> mapCriteria);
}
