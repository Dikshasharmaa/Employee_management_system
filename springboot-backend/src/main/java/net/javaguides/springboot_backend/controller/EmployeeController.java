package net.javaguides.springboot_backend.controller;

import net.javaguides.springboot_backend.model.Employee;
import net.javaguides.springboot_backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
    @Autowired
    private EmployeeRepository  employeeRepository;

    //get all Employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    //Creating employees
    @PostMapping
    public Employee creatEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
}
