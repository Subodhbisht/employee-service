package sb.bisht.employeeservice.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sb.bisht.employeeservice.entity.Employee;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Long> , EmployeeCustomDao{
}
