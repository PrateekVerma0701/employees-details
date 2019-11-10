package com.prateek.learning.employees.service;

import com.prateek.learning.employees.entity.Company;
import com.prateek.learning.employees.entity.Employee;
import com.prateek.learning.employees.dto.CompanyDetailResponseDTO;
import com.prateek.learning.employees.dto.EmployeeDetailResponseDTO;
import com.prateek.learning.employees.repository.CompanyRepository;
import com.prateek.learning.employees.repository.EmployeeRepository;
import com.prateek.learning.employees.dto.EmployeeBasicDetailResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeRecordImpl implements EmployeeRecord {

    private final CompanyRepository companyRepository;
    private final EmployeeRepository employeeRepository;

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public CompanyDetailResponseDTO findByCompanyId(Long companyId) {
        Company company = companyRepository.findByCompanyId(companyId);
        return CompanyDetailResponseDTO.createCompanyResponseModel(company);
    }

    @Override
    public EmployeeDetailResponseDTO findByEmployeeId(Long employeeContractorId) {
        Employee employee = employeeRepository.findByEmployeeContractorId(employeeContractorId);
        return EmployeeDetailResponseDTO.createEmployeeResponseModel(employee);
    }

    @Override
    public Page<EmployeeDetailResponseDTO> findAllEmployees(Pageable pageable) {
        Page<Employee> allEmployees = employeeRepository.findAll(pageable);
        List<EmployeeDetailResponseDTO> employeeDetailResponseDTOS = EmployeeDetailResponseDTO.createAllEmployeeResponseModel(allEmployees);
        return new PageImpl<>(employeeDetailResponseDTOS, pageable, allEmployees.getTotalElements());
    }

    @Override
    public EmployeeBasicDetailResponseDTO findByEmployeeIdBasicDetails(Long employeeContractorId) {
        Employee employee = employeeRepository.findByEmployeeContractorId(employeeContractorId);
        return EmployeeBasicDetailResponseDTO.createEmployeeBasicResponseModel(employee);
    }

    @Override
    public Page<EmployeeBasicDetailResponseDTO> findAllEmployeesBasicDetails(Pageable pageable) {
        Page<Employee> allEmployees = employeeRepository.findAll(pageable);
        List<EmployeeBasicDetailResponseDTO> allEmployeeBasicResponseModel = EmployeeBasicDetailResponseDTO.createAllEmployeeBasicResponseModel(allEmployees);
        return new PageImpl<>(allEmployeeBasicResponseModel, pageable, allEmployees.getTotalElements());
    }
}
