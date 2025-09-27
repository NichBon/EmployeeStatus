package io.nology.employee.contract.dtos;

import java.time.LocalDate;

import io.nology.employee.contract.Contract.ContractType;
import io.nology.employee.employee.Employee;
import jakarta.validation.constraints.NotBlank;

public class UpdateContractDTO {

    @NotBlank
    private long id;

    private ContractType contractType;

    private LocalDate startDate;

    private LocalDate endDate;

    private Employee employee;

    private Integer cost;

    Float hours;

    public UpdateContractDTO(@NotBlank long id, ContractType contractType, LocalDate startDate, LocalDate endDate,
            Employee employee, Integer cost, Float hours) {
        this.id = id;
        this.contractType = contractType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.employee = employee;
        this.cost = cost;
        this.hours = hours;
    }

    public long getId() {
        return id;
    }

    public ContractType getContractType() {
        return contractType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Integer getCost() {
        return cost;
    }

    public Float getHours() {
        return hours;
    }

}