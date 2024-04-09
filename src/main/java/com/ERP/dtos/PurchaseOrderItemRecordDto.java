package com.ERP.dtos;

import com.ERP.models.products.Product;
import com.ERP.models.purchaseOrder.PurchaseOrder;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record PurchaseOrderItemRecordDto(
        PurchaseOrder purchase_order,
        Product product,
        @Positive int quantity,
        BigDecimal unit_price) {
}
