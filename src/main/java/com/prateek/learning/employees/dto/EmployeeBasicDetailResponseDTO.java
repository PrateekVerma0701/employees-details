package com.prateek.learning.employees.dto;

import com.prateek.learning.employees.entity.Employee;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class EmployeeBasicDetailResponseDTO {
    private Long employeeContractorId;
    private String companyName;
    private Long companyId;
    private String departmentName;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String houseNumber;
    private String addressLine1;
    private String city;
    private String state;
    private String country;
    private String pinCode;

    public static EmployeeBasicDetailResponseDTO createEmployeeBasicResponseModel(Employee employee) {
        EmployeeBasicDetailResponseDTO employeeBasicDetailResponseDTO = new EmployeeBasicDetailResponseDTO();
        employeeBasicDetailResponseDTO.setEmployeeContractorId(employee.getEmployeeContractorId());
        employeeBasicDetailResponseDTO.setDepartmentName(employee.getDepartment().getDepartmentName());
        employeeBasicDetailResponseDTO.setCompanyName(employee.getCompany().getCompanyName());
        employeeBasicDetailResponseDTO.setCompanyId(employee.getCompany().getCompanyId());
        employeeBasicDetailResponseDTO.setFirstName(employee.getFirstName());
        employeeBasicDetailResponseDTO.setLastName(employee.getLastName());
        employeeBasicDetailResponseDTO.setPhoneNumber(employee.getPhoneNumber());
        employeeBasicDetailResponseDTO.setEmail(employee.getEmail());
        employeeBasicDetailResponseDTO.setHouseNumber(employee.getAddress().getHouseNumber());
        employeeBasicDetailResponseDTO.setAddressLine1(employee.getAddress().getAddressLine1());
        employeeBasicDetailResponseDTO.setCity(employee.getAddress().getCity());
        employeeBasicDetailResponseDTO.setState(employee.getAddress().getState());
        employeeBasicDetailResponseDTO.setCountry(employee.getAddress().getCountry());
        employeeBasicDetailResponseDTO.setPinCode(employee.getAddress().getPinCode());

        return employeeBasicDetailResponseDTO;
    }

    public static List<EmployeeBasicDetailResponseDTO> createAllEmployeeBasicResponseModel(Page<Employee> employees) {
        List<EmployeeBasicDetailResponseDTO> employeeBasicDetailResponseDTOList = new ArrayList<>();
        employees.forEach(employee -> {
            EmployeeBasicDetailResponseDTO employeeBasicDetailResponseDTO = new EmployeeBasicDetailResponseDTO();
            employeeBasicDetailResponseDTO.setEmployeeContractorId(employee.getEmployeeContractorId());
            employeeBasicDetailResponseDTO.setDepartmentName(employee.getDepartment().getDepartmentName());
            employeeBasicDetailResponseDTO.setCompanyName(employee.getCompany().getCompanyName());
            employeeBasicDetailResponseDTO.setCompanyId(employee.getCompany().getCompanyId());
            employeeBasicDetailResponseDTO.setFirstName(employee.getFirstName());
            employeeBasicDetailResponseDTO.setLastName(employee.getLastName());
            employeeBasicDetailResponseDTO.setPhoneNumber(employee.getPhoneNumber());
            employeeBasicDetailResponseDTO.setEmail(employee.getEmail());
            employeeBasicDetailResponseDTO.setHouseNumber(employee.getAddress().getHouseNumber());
            employeeBasicDetailResponseDTO.setAddressLine1(employee.getAddress().getAddressLine1());
            employeeBasicDetailResponseDTO.setCity(employee.getAddress().getCity());
            employeeBasicDetailResponseDTO.setState(employee.getAddress().getState());
            employeeBasicDetailResponseDTO.setCountry(employee.getAddress().getCountry());
            employeeBasicDetailResponseDTO.setPinCode(employee.getAddress().getPinCode());

            employeeBasicDetailResponseDTOList.add(employeeBasicDetailResponseDTO);

        });
        return employeeBasicDetailResponseDTOList;
    }
}
