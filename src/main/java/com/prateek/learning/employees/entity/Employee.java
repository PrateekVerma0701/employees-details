package com.prateek.learning.employees.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity(name = "employees")
public class Employee {
    @Id
    @Column(name = "employee_contractor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeContractorId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "email", nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonBackReference
    private Department department;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "global_company_id"),
            @JoinColumn(name = "registration_id")})
    @JsonBackReference
    private Company company;

    @OneToOne(mappedBy = "employees")
    @JsonManagedReference
    private Address address;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "employees_projects", joinColumns = {
            @JoinColumn(name = "employee_id")}, inverseJoinColumns = {
            @JoinColumn(name = "project_id")})
    @JsonBackReference
    private List<Project> projects = new ArrayList<>();
}
