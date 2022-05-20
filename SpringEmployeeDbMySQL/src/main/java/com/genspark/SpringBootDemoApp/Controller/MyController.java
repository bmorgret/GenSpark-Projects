package com.genspark.SpringBootDemoApp.Controller;
import com.genspark.SpringBootDemoApp.Entity.Employee;
import com.genspark.SpringBootDemoApp.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping ("/")
    public String home(){
        return "<HTML><H1>Welcome to Employee Application</H1><</HTML>";
    }

    @GetMapping ("/employees")
    public List<Employee> getEmployee(){
        return this.employeeService.getAllEmployee();
    }
    @GetMapping("/employees/{employeeID}")
    public Employee getemployee(@PathVariable String empID){
        return this.employeeService.getEmployeeByID(Integer.parseInt(empID));
    }
    @PostMapping("/employees")
    public Employee addemployee(@RequestBody Employee employee){
        return this.employeeService.addEmployee(employee);
    }
    @PutMapping("/employees")
    public Employee updateemployee(@RequestBody Employee employee){
        return this.employeeService.updateEmployee(employee);
    }
    @DeleteMapping("/employees/{employeeID}")
    public String deleteemployee(@PathVariable String employeeID){
        return this.employeeService.deleteEmployeeByID(Integer.parseInt(employeeID));
    }

}
