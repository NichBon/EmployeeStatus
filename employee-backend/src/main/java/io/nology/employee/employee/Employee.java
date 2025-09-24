package io.nology.employee.employee;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.nology.employee.contract.Contract;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotBlank
    private String name;

    @Column
    @NotBlank
    private String email;

    @Column
    private Date dob;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contract> contracts = new ArrayList<>();

    public enum EmployeeType {
        FULL_TIME,
        PART_TIME,
        CASUAl,
        INACTIVE
    }

    @Column
    private EmployeeType employeeType;

    public enum Department {
        SALES,
        MARKETING,
        FINANCE,
        TECHNICAL,
        ADMIN
    }

    @Column
    private Department department;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    // @JsonProperty
    // public Integer getAge() {
    // if (dob == null)
    // return null;
    // LocalDate birthDate =
    // dob.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    // return Period.between(birthDate, LocalDate.now()).getYears();
    // }

    // @JsonProperty
    // public Integer getSalary() {
    // if (contracts == null || contracts.isEmpty())
    // return 0;
    // return contracts.stream()
    // .map(Contract::getCost)
    // .filter(Objects::nonNull)
    // .reduce(0, Integer::sum);
    // }

    // @JsonProperty
    // public Float getHours() {
    // if (contracts == null || contracts.isEmpty())
    // return 0f;

    // return contracts.stream()
    // .map(Contract::getHours)
    // .filter(Objects::nonNull)
    // .reduce(Float.valueOf(0f), Float::sum);
    // }

}
