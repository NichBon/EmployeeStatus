package io.nology.employee.employee.dtos;

import java.sql.Date;
import java.util.List;

import io.nology.employee.contract.Contract;
import io.nology.employee.employee.Employee.Department;
import io.nology.employee.employee.Employee.EmployeeType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateEmployeeDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @NotNull
    private Date dob;

    private List<Contract> contracts;

    @NotNull
    private EmployeeType employeeType;

    @NotNull
    private Department department;

    public CreateEmployeeDTO(@NotBlank String name, @NotBlank String email, @NotBlank Date dob, @NotBlank Integer age,
            List<Contract> contracts, @NotBlank EmployeeType employeeType, @NotBlank Integer salary,
            @NotBlank Float hours, @NotBlank Department department) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.contracts = contracts;
        this.employeeType = employeeType;
        this.department = department;
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
