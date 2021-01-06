

package com.deo.thymeleafdbdemo.service;
import com.deo.thymeleafdbdemo.dao.EmployeeRepository;
import com.deo.thymeleafdbdemo.entity.Employee;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        return employeeRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    @Transactional
    public Employee findById(int theId) {

        Optional<Employee> result = employeeRepository.findById(theId);
        Employee employee = null;
        if (result.isPresent()) {
            employee = result.get();
        }
        return employee;
    }
    @Override
    @Transactional
    public void save(Employee employee) {
    employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void delete(int theId) {
    employeeRepository.deleteById(theId);
    }
}
