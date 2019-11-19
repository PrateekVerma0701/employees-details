package com.prateek.learning.employees.service;

import com.prateek.learning.employees.dto.response.EmployeeBasicDetailResponseDTO;
import com.prateek.learning.employees.dto.response.EmployeeDetailResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeRecord {
    EmployeeDetailResponseDTO findByEmployeeId(Long employeeId);

    Page<EmployeeDetailResponseDTO> findAllEmployees(Pageable pageable);

    EmployeeBasicDetailResponseDTO findByEmployeeIdBasicDetails(Long employeeId);

    Page<EmployeeBasicDetailResponseDTO> findAllEmployeesBasicDetails(Pageable pageable);
}
