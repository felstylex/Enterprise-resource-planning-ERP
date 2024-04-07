package com.ERP.controllers;

import com.ERP.dtos.SalesOrderRecordDto;
import com.ERP.models.salesOrder.SalesOrder;
import com.ERP.repositories.SalesOrderRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
