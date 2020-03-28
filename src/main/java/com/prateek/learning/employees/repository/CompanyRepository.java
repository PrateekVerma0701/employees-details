package com.prateek.learning.employees.repository;

import com.prateek.learning.employees.entity.Company;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends BaseJpaRepository<Company, Long> {
    Optional<Company> findByContractorId(Long contractorId);
}
