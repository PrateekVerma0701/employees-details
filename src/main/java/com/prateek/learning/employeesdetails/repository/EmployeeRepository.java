package com.prateek.learning.employeesdetails.repository;

import com.prateek.learning.employeesdetails.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends BaseJpaRepository<Employee, Long> {
    Employee findByEmployeeContractorId(Long employeeContractorId);

    List<Employee> findAll();
}
