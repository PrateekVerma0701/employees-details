package com.prateek.learning.employees.validation;

import com.prateek.learning.employees.dto.ResponseDTO;
import com.prateek.learning.employees.dto.request.CompanyRequestDTO;

public interface CompanyRequestValidation {
    ResponseDTO validateCompanyRequest(CompanyRequestDTO companyRequestDTO);
}
