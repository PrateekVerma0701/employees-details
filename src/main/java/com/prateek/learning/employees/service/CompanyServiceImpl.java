package com.prateek.learning.employees.service;

import com.prateek.learning.employees.dto.ResponseDTO;
import com.prateek.learning.employees.dto.request.CompanyRequestDTO;
import com.prateek.learning.employees.dto.response.CompanyDetailResponseDTO;
import com.prateek.learning.employees.entity.Company;
import com.prateek.learning.employees.repository.CompanyRepository;
import com.prateek.learning.employees.validation.CompanyRequestValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyRequestValidation companyRequestValidation;

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public CompanyDetailResponseDTO findByCompanyId(Long companyId) {
        Company company = companyRepository.findByCompanyId(companyId);
        return CompanyDetailResponseDTO.createCompanyResponseModel(company);
    }

    @Override
    public ResponseDTO saveCompany(CompanyRequestDTO companyRequestDTO) {
        ResponseDTO validateResponse = companyRequestValidation.validateCompanyRequest(companyRequestDTO);
        if (validateResponse.isStatus()) {
            Company company = new Company();
            company.setCompanyName(companyRequestDTO.getCompanyName());
            company.setCompanyAddress(companyRequestDTO.getCompanyAddress());
            companyRepository.save(company);
            ResponseDTO responseDTO = new ResponseDTO(true, "Company record created successfully");
            return responseDTO;
        } else {
            return validateResponse;
        }
    }
}
