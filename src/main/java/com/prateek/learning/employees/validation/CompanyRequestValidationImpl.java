package com.prateek.learning.employees.validation;

import com.prateek.learning.employees.dto.ErrorDTO;
import com.prateek.learning.employees.dto.ResponseDTO;
import com.prateek.learning.employees.dto.request.CompanyRequestDTO;
import com.prateek.learning.employees.utils.EmployeeRecordConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CompanyRequestValidationImpl implements CompanyRequestValidation {

    private final Validator validator;
    private final MessageSource messageSource;

    @Override
    public ResponseDTO validateCompanyRequest(CompanyRequestDTO companyRequestDTO) {
        ResponseDTO responseDTO = new ResponseDTO<>(Boolean.FALSE);
        Set<ConstraintViolation> constraintViolations = new HashSet<>(validator.validate(companyRequestDTO));
        for (ConstraintViolation<?> violation : constraintViolations) {
            responseDTO.setMessage(messageSource.getMessage("validation.error", EmployeeRecordConstant.EMPTY_ARGS, LocaleContextHolder.getLocale()));
            responseDTO.addError(new ErrorDTO("1001", messageSource.getMessage(violation.getMessage(), EmployeeRecordConstant.EMPTY_ARGS, LocaleContextHolder.getLocale())));

        }
        responseDTO.setStatus(CollectionUtils.isEmpty(responseDTO.getErrors()));
        return responseDTO;
    }
}
