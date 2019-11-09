package com.prateek.learning.employeesdetails.repository;

import com.prateek.learning.employeesdetails.entity.Company;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends BaseJpaRepository<Company, Long> {
    Company findByCompanyId(Long companyId);
}
