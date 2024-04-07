package com.ERP.controllers;

import com.ERP.dtos.SalesOrderItemRecordDto;
import com.ERP.models.salesOrder.SalesOrderItem;
import com.ERP.repositories.SalesOrderItemRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalesOrderItemController {

    @Autowired
    SalesOrderItemRepository orderItemRepository;

    @PostMapping("/sales-order-item")
    public ResponseEntity<SalesOrderItem> saveSalesOrderItem(@RequestBody SalesOrderItemRecordDto salesOrderItemRecordDto) {
        var salesOrderItemModel = new SalesOrderItem();
        BeanUtils.copyProperties(salesOrderItemRecordDto, salesOrderItemModel);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(orderItemRepository.save(salesOrderItemModel));
    }
}
