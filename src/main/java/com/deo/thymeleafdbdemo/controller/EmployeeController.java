package com.deo.thymeleafdbdemo.controller;

import com.deo.thymeleafdbdemo.entity.Employee;
import com.deo.thymeleafdbdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
    private EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {

        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String showList(Model model) {
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employeesList", employees);
        return "employees-list";
    }
    


}
