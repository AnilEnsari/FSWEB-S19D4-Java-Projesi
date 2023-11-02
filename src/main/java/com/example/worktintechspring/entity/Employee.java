package com.example.worktintechspring.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "employee", schema = "fsweb")
public class Employee {
    //id, firstName, lastName, email, salary
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name="first_name")
private String firstName;

    @Column(name="last_name")
private String lastName;

    @Column(name="email")
    private String email;

    @Column(name = "salary")
    private String salary;
}

