package com.deo.thymeleafdbdemo.controller;

import com.deo.thymeleafdbdemo.entity.Employee;
import com.deo.thymeleafdbdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {

        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String showList(Model model) {
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employeesList", employees);
        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        return "employees/employee-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId, Model model) {
        //get the employee from the service
        Employee theEmployee = employeeService.findById(theId);
        //set employee as a model attribute to pre-populate the form
        model.addAttribute("employee",theEmployee);

        //send out our form
        return "employees/employee-form";
    }


    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        //save the employee
        employeeService.save(employee);
        //use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";


    }


}
