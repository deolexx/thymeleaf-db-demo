package com.deo.thymeleafdbdemo.controller;

import com.deo.thymeleafdbdemo.entity.Employee;
import com.deo.thymeleafdbdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/showFormForAdd")
    public String showForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        return "employeeForm";
    }


    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        //save the employee
        employeeService.save(employee);
        //use a redirect to prevent duplicate submissions
        return "redirect:/emp/list";


    }


}
