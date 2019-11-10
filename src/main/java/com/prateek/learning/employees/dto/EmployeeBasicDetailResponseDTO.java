package com.prateek.learning.employees.dto;

import com.prateek.learning.employees.entity.Address;
import com.prateek.learning.employees.entity.Employee;
import com.prateek.learning.employees.entity.Project;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.prateek.learning.employees.utils.EmployeeRecordUtils.COMMA_DELIMITER_WITH_SPACE;
import static com.prateek.learning.employees.utils.EmployeeRecordUtils.SPACE;

@Getter
@Setter
public class EmployeeBasicDetailResponseDTO {
    private String fullName;
    private Long employeeContractorId;
    private String companyName;
    private Long companyId;
    private String departmentName;
    private String projects;
    private String phoneNumber;
    private String email;
    private String address;
    private String state;
    private String country;

    public static EmployeeBasicDetailResponseDTO createEmployeeBasicResponseModel(Employee employee) {
        EmployeeBasicDetailResponseDTO employeeBasicDetailResponseDTO = new EmployeeBasicDetailResponseDTO();

        employeeBasicDetailResponseDTO.setEmployeeContractorId(employee.getEmployeeContractorId());
        employeeBasicDetailResponseDTO.setDepartmentName(employee.getDepartment().getDepartmentName());
        employeeBasicDetailResponseDTO.setProjects(getEmployeeProjects(employee.getProjects()));
        employeeBasicDetailResponseDTO.setCompanyName(employee.getCompany().getCompanyName());
        employeeBasicDetailResponseDTO.setCompanyId(employee.getCompany().getCompanyId());
        employeeBasicDetailResponseDTO.setFullName(employee.getFirstName().concat(SPACE).concat(employee.getLastName()));
        employeeBasicDetailResponseDTO.setPhoneNumber(employee.getPhoneNumber());
        employeeBasicDetailResponseDTO.setEmail(employee.getEmail());
        employeeBasicDetailResponseDTO.setAddress(getEmployeeAddress(employee.getAddress()));
        employeeBasicDetailResponseDTO.setState(employee.getAddress().getState());
        employeeBasicDetailResponseDTO.setCountry(employee.getAddress().getCountry());

        return employeeBasicDetailResponseDTO;
    }

    public static List<EmployeeBasicDetailResponseDTO> createAllEmployeeBasicResponseModel(Page<Employee> employees) {
        List<EmployeeBasicDetailResponseDTO> employeeBasicDetailResponseDTOList = new ArrayList<>();
        employees.forEach(employee -> {
            EmployeeBasicDetailResponseDTO employeeBasicDetailResponseDTO = new EmployeeBasicDetailResponseDTO();

            employeeBasicDetailResponseDTO.setEmployeeContractorId(employee.getEmployeeContractorId());
            employeeBasicDetailResponseDTO.setDepartmentName(employee.getDepartment().getDepartmentName());
            employeeBasicDetailResponseDTO.setProjects(getEmployeeProjects(employee.getProjects()));
            employeeBasicDetailResponseDTO.setCompanyName(employee.getCompany().getCompanyName());
            employeeBasicDetailResponseDTO.setCompanyId(employee.getCompany().getCompanyId());
            employeeBasicDetailResponseDTO.setFullName(employee.getFirstName().concat(SPACE).concat(employee.getLastName()));
            employeeBasicDetailResponseDTO.setPhoneNumber(employee.getPhoneNumber());
            employeeBasicDetailResponseDTO.setEmail(employee.getEmail());
            employeeBasicDetailResponseDTO.setAddress(getEmployeeAddress(employee.getAddress()));
            employeeBasicDetailResponseDTO.setState(employee.getAddress().getState());
            employeeBasicDetailResponseDTO.setCountry(employee.getAddress().getCountry());

            employeeBasicDetailResponseDTOList.add(employeeBasicDetailResponseDTO);

        });
        return employeeBasicDetailResponseDTOList;
    }

    private static String getEmployeeProjects(List<Project> projects) {
        return projects
                .stream()
                .map(Project::getProjectName)
                .collect(Collectors.joining(COMMA_DELIMITER_WITH_SPACE));
    }

    private static String getEmployeeAddress(Address address) {
        return address.getHouseNumber().concat(SPACE)
                .concat(address.getAddressLine1().concat(COMMA_DELIMITER_WITH_SPACE)
                        .concat(address.getAddressLine2()).concat(COMMA_DELIMITER_WITH_SPACE)
                        .concat(address.getCity()).concat(COMMA_DELIMITER_WITH_SPACE)
                        .concat(address.getPinCode()));
    }
}
