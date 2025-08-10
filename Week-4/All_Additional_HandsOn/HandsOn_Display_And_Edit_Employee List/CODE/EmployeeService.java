package com.cognizant.spring_learn.service;

import com.cognizant.spring_learn.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private static final String[] BEAN_IDS = { "employee1", "employee2" };

    public List<Employee> getAllEmployees() {
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        List<Employee> list = new ArrayList<>();
        for (String id : BEAN_IDS) {
            list.add((Employee) context.getBean(id));
        }
        return list;
    }

    public Employee getById(int id) {
        return getAllEmployees().stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
