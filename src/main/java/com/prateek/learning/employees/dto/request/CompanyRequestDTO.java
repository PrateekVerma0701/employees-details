package com.prateek.learning.employees.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class CompanyRequestDTO {

    @NotEmpty(message = "{company.name.mandatory}")
    private String companyName;

    @NotEmpty(message = "{company.address.mandatory}")
    private String companyAddress;
}
