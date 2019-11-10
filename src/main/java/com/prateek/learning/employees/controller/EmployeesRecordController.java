package com.prateek.learning.employees.controller;

import com.prateek.learning.employees.model.CompanyModel;
import com.prateek.learning.employees.model.EmployeeModel;
import com.prateek.learning.employees.response.EmployeeBasicDetailsResponse;
import com.prateek.learning.employees.service.EmployeeRecord;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping
public class EmployeesRecordController {

    private final EmployeeRecord employeeRecordService;

    @GetMapping(value = "v1.0/company/{companyId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CompanyModel findByCompanyId(@PathVariable Long companyId) {
        return employeeRecordService.findByCompanyId(companyId);
    }

    @GetMapping(value = "v1.0/employee/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeModel findByEmployeeId(@PathVariable Long employeeId) {
        return employeeRecordService.findByEmployeeId(employeeId);
    }

    @GetMapping(value = "v1.0/employee/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<EmployeeModel> findAllEmployees() {
        return employeeRecordService.findAllEmployees(PageRequest.of(0, 100));
    }

    @GetMapping(value = "v1.0/employee/basic/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeBasicDetailsResponse findByEmployeeIdBasicDetails(@PathVariable Long employeeId) {
        return employeeRecordService.findByEmployeeIdBasicDetails(employeeId);
    }

    @GetMapping(value = "v1.0/employee/basic/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<EmployeeBasicDetailsResponse> findAllEmployeesBasicDetails() {
        return employeeRecordService.findAllEmployeesBasicDetails(PageRequest.of(0, 100));
    }
}

