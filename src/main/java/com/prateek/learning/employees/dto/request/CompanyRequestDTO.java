package com.prateek.learning.employees.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CompanyRequestDTO {
    @NotNull(message = "company.registration.id.mandatory")
    private Long registrationId;

    @NotNull(message = "global.company.id.mandatory")
    private Long globalCompanyId;

    @NotNull(message = "contractor.id.mandatory")
    private Long contractorId;

    @NotEmpty(message = "company.name.mandatory")
    private String companyName;

    @NotEmpty(message = "company.address.mandatory")
    private String companyAddress;
}
