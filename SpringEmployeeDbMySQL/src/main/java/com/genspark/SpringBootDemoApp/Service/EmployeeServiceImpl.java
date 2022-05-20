package com.genspark.SpringBootDemoApp.Service;

import com.genspark.SpringBootDemoApp.Dao.EmployeeDao;
import com.genspark.SpringBootDemoApp.Entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao EmployeeDao;

    @Override
    public List<Employee> getAllEmployee() {
        return this.EmployeeDao.findAll();
    }

    @Override
    public Employee getEmployeeByID(int EmployeeID) {
        Optional<Employee> c = this.EmployeeDao.findById(EmployeeID);
        Employee employee = null;
        if(c.isPresent()){
            employee = c.get();
        } else {
            throw new RuntimeException(" Employee not found for id :: " + EmployeeID);
        }
        return employee;

    }

    @Override
    public Employee addEmployee(Employee employee) {
        return this.EmployeeDao.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return this.EmployeeDao.save(employee);
    }

    @Override
    public String deleteEmployeeByID(int employeeID) {
        this.EmployeeDao.deleteById(employeeID);
        return "Delected Successfully";
    }
}
