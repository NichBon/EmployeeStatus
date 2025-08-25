package io.nology.employee.contract;

import java.time.LocalDate;

import io.nology.employee.employee.Employee;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public enum ContractType {
        FULL_TIME,
        PART_TIME,
        CASUAL
    }

    @Column
    @NotBlank
    private ContractType contractType;

    @Column
    @NotBlank
    private LocalDate startDate;

    @Column
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column
    @NotBlank
    private Integer cost;

    @Column
    Integer hours;

    public Contract(Long id, @NotBlank ContractType contractType, @NotBlank LocalDate startDate, LocalDate endDate,
            Employee employee, @NotBlank Integer cost, Integer hours) {
        this.id = id;
        this.contractType = contractType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.employee = employee;
        this.cost = cost;
        this.hours = hours;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ContractType getContractType() {
        return contractType;
    }

    public void setContractType(ContractType contractType) {
        this.contractType = contractType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

}
