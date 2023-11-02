package com.example.worktintechspring.service;

import com.example.worktintechspring.dao.EmployeeRepository;
import com.example.worktintechspring.entity.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
class EmpolyeeServiceImplTest {

    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @BeforeEach void setUp (){
        employeeService = new EmpolyeeServiceImpl(employeeRepository);
    }

    @Test
    void findAll() {
        employeeService.findAll();
        verify(employeeRepository).findAll();
    }

    @Test
    void findById() {
    }

    @Test
    void canSaveEmployee() {
        Employee employee = new Employee();
        employee.setFirstName("Kerem");
        employee.setLastName("Akturkoglu");
        employee.setSalary(20000);
        employee.setEmail("kerem@gs.com");
        employeeService.save(employee);
        verify(employeeRepository).save(employee);
    }

    @Test
    void canDeleteEmployee() {

    }

    @Test
    void findByEmail() {
    }

    @Test
    void findByOrder() {
    }

    @Test
    void findBySalary() {
    }
}