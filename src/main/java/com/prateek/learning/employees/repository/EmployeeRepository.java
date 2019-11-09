package com.prateek.learning.employees.repository;

import com.prateek.learning.employees.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends BaseJpaRepository<Employee, Long> {
    Employee findByEmployeeContractorId(Long employeeContractorId);

    List<Employee> findAll();
}
