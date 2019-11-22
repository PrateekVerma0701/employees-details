package com.prateek.learning.employees.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class CompanyPK implements Serializable {
    private static final long serialVersionUID = -5073745645379676235L;

    @Column(name = "registration_id", nullable = false, insertable = false, updatable = false)
    private Long registrationId;

    @Column(name = "global_company_id", nullable = false, insertable = false, updatable = false)
    private Long globalCompanyId;
}