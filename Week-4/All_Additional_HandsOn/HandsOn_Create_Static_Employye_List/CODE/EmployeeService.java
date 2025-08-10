package com.cognizant.spring_learn.service;

import com.cognizant.spring_learn.dao.EmployeeDao;
import com.cognizant.spring_learn.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public ArrayList<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    public Employee getById(int id) {
        return employeeDao.getAllEmployees()
                .stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
