package com.ERP.controllers;

import com.ERP.dtos.PurchaseOrderRecordDto;
import com.ERP.models.purchaseOrder.PurchaseOrder;
import com.ERP.repositories.PurchaseOrderRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PurchaseOrderController {

    @Autowired
    PurchaseOrderRepository orderRepository;

    @PostMapping("/purchase-order")
    public ResponseEntity<PurchaseOrder> savePurchaseOrder(@RequestBody PurchaseOrderRecordDto purchaseOrderRecordDto) {
        var purchaseOrderModel = new PurchaseOrder();
        BeanUtils.copyProperties(purchaseOrderRecordDto, purchaseOrderModel);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(orderRepository.save(purchaseOrderModel));
    }
}
