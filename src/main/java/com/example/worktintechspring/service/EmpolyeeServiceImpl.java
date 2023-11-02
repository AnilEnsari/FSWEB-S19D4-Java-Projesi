package com.example.worktintechspring.service;

import com.example.worktintechspring.dao.EmployeeRepository;
import com.example.worktintechspring.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpolyeeServiceImpl implements EmployeeService{


    EmployeeRepository employeeRepository;

    @Autowired
    public EmpolyeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
       return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional <Employee> optionalEmployee= employeeRepository.findById(id);
        if(optionalEmployee.isPresent()){
        return optionalEmployee.get();
        }
        else {
            throw  new RuntimeException("Please enter a valid id");
        }
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee delete(int id) {
        Employee deletedEmployee = findById(id);
        employeeRepository.delete(deletedEmployee);
        return deletedEmployee;
    }

    @Override
    public Employee findByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }

    @Override
    public List<Employee> findByOrder() {
        return employeeRepository.findByOrder();
    }

    @Override
    public List<Employee> findBySalary(Double salary) {
        return employeeRepository.findBySalary(salary);
    }
}
