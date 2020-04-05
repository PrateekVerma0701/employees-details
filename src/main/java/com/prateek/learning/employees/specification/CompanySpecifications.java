package com.prateek.learning.employees.specification;

import com.prateek.learning.employees.entity.Company;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class CompanySpecifications {

    public static Specification<Company> isInCompanyName(List<String> companyNameList) {
        return (root, query, builder) -> root.get("companyName").in(companyNameList);
    }
}
