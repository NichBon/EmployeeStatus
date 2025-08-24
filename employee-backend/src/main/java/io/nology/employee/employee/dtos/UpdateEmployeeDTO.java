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

    private Integer age;

    private List<Contract> contracts;

    private EmployeeType employeeType;

    private Integer salary;

    private Float hours;

    private Department department;

    public UpdateEmployeeDTO(@NotBlank String name, @NotBlank String email, @NotBlank Date dob, @NotBlank Integer age,
            List<Contract> contracts, @NotBlank EmployeeType employeeType, @NotBlank Integer salary,
            @NotBlank Float hours, @NotBlank Department department) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.age = age;
        this.contracts = contracts;
        this.employeeType = employeeType;
        this.salary = salary;
        this.hours = hours;
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

    public Integer getAge() {
        return age;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public Integer getSalary() {
        return salary;
    }

    public Float getHours() {
        return hours;
    }

    public Department getDepartment() {
        return department;
    }

}
