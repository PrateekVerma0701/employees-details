package com.prateek.learning.employees.service;

import com.prateek.learning.employees.dto.ResponseDTO;
import com.prateek.learning.employees.dto.request.CompanyRequestDTO;
import com.prateek.learning.employees.dto.response.CompanyDetailResponseDTO;

public interface CompanyService {
    CompanyDetailResponseDTO findByCompanyId(Long contractorId);

    ResponseDTO saveCompany(CompanyRequestDTO companyRequestDTO);
}
