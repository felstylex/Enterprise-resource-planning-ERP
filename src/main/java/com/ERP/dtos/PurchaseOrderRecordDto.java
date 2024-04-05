package com.ERP.dtos;

import com.ERP.models.purchaseOrder.PurchaseOrderItem;
import com.ERP.models.purchaseOrder.PurchaseStatus;
import com.ERP.models.supplier.Supplier;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record PurchaseOrderRecordDto(Supplier supplier, List<PurchaseOrderItem> items, LocalDate purchase_date, BigDecimal total_price, PurchaseStatus status) {
}
