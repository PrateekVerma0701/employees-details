package com.prateek.learning.employees.repository;

import com.prateek.learning.employees.entity.Company;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends BaseJpaRepository<Company, Long> {
    Company findByContractorId(Long contractorId);
}
