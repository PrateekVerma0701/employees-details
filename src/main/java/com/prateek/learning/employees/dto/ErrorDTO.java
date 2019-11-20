package com.prateek.learning.employees.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorDTO {
    private static final long serialVersionId = 1L;
    private String errorCode;
    private String errorMessage;
}
