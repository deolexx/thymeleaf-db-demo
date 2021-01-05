package com.deo.thymeleafdbdemo.service;

import com.deo.thymeleafdbdemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();

    public Employee findById(int theId);


    public void save(Employee employee);

    public void delete(int theId);
}
