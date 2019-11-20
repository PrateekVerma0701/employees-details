package com.prateek.learning.employees.service;

import com.prateek.learning.employees.dto.ResponseDTO;
import com.prateek.learning.employees.dto.request.CompanyRequestDTO;
import com.prateek.learning.employees.dto.response.CompanyDetailResponseDTO;

public interface CompanyService {
    CompanyDetailResponseDTO findByCompanyId(Long companyId);

    ResponseDTO saveCompany(CompanyRequestDTO companyRequestDTO);
}