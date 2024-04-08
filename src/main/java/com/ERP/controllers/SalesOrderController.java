package com.ERP.controllers;

import com.ERP.dtos.SalesOrderRecordDto;
import com.ERP.models.salesOrder.SalesOrder;
import com.ERP.repositories.SalesOrderRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SalesOrderController {

    @Autowired
    SalesOrderRepository salesOrderRepository;

    @PostMapping("/sales-order")
    public ResponseEntity<SalesOrder> saveSalesOrder(@RequestBody SalesOrderRecordDto salesOrderRecordDto) {
        var salesOrderModel = new SalesOrder();
        BeanUtils.copyProperties(salesOrderRecordDto, salesOrderModel);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(salesOrderRepository.save(salesOrderModel));
    }

    @GetMapping("/sales-order")
    public ResponseEntity<List<SalesOrder>> getAllSalesOrders() {
        return ResponseEntity.status(HttpStatus.OK).body(salesOrderRepository.findAll());
    }

    @GetMapping("/sales-order/{id}")
    public ResponseEntity<Object> findSalesOrderById(@PathVariable(value = "id") Long id) {
        Optional<SalesOrder> salesOrder = salesOrderRepository.findById(id);

        return salesOrder.<ResponseEntity<Object>>map(value -> ResponseEntity.status(HttpStatus.OK)
                .body(value)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Pedido de venda não encontrado!"));
    }

    @PutMapping("/sales-order/{id}")
    public ResponseEntity<Object> updateSalesOrder(@PathVariable(value = "id") Long id, @RequestBody SalesOrderRecordDto salesOrderRecordDto) {
        Optional<SalesOrder> salesOrder = salesOrderRepository.findById(id);

        if(salesOrder.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido de venda não encontrado!");
        }

        var salesOrderModel = salesOrder.get();
        BeanUtils.copyProperties(salesOrderRecordDto, salesOrderModel);

        return ResponseEntity.status(HttpStatus.OK).body(salesOrderRepository.save(salesOrderModel));
    }

    @DeleteMapping("/sales-order/{id}")
    public ResponseEntity<Object> deleteSalesOrder(@PathVariable(value = "id") Long id) {
        Optional<SalesOrder> salesOrder = salesOrderRepository.findById(id);

        if(salesOrder.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido de venda não encontrado!");
        }

        salesOrderRepository.delete(salesOrder.get());

        return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso!");
    }
}
