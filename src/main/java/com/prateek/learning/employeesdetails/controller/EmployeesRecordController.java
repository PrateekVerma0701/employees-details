package com.prateek.learning.employeesdetails.controller;

import com.prateek.learning.employeesdetails.model.CompanyModel;
import com.prateek.learning.employeesdetails.model.EmployeeModel;
import com.prateek.learning.employeesdetails.response.EmployeeBasicDetailsResponse;
import com.prateek.learning.employeesdetails.service.EmployeeRecord;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public List<EmployeeModel> findAllEmployees() {
        return employeeRecordService.findAllEmployees();
    }

    @GetMapping(value = "v1.0/employee/basic/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeBasicDetailsResponse findByEmployeeIdBasicDetails(@PathVariable Long employeeId) {
        return employeeRecordService.findByEmployeeIdBasicDetails(employeeId);
    }

    @GetMapping(value = "v1.0/employee/basic/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EmployeeBasicDetailsResponse> findAllEmployeesBasicDetails() {
        return employeeRecordService.findAllEmployeesBasicDetails();
    }
}


