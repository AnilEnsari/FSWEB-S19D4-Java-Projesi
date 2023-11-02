package com.example.worktintechspring.dao;

import com.example.worktintechspring.entity.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class EmployeeRepositoryTest {


    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeRepositoryTest(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    private void createEmployee(String firstName,String lastName,String email,double salary){

        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setEmail(email);
        employee.setSalary(salary);
        employeeRepository.save(employee);
    }

    @BeforeEach
    void SetUp (){
        createEmployee("Anil","Ensari",
                "anil@gs.com",30000);
        createEmployee("Fernando","Muslera",
                "muslera@gs.com",50000);
        createEmployee("Mauro","Icardi",
                "icardi@gs.com",120000);
    }

    @AfterEach
    void tearDown(){
        employeeRepository.deleteAll();

    }

    @Test
    void findByEmail() {
        Employee foundEmployee = employeeRepository.findByEmail("anil@gs.com");
        Employee nullEmployee = employeeRepository.findByEmail("anil@test.com");
        assertNotNull(foundEmployee);
        assertEquals("Anil",foundEmployee.getFirstName());
        assertNull(nullEmployee);

    }
    @Test
    void findBySalary() {
        List<Employee> earnerEmployees = employeeRepository.findBySalary(35000.0);
        assertEquals("Icardi", earnerEmployees.get(0).getLastName());
        List<Employee> nullEmployees = employeeRepository.findBySalary(200000.0);
     //   assertEquals("[]",nullEmployees);

    }

    @Test
    void findByOrder() {
        List <Employee> orderedEmployees = employeeRepository.findByOrder();
        assertEquals("Ensari",orderedEmployees.get(0).getLastName());
        assertEquals("Muslera",orderedEmployees.get(2).getLastName());
    }


}