package com.ERP.controllers;

import com.ERP.dtos.PurchaseOrderItemRecordDto;
import com.ERP.models.purchaseOrder.PurchaseOrderItem;
import com.ERP.repositories.PurchaseOrderItemRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PurchaseOrderItemController {

    @Autowired
    PurchaseOrderItemRepository orderItemRepository;

    @PostMapping("/purchase-order-item")
    public ResponseEntity<PurchaseOrderItem> savePurchaseOrderItem(@RequestBody PurchaseOrderItemRecordDto purchaseOrderItemRecordDto) {
        var purchaseOrderItemModel = new PurchaseOrderItem();
        BeanUtils.copyProperties(purchaseOrderItemRecordDto, purchaseOrderItemModel);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(orderItemRepository.save(purchaseOrderItemModel));
    }
}
