package com.prateek.learning.employees.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "company")
@JsonIgnoreProperties("employees")
public class Company {
    @EmbeddedId
    private CompanyPK companyPK;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long companyId;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "company_address", nullable = false)
    private String companyAddress;

    @OneToMany(mappedBy = "company")
    @JsonManagedReference
    private List<Employee> employees;
}
