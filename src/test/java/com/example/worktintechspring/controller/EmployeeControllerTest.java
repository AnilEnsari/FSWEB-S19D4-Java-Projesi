package com.example.worktintechspring.controller;

import com.example.worktintechspring.entity.Employee;
import com.example.worktintechspring.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@WebMvcTest
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc ;

    @MockBean
    private EmployeeService employeeService;

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void findByEmail() {
    }

    @Test
    void findAllByOrder() {
    }

    @Test
    void findBySalary() {
    }

    @Test
    void save() throws Exception{

        Employee employee = new Employee();
        employee.setFirstName("Wilfreid");
        employee.setLastName("Zaha");
        employee.setEmail("zaha@gs.com");
        employee.setSalary(100000);

        when(employeeService.save(employee)).thenReturn(employee);
        mockMvc.perform(post("/employee/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(employee))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value("Zaha"));
        verify(employeeService).save(employee);
        System.out.println("Test is success");



    }

    @Test
    void delete() {
    }

    public static String asJsonString(Object object){
        try {
            return new ObjectMapper().writeValueAsString(object);
        }
        catch (Exception exception){

            throw new RuntimeException(exception);
        }


    }
}