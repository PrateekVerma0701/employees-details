package com.prateek.learning.employees.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity(name = "projects")
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
    private List<Employee> employees = new ArrayList<>();
}
