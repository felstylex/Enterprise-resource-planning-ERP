package com.ERP.controllers;

import com.ERP.dtos.SupplierRecordDto;
import com.ERP.models.supplier.Supplier;
import com.ERP.repositories.SupplierRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/supplier")
    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        return ResponseEntity.status(HttpStatus.OK).body(supplierRepository.findAll());
    }

    @GetMapping("/supplier/{id}")
    public ResponseEntity<Object> findSupplierById(@PathVariable(value = "id") Long id) {
        Optional<Supplier> supplier = supplierRepository.findById(id);

        return supplier.<ResponseEntity<Object>>map(value -> ResponseEntity.status(HttpStatus.OK)
                .body(value)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Fornecedor não encontrado!"));
    }
    @PutMapping("/supplier/{id}")
    public ResponseEntity<Object> updateSupplier(@PathVariable(value = "id") Long id, @RequestBody SupplierRecordDto supplierRecordDto) {
        Optional<Supplier> supplier = supplierRepository.findById(id);

        if(supplier.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fornecedor não encontrado!");
        }

        var supplierModel = supplier.get();
        BeanUtils.copyProperties(supplierRecordDto, supplierModel);

        return ResponseEntity.status(HttpStatus.OK).body(supplierRepository.save(supplierModel));
    }

    @DeleteMapping("/supplier/{id}")
    public ResponseEntity<Object> deleteSupplier(@PathVariable(value = "id") Long id) {
        Optional<Supplier> supplier = supplierRepository.findById(id);

        if(supplier.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fornecedor não encontrado!");
        }

        supplierRepository.delete(supplier.get());

        return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso!");
    }
}
