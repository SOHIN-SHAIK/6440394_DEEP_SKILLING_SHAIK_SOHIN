package com.cognizant.spring_learn.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Employee {
    private int id;
    private String name;
    private double salary;
    private boolean permanent;
    private Date dateOfBirth;
    private Department department;
    private List<Skill> skillList;

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public boolean isPermanent() { return permanent; }
    public void setPermanent(boolean permanent) { this.permanent = permanent; }

    public Date getDateOfBirth() { return dateOfBirth; }

    // ✅ FIX: Correct setter to accept String in "yyyy-MM-dd" format
    public void setDateOfBirth(String date) throws ParseException {
        this.dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(date);
    }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }

    public List<Skill> getSkillList() { return skillList; }
    public void setSkillList(List<Skill> skillList) { this.skillList = skillList; }

    @Override
    public String toString() {
        return id + " | " + name + " | " + salary + " | " + dateOfBirth + " | " + department + " | " + skillList;
    }
}
