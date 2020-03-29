package com.prateek.learning.employees.service;

import com.prateek.learning.employees.dto.ResponseDTO;
import com.prateek.learning.employees.dto.request.CompanyRequestDTO;
import com.prateek.learning.employees.dto.request.DepartmentRequestDTO;

public interface DepartmentService {
    ResponseDTO findByDepartmentId(Long contractorId);

    ResponseDTO saveDepartment(DepartmentRequestDTO departmentRequestDTO);

    ResponseDTO deleteDepartment(Long contractorId);
}
