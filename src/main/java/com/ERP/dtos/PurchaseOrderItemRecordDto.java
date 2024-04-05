package com.ERP.dtos;

import com.ERP.models.products.Product;
import com.ERP.models.purchaseOrder.PurchaseOrder;

import java.math.BigDecimal;

public record PurchaseOrderItemRecordDto(PurchaseOrder purchase_order, Product product, int quantity, BigDecimal unit_price) {
}
