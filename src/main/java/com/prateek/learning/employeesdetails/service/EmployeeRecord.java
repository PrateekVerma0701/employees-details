package com.prateek.learning.employeesdetails.service;

import com.prateek.learning.employeesdetails.model.CompanyModel;
import com.prateek.learning.employeesdetails.model.EmployeeModel;
import com.prateek.learning.employeesdetails.response.EmployeeBasicDetailsResponse;

import java.util.List;

public interface EmployeeRecord {
    CompanyModel findByCompanyId(Long companyId);

    EmployeeModel findByEmployeeId(Long employeeId);

    List<EmployeeModel> findAllEmployees();

    EmployeeBasicDetailsResponse findByEmployeeIdBasicDetails(Long employeeId);

    List<EmployeeBasicDetailsResponse> findAllEmployeesBasicDetails();
}
