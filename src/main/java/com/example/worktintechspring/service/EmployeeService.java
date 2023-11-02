package com.example.worktintechspring.service;

import com.example.worktintechspring.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();

    public Employee findById(int id);

    Employee save(Employee employee);

    Employee delete(int id);

    Employee findByEmail(String email);

    List<Employee> findByOrder();

    List<Employee> findBySalary(Double salary);
}
