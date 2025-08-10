package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/add-employee")
    public String addEmployee() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("John Doe");
        employee.setSalary(50000.0);
        employee.setPermanent(true);
        employeeService.addEmployee(employee);
        return "Employee added successfully: " + employee.getName();
    }
}
