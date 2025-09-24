package io.nology.employee.employee;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import io.nology.employee.contract.ContractService;
import io.nology.employee.employee.dtos.CreateEmployeeDTO;
import io.nology.employee.employee.dtos.UpdateEmployeeDTO;
import jakarta.persistence.EntityNotFoundException;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;
    private ContractService contractService;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper,
            ContractService contractService) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
        this.contractService = contractService;
    }

    public List<Employee> getAll() {
        List<Employee> employees = this.employeeRepository.findAll();
        return employees;
    }

    public Employee findById(long id) {
        Employee foundEmployee = this.employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No Employee with id: " + id));
        return foundEmployee;
    }

    public String deleteById(long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return ("DELETED ID" + id);
        } else {
            throw new EntityNotFoundException("No Employee with id: " + id);
        }
    }

    public Employee create(CreateEmployeeDTO data) {
        System.out.println(data);
        Employee newEmployee = modelMapper.map(data, Employee.class);
        Employee savedEmployee = this.employeeRepository.save(newEmployee);
        return savedEmployee;
    }

    public Employee updateById(UpdateEmployeeDTO data) {
        Employee foundEmployee = findById(data.getId());
        modelMapper.map(data, foundEmployee);
        this.employeeRepository.save(foundEmployee);
        return foundEmployee;
    }

}