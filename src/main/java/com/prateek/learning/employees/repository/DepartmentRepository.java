package com.prateek.learning.employees.repository;

import com.prateek.learning.employees.entity.Company;
import com.prateek.learning.employees.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends BaseJpaRepository<Department, Long> {
    Optional<Department> findByDepartmentId(Long contractorId);
}
