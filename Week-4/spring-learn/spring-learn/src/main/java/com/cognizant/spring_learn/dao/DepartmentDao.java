package com.cognizant.spring_learn.dao;

import com.cognizant.spring_learn.model.Department;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentDao {

    private static List<Department> DEPARTMENT_LIST = new ArrayList<>();

    static {
        DEPARTMENT_LIST.add(new Department(1, "HR"));
        DEPARTMENT_LIST.add(new Department(2, "IT"));
        DEPARTMENT_LIST.add(new Department(3, "Finance"));
    }

    public List<Department> getAllDepartments() {
        return DEPARTMENT_LIST;
    }
}
