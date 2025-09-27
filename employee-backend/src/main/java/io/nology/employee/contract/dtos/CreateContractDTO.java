package io.nology.employee.contract.dtos;

import java.time.LocalDate;

import io.nology.employee.contract.Contract.ContractType;
import io.nology.employee.employee.Employee;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table
public class CreateContractDTO {

    @NotNull
    private ContractType contractType;

    @NotNull
    private LocalDate startDate;

    private LocalDate endDate;

    @NotNull
    private Employee employee;

    @NotBlank
    private Integer cost;

    @NotNull
    Float hours;

    public CreateContractDTO(@NotNull ContractType contractType, @NotNull LocalDate startDate, LocalDate endDate,
            @NotNull Employee employee, @NotBlank Integer cost, @NotNull Float hours) {
        this.contractType = contractType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.employee = employee;
        this.cost = cost;
        this.hours = hours;
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