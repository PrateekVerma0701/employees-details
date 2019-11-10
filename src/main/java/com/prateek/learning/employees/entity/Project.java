package com.prateek.learning.employees.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity(name = "projects")
@JsonIgnoreProperties("employees")
public class Project {
    @Id
    @Column(name = "project_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;

    @Column(name = "project_name", nullable = false)
    private String projectName;

    @Column(name = "project_detail", nullable = false)
    private String projectDetail;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "projects")
    @JsonManagedReference
    private List<Employee> employees = new ArrayList<>();

     /*Updating the associations on both entities is an error-prone task.
    It’s, therefore, a good practice to provide helper methods for it.*/

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
        employee.getProjects().add(this);
    }

    public void removeEmployee(Employee employee) {
        this.employees.remove(employee);
        employee.getProjects().remove(this);
    }
}
