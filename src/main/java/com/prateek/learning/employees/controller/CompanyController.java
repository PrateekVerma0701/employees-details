package com.prateek.learning.employees.controller;

import com.prateek.learning.employees.dto.ResponseDTO;
import com.prateek.learning.employees.dto.request.CompanyRequestDTO;
import com.prateek.learning.employees.dto.response.CompanyDetailResponseDTO;
import com.prateek.learning.employees.service.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping(value = "api/v1.0/company/{contractorId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO findByContractorId(@PathVariable Long contractorId) {
        return companyService.findByContractorId(contractorId);
    }

    @PostMapping(value = "api/v1.0/company", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO saveCompany(@RequestBody CompanyRequestDTO companyRequestDTO) {
        return companyService.saveCompany(companyRequestDTO);
    }

    @GetMapping(value = "api/v1.0/company/delete/{contractorId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO deleteCompany(@PathVariable Long contractorId) {
        return companyService.deleteCompany(contractorId);
    }
}
