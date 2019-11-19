package com.prateek.learning.employees.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class DepartmentRequestDTO {

    @NotEmpty(message = "{department.name.mandatory}")
    private String departmentName;

    @NotEmpty(message = "{department.detail.mandatory}")
    private String departmentDetail;
}
