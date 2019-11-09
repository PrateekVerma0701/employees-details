package com.prateek.learning.employeesdetails.model;

import com.prateek.learning.employeesdetails.entity.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class EmployeeModel {
    private Long employeeContractorId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private Department department;
    private Company company;
    private Address address;
    private List<Project> projects;

    public static EmployeeModel createEmployeeResponseModel(Employee employee) {
        EmployeeModel employeeModel = new EmployeeModel();
        employeeModel.setEmployeeContractorId(employee.getEmployeeContractorId());
        employeeModel.setFirstName(employee.getFirstName());
        employeeModel.setLastName(employee.getLastName());
        employeeModel.setPhoneNumber(employee.getPhoneNumber());
        employeeModel.setEmail(employee.getEmail());
        employeeModel.setDepartment(employee.getDepartment());
        employeeModel.setCompany(employee.getCompany());
        employeeModel.setAddress(employee.getAddress());
        employeeModel.setProjects(employee.getProjects());
        return employeeModel;
    }

    public static List<EmployeeModel> createAllEmployeeResponseModel(List<Employee> employees) {
        List<EmployeeModel> employeeModels = new ArrayList<>();
        employees.forEach(employee -> {
            EmployeeModel employeeModel = new EmployeeModel();
            employeeModel.setEmployeeContractorId(employee.getEmployeeContractorId());
            employeeModel.setFirstName(employee.getFirstName());
            employeeModel.setLastName(employee.getLastName());
            employeeModel.setPhoneNumber(employee.getPhoneNumber());
            employeeModel.setEmail(employee.getEmail());
            employeeModel.setDepartment(employee.getDepartment());
            employeeModel.setCompany(employee.getCompany());
            employeeModel.setAddress(employee.getAddress());
            employeeModel.setProjects(employee.getProjects());

            employeeModels.add(employeeModel);
        });

        return employeeModels;
    }
}
