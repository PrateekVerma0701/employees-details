package com.prateek.learning.employees.repository;

import com.prateek.learning.employees.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeRepository extends BaseJpaRepository<Employee, Long> {
    Employee findByEmployeeContractorId(Long employeeContractorId);

    Page<Employee> findAll(Pageable pageable);
}
