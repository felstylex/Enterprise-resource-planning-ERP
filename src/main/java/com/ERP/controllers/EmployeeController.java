package com.ERP.controllers;

import com.ERP.dtos.EmployeeRecordDto;
import com.ERP.models.employee.Employee;
import com.ERP.repositories.EmployeeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @PostMapping("/employee")
    public ResponseEntity<Employee> saveEmployee(@RequestBody @Valid EmployeeRecordDto employeeRecordDto) {
        var employeeModel = new Employee();
        BeanUtils.copyProperties(employeeRecordDto, employeeModel);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(employeeRepository.save(employeeModel));
    }

    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.status(HttpStatus.OK).body(employeeRepository.findAll());
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Object> findEmployeeById(@PathVariable(value = "id") Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        return employee.<ResponseEntity<Object>>map(value -> ResponseEntity.status(HttpStatus.OK)
                .body(value)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Funcionário não encontrado!"));
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Object> updateEmployee(@PathVariable(value = "id") Long id, @RequestBody @Valid EmployeeRecordDto employeeRecordDto) {
        Optional<Employee> employee = employeeRepository.findById(id);

        if(employee.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionário não encontrado!");
        }

        var employeeModel = employee.get();
        BeanUtils.copyProperties(employeeRecordDto, employeeModel);

        return ResponseEntity.status(HttpStatus.OK).body(employeeRepository.save(employeeModel));
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable(value = "id") Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        if(employee.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionário não encontrado!");
        }

        employeeRepository.delete(employee.get());

        return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso!");
    }

}
