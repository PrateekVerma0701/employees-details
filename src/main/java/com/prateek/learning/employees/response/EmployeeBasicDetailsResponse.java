package com.prateek.learning.employees.response;

import com.prateek.learning.employees.entity.Employee;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class EmployeeBasicDetailsResponse {
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

    public static EmployeeBasicDetailsResponse createEmployeeBasicResponseModel(Employee employee) {
        EmployeeBasicDetailsResponse employeeBasicDetailsResponse = new EmployeeBasicDetailsResponse();
        employeeBasicDetailsResponse.setEmployeeContractorId(employee.getEmployeeContractorId());
        employeeBasicDetailsResponse.setDepartmentName(employee.getDepartment().getDepartmentName());
        employeeBasicDetailsResponse.setCompanyName(employee.getCompany().getCompanyName());
        employeeBasicDetailsResponse.setCompanyId(employee.getCompany().getCompanyId());
        employeeBasicDetailsResponse.setFirstName(employee.getFirstName());
        employeeBasicDetailsResponse.setLastName(employee.getLastName());
        employeeBasicDetailsResponse.setPhoneNumber(employee.getPhoneNumber());
        employeeBasicDetailsResponse.setEmail(employee.getEmail());
        employeeBasicDetailsResponse.setHouseNumber(employee.getAddress().getHouseNumber());
        employeeBasicDetailsResponse.setAddressLine1(employee.getAddress().getAddressLine1());
        employeeBasicDetailsResponse.setCity(employee.getAddress().getCity());
        employeeBasicDetailsResponse.setState(employee.getAddress().getState());
        employeeBasicDetailsResponse.setCountry(employee.getAddress().getCountry());
        employeeBasicDetailsResponse.setPinCode(employee.getAddress().getPinCode());

        return employeeBasicDetailsResponse;
    }

    public static List<EmployeeBasicDetailsResponse> createAllEmployeeBasicResponseModel(List<Employee> employees) {
        List<EmployeeBasicDetailsResponse> employeeBasicDetailsResponseList = new ArrayList<>();
        employees.forEach(employee -> {
            EmployeeBasicDetailsResponse employeeBasicDetailsResponse = new EmployeeBasicDetailsResponse();
            employeeBasicDetailsResponse.setEmployeeContractorId(employee.getEmployeeContractorId());
            employeeBasicDetailsResponse.setDepartmentName(employee.getDepartment().getDepartmentName());
            employeeBasicDetailsResponse.setCompanyName(employee.getCompany().getCompanyName());
            employeeBasicDetailsResponse.setCompanyId(employee.getCompany().getCompanyId());
            employeeBasicDetailsResponse.setFirstName(employee.getFirstName());
            employeeBasicDetailsResponse.setLastName(employee.getLastName());
            employeeBasicDetailsResponse.setPhoneNumber(employee.getPhoneNumber());
            employeeBasicDetailsResponse.setEmail(employee.getEmail());
            employeeBasicDetailsResponse.setHouseNumber(employee.getAddress().getHouseNumber());
            employeeBasicDetailsResponse.setAddressLine1(employee.getAddress().getAddressLine1());
            employeeBasicDetailsResponse.setCity(employee.getAddress().getCity());
            employeeBasicDetailsResponse.setState(employee.getAddress().getState());
            employeeBasicDetailsResponse.setCountry(employee.getAddress().getCountry());
            employeeBasicDetailsResponse.setPinCode(employee.getAddress().getPinCode());

            employeeBasicDetailsResponseList.add(employeeBasicDetailsResponse);

        });
        return employeeBasicDetailsResponseList;
    }
}
