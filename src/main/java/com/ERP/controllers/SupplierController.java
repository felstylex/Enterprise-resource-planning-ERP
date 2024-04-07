package com.ERP.controllers;

import com.ERP.dtos.SupplierRecordDto;
import com.ERP.models.supplier.Supplier;
import com.ERP.repositories.SupplierRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SupplierController {

    @Autowired
    SupplierRepository supplierRepository;

    @PostMapping("/supplier")
    public ResponseEntity<Supplier> saveSupplier(@RequestBody SupplierRecordDto supplierRecordDto) {
        var supplierModel = new Supplier();
        BeanUtils.copyProperties(supplierRecordDto, supplierModel);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(supplierRepository.save(supplierModel));
    }
}
