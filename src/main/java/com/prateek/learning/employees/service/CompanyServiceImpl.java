package com.prateek.learning.employees.service;

import com.prateek.learning.employees.dto.ErrorDTO;
import com.prateek.learning.employees.dto.ResponseDTO;
import com.prateek.learning.employees.dto.request.CompanyRequestDTO;
import com.prateek.learning.employees.dto.response.CompanyDetailResponseDTO;
import com.prateek.learning.employees.entity.Company;
import com.prateek.learning.employees.entity.CompanyPK;
import com.prateek.learning.employees.repository.CompanyRepository;
import com.prateek.learning.employees.validation.CompanyRequestValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyRequestValidation companyRequestValidation;

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public CompanyDetailResponseDTO findByContractorId(Long contractorId) {
        Optional<Company> companyRecord = companyRepository.findByContractorId(contractorId);
        return companyRecord.map(CompanyDetailResponseDTO::createCompanyResponseModel).orElseGet(CompanyDetailResponseDTO::new);
    }

    @Override
    public ResponseDTO saveCompany(CompanyRequestDTO companyRequestDTO) {
        ResponseDTO validateResponse = companyRequestValidation.validateCompanyRequest(companyRequestDTO);
        if (validateResponse.isStatus()) {
            Company company = new Company();
            CompanyPK companyPK = new CompanyPK();
            companyPK.setRegistrationId(companyRequestDTO.getRegistrationId());
            companyPK.setGlobalCompanyId(companyRequestDTO.getGlobalCompanyId());
            company.setContractorId(companyRequestDTO.getContractorId());
            company.setCompanyPK(companyPK);
            company.setCompanyName(companyRequestDTO.getCompanyName());
            company.setCompanyAddress(companyRequestDTO.getCompanyAddress());
            companyRepository.save(company);
            return new ResponseDTO(true, "Company record created successfully");
        } else {
            return validateResponse;
        }
    }

    @Override
    public ResponseDTO deleteCompany(Long contractorId) {
        Optional<Company> companyToBeDeleted = companyRepository.findByContractorId(contractorId);
        if (companyToBeDeleted.isPresent()) {
            companyRepository.delete(companyToBeDeleted.get());
            return new ResponseDTO(true, "Company record deleted successfully.");
        } else {
            ResponseDTO responseDTO = new ResponseDTO<>(Boolean.FALSE);
            responseDTO.setMessage("Company record to be deleted does not exist.");
            responseDTO.addError(new ErrorDTO("101", "Record does not exist."));
            return responseDTO;
        }
    }
}
