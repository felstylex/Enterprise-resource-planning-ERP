package com.ERP.controllers;

import com.ERP.dtos.PurchaseOrderRecordDto;
import com.ERP.models.purchaseOrder.PurchaseOrder;
import com.ERP.models.purchaseOrder.PurchaseOrderItem;
import com.ERP.repositories.PurchaseOrderRepository;
import com.ERP.services.CalculationService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class PurchaseOrderController {

    @Autowired
    PurchaseOrderRepository purchaseOrderRepository;

    @Autowired
    CalculationService calculationService;

    @PostMapping("/purchase-order")
    public ResponseEntity<PurchaseOrder> savePurchaseOrder(@RequestBody @Valid PurchaseOrderRecordDto purchaseOrderRecordDto) {
        var purchaseOrderModel = new PurchaseOrder();
        BeanUtils.copyProperties(purchaseOrderRecordDto, purchaseOrderModel);

        BigDecimal totalPrice = calculationService.calculateTotalPrice(purchaseOrderModel);
        purchaseOrderModel.setTotal_price(totalPrice);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(purchaseOrderRepository.save(purchaseOrderModel));
    }

    @GetMapping("/purchase-order")
    public ResponseEntity<List<PurchaseOrder>> getAllPurchaseOrders() {
        return ResponseEntity.status(HttpStatus.OK).body(purchaseOrderRepository.findAll());
    }

    @GetMapping("/purchase-order/{id}")
    public ResponseEntity<Object> findPurchaseOrderById(@PathVariable(value = "id") Long id) {
        Optional<PurchaseOrder> purchaseOrder = purchaseOrderRepository.findById(id);

        return purchaseOrder.<ResponseEntity<Object>>map(value -> ResponseEntity.status(HttpStatus.OK)
                .body(value)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Pedido de compra não encontrado!"));
    }

    @PutMapping("/purchase-order/{id}")
    public ResponseEntity<Object> updatePurchaseOrder(@PathVariable(value = "id") Long id, @RequestBody @Valid PurchaseOrderRecordDto purchaseOrderRecordDto) {
        Optional<PurchaseOrder> purchaseOrder = purchaseOrderRepository.findById(id);

        if(purchaseOrder.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido de compra não encontrado!");
        }

        var purchaseOrderModel = purchaseOrder.get();
        BeanUtils.copyProperties(purchaseOrderRecordDto, purchaseOrderModel);

        BigDecimal totalPrice = calculationService.calculateTotalPrice(purchaseOrderModel);
        purchaseOrderModel.setTotal_price(totalPrice);

        return ResponseEntity.status(HttpStatus.OK).body(purchaseOrderRepository.save(purchaseOrderModel));
    }

    @DeleteMapping("/purchase-order/{id}")
    public ResponseEntity<Object> deletePurchaseOrder(@PathVariable(value = "id") Long id) {
        Optional<PurchaseOrder> purchaseOrder = purchaseOrderRepository.findById(id);

        if(purchaseOrder.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido de compra não encontrado!");
        }

        purchaseOrderRepository.delete(purchaseOrder.get());

        return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso!");
    }
}
