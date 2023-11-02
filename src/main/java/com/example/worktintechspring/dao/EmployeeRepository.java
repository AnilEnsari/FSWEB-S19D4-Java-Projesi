package com.example.worktintechspring.dao;

import com.example.worktintechspring.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT e FROM Employee e WHERE e.email=:email")
    public Employee findByEmail(String email);


    @Query("SELECT e FROM Employee e WHERE e.salary>:salary ORDER BY e.salary DESC")
   public List<Employee> findBySalary(Double salary);

    @Query("SELECT e FROM Employee e ORDER BY e.lastName ASC")
    public List<Employee> findByOrder();

}


