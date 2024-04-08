package com.ERP.controllers;

import com.ERP.dtos.PurchaseOrderItemRecordDto;
import com.ERP.models.purchaseOrder.PurchaseOrderItem;
import com.ERP.repositories.PurchaseOrderItemRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PurchaseOrderItemController {

    @Autowired
    PurchaseOrderItemRepository purchaseOrderItemRepository;

    @PostMapping("/purchase-order-item")
    public ResponseEntity<PurchaseOrderItem> savePurchaseOrderItem(@RequestBody PurchaseOrderItemRecordDto purchaseOrderItemRecordDto) {
        var purchaseOrderItemModel = new PurchaseOrderItem();
        BeanUtils.copyProperties(purchaseOrderItemRecordDto, purchaseOrderItemModel);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(purchaseOrderItemRepository.save(purchaseOrderItemModel));
    }

    @GetMapping("/purchase-order-item")
    public ResponseEntity<List<PurchaseOrderItem>> getAllPurchaseOrderItems() {
        return ResponseEntity.status(HttpStatus.OK).body(purchaseOrderItemRepository.findAll());
    }

    @GetMapping("/purchase-order-item/{id}")
    public ResponseEntity<Object> findPurchaseOrderItemById(@PathVariable(value = "id") Long id) {
        Optional<PurchaseOrderItem> purchaseOrderItem = purchaseOrderItemRepository.findById(id);

        return purchaseOrderItem.<ResponseEntity<Object>>map(value -> ResponseEntity.status(HttpStatus.OK)
                .body(value)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Item do pedido de compra não encontrado!"));
    }
}
