package com.prateek.learning.employees.service;

import com.prateek.learning.employees.dto.ErrorDTO;
import com.prateek.learning.employees.dto.ResponseDTO;
import com.prateek.learning.employees.dto.request.CompanyRequestDTO;
import com.prateek.learning.employees.dto.request.DepartmentRequestDTO;
import com.prateek.learning.employees.dto.response.CompanyDetailResponseDTO;
import com.prateek.learning.employees.entity.Company;
import com.prateek.learning.employees.entity.CompanyPK;
import com.prateek.learning.employees.entity.Department;
import com.prateek.learning.employees.repository.CompanyRepository;
import com.prateek.learning.employees.repository.DepartmentRepository;
import com.prateek.learning.employees.validation.CompanyRequestValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public ResponseDTO findByDepartmentId(Long departmentId) {
        ResponseDTO<Object> responseDTO = new ResponseDTO<>(Boolean.TRUE);
        Optional<Department> departmentRecord = departmentRepository.findByDepartmentId(departmentId);
        if (departmentRecord.isPresent()) {
            responseDTO.setStatus(Boolean.TRUE);
            responseDTO.setMessage(String.format("Record fetched for department id : %s ", departmentId));
            responseDTO.setData(departmentRecord);
            return responseDTO;
        } else {
            responseDTO.setStatus(Boolean.FALSE);
            responseDTO.setMessage(String.format("Department record can not be fetched. Record not present for department id : %s", departmentId));
            responseDTO.addError(new ErrorDTO("101", "Record does not exist."));
            return responseDTO;
        }
    }

    @Override
    public ResponseDTO saveDepartment(DepartmentRequestDTO departmentRequestDTO) {
            Department department = new Department();
            department.setDepartmentDetail(departmentRequestDTO.getDepartmentDetail());
            department.setDepartmentName(departmentRequestDTO.getDepartmentName());
            departmentRepository.save(department);
            return new ResponseDTO(true, "Department record created successfully");
    }

    @Override
    public ResponseDTO deleteDepartment(Long departmentId) {
        Optional<Department> departmentToBeDeleted = departmentRepository.findByDepartmentId(departmentId);
        if (departmentToBeDeleted.isPresent()) {
            departmentRepository.delete(departmentToBeDeleted.get());
            return new ResponseDTO(true, String.format("Department record deleted successfully for department id : %s", departmentId));
        } else {
            ResponseDTO responseDTO = new ResponseDTO<>(Boolean.FALSE);
            responseDTO.setMessage(String.format("Department record can not be deleted. Record not present for department id : %s", departmentId));
            responseDTO.addError(new ErrorDTO("101", "Record does not exist."));
            return responseDTO;
        }
    }
}
