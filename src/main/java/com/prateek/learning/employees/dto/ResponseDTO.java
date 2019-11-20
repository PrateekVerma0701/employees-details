package com.prateek.learning.employees.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDTO<T> {

    private boolean status = true;
    private String message;
    private T data;

    private ArrayList<ErrorDTO> errors = new ArrayList<>();

    public ResponseDTO(Boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public ResponseDTO(Boolean status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ResponseDTO(Boolean status) {
        this.status = status;
    }

    public void addError(ErrorDTO errorDTO) {
        this.errors.add(errorDTO);
    }

    public void addErrors(Collection<ErrorDTO> errors) {
        this.errors.addAll(errors);
    }
}
