package io.nology.employee.employee.dtos;

import java.sql.Date;
import java.util.List;

import io.nology.employee.contract.Contract;
import io.nology.employee.employee.Employee.Department;
import io.nology.employee.employee.Employee.EmployeeType;
import jakarta.validation.constraints.NotBlank;

public class UpdateEmployeeDTO {

    @NotBlank
    private long id;

    private String name;

    private String email;

    private Date dob;

    private List<Contract> contracts;

    private EmployeeType employeeType;

    private Department department;

    public UpdateEmployeeDTO(@NotBlank String name, @NotBlank String email, @NotBlank Date dob,
            List<Contract> contracts, @NotBlank EmployeeType employeeType, @NotBlank Department department) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.contracts = contracts;
        this.employeeType = employeeType;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Date getDob() {
        return dob;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public Department getDepartment() {
        return department;
    }

}
