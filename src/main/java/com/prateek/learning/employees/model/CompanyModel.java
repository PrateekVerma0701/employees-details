package com.prateek.learning.employees.model;

import com.prateek.learning.employees.entity.Company;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyModel {
    private Long companyId;
    private String companyName;
    private String companyAddress;

    public static CompanyModel createCompanyResponseModel(Company company) {
        CompanyModel companyModel = new CompanyModel();
        companyModel.setCompanyId(company.getCompanyId());
        companyModel.setCompanyAddress(company.getCompanyAddress());
        companyModel.setCompanyName(company.getCompanyName());
        return companyModel;
    }
}

