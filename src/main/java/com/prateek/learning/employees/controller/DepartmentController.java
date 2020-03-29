package com.prateek.learning.employees.controller;

import com.prateek.learning.employees.dto.ResponseDTO;
import com.prateek.learning.employees.dto.request.CompanyRequestDTO;
import com.prateek.learning.employees.dto.request.DepartmentRequestDTO;
import com.prateek.learning.employees.service.CompanyService;
import com.prateek.learning.employees.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping(value = "api/v1.0/department/{departmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO findByDepartmentId(@PathVariable Long departmentId) {
        return departmentService.findByDepartmentId(departmentId);
    }

    @PostMapping(value = "api/v1.0/department", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO saveCompany(@RequestBody DepartmentRequestDTO departmentRequestDTO) {
        return departmentService.saveDepartment(departmentRequestDTO);
    }

    @GetMapping(value = "api/v1.0/department/delete/{departmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO deleteCompany(@PathVariable Long departmentId) {
        return departmentService.deleteDepartment(departmentId);
    }
}
