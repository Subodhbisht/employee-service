package sb.bisht.employeeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sb.bisht.employeeservice.entity.Employee;
import sb.bisht.employeeservice.model.EmployeeSearchCriteria;
import sb.bisht.employeeservice.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    List<Employee> employeesSeeder;

    @Autowired
    EmployeeService empService;

    @GetMapping("/all")
    @CrossOrigin("*")
    public ResponseEntity<?> getAllEmployees() {
        return new ResponseEntity<>(empService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/search")
    @CrossOrigin(allowedHeaders = "*", origins = "*")
    public ResponseEntity<?> searchByCriteria(@RequestBody EmployeeSearchCriteria searchCriteria) {
        return new ResponseEntity<>(empService.searchEmployeeByCriteria(searchCriteria), HttpStatus.OK);
    }
}
