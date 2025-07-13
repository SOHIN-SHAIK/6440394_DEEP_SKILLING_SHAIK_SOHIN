package com.cognizant.spring_learn.dao;

import com.cognizant.spring_learn.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDao {

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Sohin", "Developer", 25000));
        return employees;
    }
}
