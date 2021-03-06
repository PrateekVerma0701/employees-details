package com.prateek.learning.employees.service;

import com.prateek.learning.employees.dto.ResponseDTO;
import com.prateek.learning.employees.dto.request.CompanyRequestDTO;
import com.prateek.learning.employees.entity.Company;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface CompanyService {
    ResponseDTO findByContractorId(Long contractorId);

    ResponseDTO saveCompany(CompanyRequestDTO companyRequestDTO);

    ResponseDTO deleteCompany(Long contractorId);

    List<Company> findAll(Specification<Company> companySpecification);
}
