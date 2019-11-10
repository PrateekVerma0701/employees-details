package com.prateek.learning.employees.service;

import com.prateek.learning.employees.dto.CompanyDetailResponseDTO;
import com.prateek.learning.employees.dto.EmployeeDetailResponseDTO;
import com.prateek.learning.employees.dto.EmployeeBasicDetailResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeRecord {
    CompanyDetailResponseDTO findByCompanyId(Long companyId);

    EmployeeDetailResponseDTO findByEmployeeId(Long employeeId);

    Page<EmployeeDetailResponseDTO> findAllEmployees(Pageable pageable);

    EmployeeBasicDetailResponseDTO findByEmployeeIdBasicDetails(Long employeeId);

    Page<EmployeeBasicDetailResponseDTO> findAllEmployeesBasicDetails(Pageable pageable);
}
