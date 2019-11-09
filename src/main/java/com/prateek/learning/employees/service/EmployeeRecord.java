package com.prateek.learning.employees.service;

import com.prateek.learning.employees.model.CompanyModel;
import com.prateek.learning.employees.model.EmployeeModel;
import com.prateek.learning.employees.response.EmployeeBasicDetailsResponse;

import java.util.List;

public interface EmployeeRecord {
    CompanyModel findByCompanyId(Long companyId);

    EmployeeModel findByEmployeeId(Long employeeId);

    List<EmployeeModel> findAllEmployees();

    EmployeeBasicDetailsResponse findByEmployeeIdBasicDetails(Long employeeId);

    List<EmployeeBasicDetailsResponse> findAllEmployeesBasicDetails();
}
