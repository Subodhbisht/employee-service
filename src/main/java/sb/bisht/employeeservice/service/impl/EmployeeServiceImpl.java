package sb.bisht.employeeservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sb.bisht.employeeservice.dao.EmployeeDao;
import sb.bisht.employeeservice.entity.Employee;
import sb.bisht.employeeservice.model.EmployeeSearchCriteria;
import sb.bisht.employeeservice.service.EmployeeService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    DateTimeFormatter oldPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    DateTimeFormatter newPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public List<Employee> searchEmployeeByCriteria(EmployeeSearchCriteria searchCriteria) {
        Map<String, String> mapCriteria = new HashMap<String, String>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        if(searchCriteria.getName()!=null) {
            mapCriteria.put("name", searchCriteria.getName());
        }
        if(searchCriteria.getJobTitle()!=null) {
            mapCriteria.put("emp.jobTitle", searchCriteria.getJobTitle());
        }
        if(searchCriteria.getStartDate()!=null) {
            mapCriteria.put("emp.startDate", LocalDate.parse(searchCriteria.getStartDate(), oldPattern).format(newPattern));
        }
        if(searchCriteria.getEndDate()!=null) {
            mapCriteria.put("emp.endDate", LocalDate.parse(searchCriteria.getEndDate(), oldPattern).format(newPattern));
        }
        return employeeDao.searchEmployeeByCriteria(mapCriteria);
    }

    @Override
    public List<Employee> findAll() {
        return StreamSupport.stream(employeeDao.findAll().spliterator(),false).collect(Collectors.toList());
    }
}
