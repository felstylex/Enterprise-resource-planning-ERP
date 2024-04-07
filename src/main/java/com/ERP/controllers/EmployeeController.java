package com.ERP.controllers;

import com.ERP.dtos.EmployeeRecordDto;
import com.ERP.models.employee.Employee;
import com.ERP.repositories.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @PostMapping("/employee")
    public ResponseEntity<Employee> saveEmployee(@RequestBody EmployeeRecordDto employeeRecordDto) {
        var employeeModel = new Employee();
        BeanUtils.copyProperties(employeeRecordDto, employeeModel);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(employeeRepository.save(employeeModel));
    }
}
