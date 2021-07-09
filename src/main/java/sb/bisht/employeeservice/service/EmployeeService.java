package sb.bisht.employeeservice.service;

import sb.bisht.employeeservice.entity.Employee;
import sb.bisht.employeeservice.model.EmployeeSearchCriteria;

import java.util.List;

public interface EmployeeService {

    List<Employee> searchEmployeeByCriteria(EmployeeSearchCriteria searchCriteria);
    List<Employee> findAll();
}
