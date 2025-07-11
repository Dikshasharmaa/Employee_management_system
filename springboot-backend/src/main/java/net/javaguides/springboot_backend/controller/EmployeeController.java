package net.javaguides.springboot_backend.controller;

import net.javaguides.springboot_backend.exception.ResourceNotFoundException;
import net.javaguides.springboot_backend.model.Employee;
import net.javaguides.springboot_backend.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    // @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    //get employee by ID
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeesById(@PathVariable Long id){

        Employee employee = employeeRepository.findById(id)
        .orElseThrow(()->new ResourceNotFoundException("Employee do not exist with id :"+id));

        return  ResponseEntity.ok(employee);
    }

    //Update employee 
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> 
    updateEmployee(@PathVariable long id, 
    @RequestBody Employee employeeDetails){
        Employee employee = employeeRepository.findById(id)
        .orElseThrow(()->new ResourceNotFoundException("Employee do not exist with id :"+id));

        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmailID(employeeDetails.getEmailID());

        Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);


    }

    //Delete Employee
    @DeleteMapping("/employees/{id}")
    public  ResponseEntity <Map<String, Boolean> > deleteEmployee(@PathVariable Long id){
        Employee employee = employeeRepository.findById(id)
        .orElseThrow(()->new ResourceNotFoundException("Employee do not exist with id :"+id));

        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);

    }
}
