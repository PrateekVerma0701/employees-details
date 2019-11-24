package com.prateek.learning.employees.dto.response;

import com.prateek.learning.employees.entity.Company;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyDetailResponseDTO {
    private Long contractorId;
    private Long registrationId;
    private String companyName;
    private String companyAddress;

    public static CompanyDetailResponseDTO createCompanyResponseModel(Company company) {
        CompanyDetailResponseDTO companyDetailResponseDTO = new CompanyDetailResponseDTO();
        companyDetailResponseDTO.setContractorId(company.getContractorId());
        companyDetailResponseDTO.setRegistrationId(company.getCompanyPK().getRegistrationId());
        companyDetailResponseDTO.setCompanyAddress(company.getCompanyAddress());
        companyDetailResponseDTO.setCompanyName(company.getCompanyName());
        return companyDetailResponseDTO;
    }
}
