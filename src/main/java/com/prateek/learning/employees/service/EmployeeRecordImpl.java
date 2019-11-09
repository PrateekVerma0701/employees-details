package com.prateek.learning.employees.service;

import com.prateek.learning.employees.entity.Company;
import com.prateek.learning.employees.entity.Employee;
import com.prateek.learning.employees.model.CompanyModel;
import com.prateek.learning.employees.model.EmployeeModel;
import com.prateek.learning.employees.repository.CompanyRepository;
import com.prateek.learning.employees.repository.EmployeeRepository;
import com.prateek.learning.employees.response.EmployeeBasicDetailsResponse;
import lombok.RequiredArgsConstructor;
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
    public CompanyModel findByCompanyId(Long companyId) {
        Company company = companyRepository.findByCompanyId(companyId);
        return CompanyModel.createCompanyResponseModel(company);
    }

    @Override
    public EmployeeModel findByEmployeeId(Long employeeContractorId) {
        Employee employee = employeeRepository.findByEmployeeContractorId(employeeContractorId);
        return EmployeeModel.createEmployeeResponseModel(employee);
    }

    @Override
    public List<EmployeeModel> findAllEmployees() {
        List<Employee> allEmployees = employeeRepository.findAll();
        return EmployeeModel.createAllEmployeeResponseModel(allEmployees);
    }

    @Override
    public EmployeeBasicDetailsResponse findByEmployeeIdBasicDetails(Long employeeContractorId) {
        Employee employee = employeeRepository.findByEmployeeContractorId(employeeContractorId);
        return EmployeeBasicDetailsResponse.createEmployeeBasicResponseModel(employee);
    }

    @Override
    public List<EmployeeBasicDetailsResponse> findAllEmployeesBasicDetails() {
        List<Employee> allEmployees = employeeRepository.findAll();
        return EmployeeBasicDetailsResponse.createAllEmployeeBasicResponseModel(allEmployees);
    }
}
