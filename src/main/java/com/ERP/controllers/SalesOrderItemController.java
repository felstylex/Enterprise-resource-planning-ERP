package com.ERP.controllers;

import com.ERP.dtos.SalesOrderItemRecordDto;
import com.ERP.models.salesOrder.SalesOrderItem;
import com.ERP.repositories.SalesOrderItemRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SalesOrderItemController {

    @Autowired
    SalesOrderItemRepository salesOrderItemRepository;

    @PostMapping("/sales-order-item")
    public ResponseEntity<SalesOrderItem> saveSalesOrderItem(@RequestBody SalesOrderItemRecordDto salesOrderItemRecordDto) {
        var salesOrderItemModel = new SalesOrderItem();
        BeanUtils.copyProperties(salesOrderItemRecordDto, salesOrderItemModel);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(salesOrderItemRepository.save(salesOrderItemModel));
    }

    @GetMapping("/sales-order-item")
    public ResponseEntity<List<SalesOrderItem>> getAllSalesOrderItems() {
        return ResponseEntity.status(HttpStatus.OK).body(salesOrderItemRepository.findAll());
    }

    @GetMapping("/sales-order-item/{id}")
    public ResponseEntity<Object> findSalesOrderItemById(@PathVariable(value = "id") Long id) {
        Optional<SalesOrderItem> salesOrderItem = salesOrderItemRepository.findById(id);

        return salesOrderItem.<ResponseEntity<Object>>map(value -> ResponseEntity.status(HttpStatus.OK)
                .body(value)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Item do pedido de venda não encontrado!"));
    }

    @PutMapping("/sales-order-item/{id}")
    public ResponseEntity<Object> updateSalesOrderItem(@PathVariable(value = "id") Long id, @RequestBody SalesOrderItemRecordDto salesOrderItemRecordDto) {
        Optional<SalesOrderItem> salesOrderItem = salesOrderItemRepository.findById(id);

        if(salesOrderItem.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item do pedido de venda não encontrado!");
        }

        var salesOrderItemModel = salesOrderItem.get();
        BeanUtils.copyProperties(salesOrderItemRecordDto, salesOrderItemModel);

        return ResponseEntity.status(HttpStatus.OK).body(salesOrderItemRepository.save(salesOrderItemModel));
    }

    @DeleteMapping("/sales-order-item/{id}")
    public ResponseEntity<Object> deleteSalesOrderItem(@PathVariable(value = "id") Long id) {
        Optional<SalesOrderItem> salesOrderItem = salesOrderItemRepository.findById(id);

        if(salesOrderItem.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item do pedido de venda não encontrado!");
        }

        salesOrderItemRepository.delete(salesOrderItem.get());

        return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso!");
    }
}
