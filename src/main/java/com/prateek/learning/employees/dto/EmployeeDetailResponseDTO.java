package com.prateek.learning.employees.dto;

import com.prateek.learning.employees.entity.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class EmployeeDetailResponseDTO {
    private Long employeeContractorId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private Department department;
    private Company company;
    private Address address;
    private List<Project> projects;

    public static EmployeeDetailResponseDTO createEmployeeResponseModel(Employee employee) {
        EmployeeDetailResponseDTO employeeDetailResponseDTO = new EmployeeDetailResponseDTO();
        employeeDetailResponseDTO.setEmployeeContractorId(employee.getEmployeeContractorId());
        employeeDetailResponseDTO.setFirstName(employee.getFirstName());
        employeeDetailResponseDTO.setLastName(employee.getLastName());
        employeeDetailResponseDTO.setPhoneNumber(employee.getPhoneNumber());
        employeeDetailResponseDTO.setEmail(employee.getEmail());
        employeeDetailResponseDTO.setDepartment(employee.getDepartment());
        employeeDetailResponseDTO.setCompany(employee.getCompany());
        employeeDetailResponseDTO.setAddress(employee.getAddress());
        employeeDetailResponseDTO.setProjects(employee.getProjects());
        return employeeDetailResponseDTO;
    }

    public static List<EmployeeDetailResponseDTO> createAllEmployeeResponseModel(Page<Employee> employees) {
        List<EmployeeDetailResponseDTO> employeeDetailResponseDTOS = new ArrayList<>();
        employees.forEach(employee -> {
            EmployeeDetailResponseDTO employeeDetailResponseDTO = new EmployeeDetailResponseDTO();
            employeeDetailResponseDTO.setEmployeeContractorId(employee.getEmployeeContractorId());
            employeeDetailResponseDTO.setFirstName(employee.getFirstName());
            employeeDetailResponseDTO.setLastName(employee.getLastName());
            employeeDetailResponseDTO.setPhoneNumber(employee.getPhoneNumber());
            employeeDetailResponseDTO.setEmail(employee.getEmail());
            employeeDetailResponseDTO.setDepartment(employee.getDepartment());
            employeeDetailResponseDTO.setCompany(employee.getCompany());
            employeeDetailResponseDTO.setAddress(employee.getAddress());
            employeeDetailResponseDTO.setProjects(employee.getProjects());

            employeeDetailResponseDTOS.add(employeeDetailResponseDTO);
        });

        return employeeDetailResponseDTOS;
    }
}
