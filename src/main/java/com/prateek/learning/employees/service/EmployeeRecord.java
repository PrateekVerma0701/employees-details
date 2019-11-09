package com.prateek.learning.employees.service;

import com.prateek.learning.employees.model.CompanyModel;
import com.prateek.learning.employees.model.EmployeeModel;
import com.prateek.learning.employees.response.EmployeeBasicDetailsResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeRecord {
    CompanyModel findByCompanyId(Long companyId);

    EmployeeModel findByEmployeeId(Long employeeId);

    Page<EmployeeModel> findAllEmployees(Pageable pageable);

    EmployeeBasicDetailsResponse findByEmployeeIdBasicDetails(Long employeeId);

    Page<EmployeeBasicDetailsResponse> findAllEmployeesBasicDetails(Pageable pageable);
}
