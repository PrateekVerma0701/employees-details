package com.prateek.learning.employees.service;

import com.prateek.learning.employees.dto.ResponseDTO;
import com.prateek.learning.employees.dto.request.CompanyRequestDTO;

public interface CompanyService {
    ResponseDTO findByContractorId(Long contractorId);

    ResponseDTO saveCompany(CompanyRequestDTO companyRequestDTO);

    ResponseDTO deleteCompany(Long contractorId);
}
