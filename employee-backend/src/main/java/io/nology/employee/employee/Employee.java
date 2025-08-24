package io.nology.employee.employee;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import io.nology.employee.contract.Contract;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
    @NotBlank
    private Date dob;

    @Column
    @NotBlank
    private Integer age;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn
    private List<Contract> contracts = new ArrayList<>();

    public enum EmployeeType {
        FULL_TIME,
        PART_TIME,
        CASUAl,
        INACTIVE
    }

    @Column
    @NotBlank
    private EmployeeType employeeType;

    @Column
    @NotBlank
    private Integer salary;

    @Column
    @NotBlank
    private Float hours;

    public enum Department {
        SALES,
        MARKETING,
        FINANCE,
        TECHNICAL,
        ADMIN
    }

    @Column
    @NotBlank
    private Department department;

    public Employee(Long id, @NotBlank String name, @NotBlank String email, @NotBlank Date dob, @NotBlank Integer age,
            List<Contract> contracts, @NotBlank EmployeeType employeeType, @NotBlank Integer salary,
            @NotBlank Float hours, @NotBlank Department department) {
        this.id = id;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Float getHours() {
        return hours;
    }

    public void setHours(Float hours) {
        this.hours = hours;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

}
