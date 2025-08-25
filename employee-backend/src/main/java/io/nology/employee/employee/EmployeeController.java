package io.nology.employee.employee;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.nology.employee.employee.dtos.CreateEmployeeDTO;
import io.nology.employee.employee.dtos.UpdateEmployeeDTO;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public ResponseEntity<List<Employee>> findAll() {
        List<Employee> employees = this.employeeService.getAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable long id) {
        try {
            Employee employee = this.employeeService.findById(id);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping()
    public ResponseEntity<Employee> createTodo(@Valid @RequestBody CreateEmployeeDTO data) {
        Employee saved = this.employeeService.create(data);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PatchMapping()
    public ResponseEntity<Employee> updateById(@Valid @RequestBody UpdateEmployeeDTO data) {
        Employee employee = this.employeeService.updateById(data);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable long id) {
        String deleted = this.employeeService.deleteById(id);
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }

}
