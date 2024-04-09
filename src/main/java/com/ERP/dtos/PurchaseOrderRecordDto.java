package com.ERP.dtos;

import com.ERP.models.purchaseOrder.PurchaseOrderItem;
import com.ERP.models.purchaseOrder.PurchaseStatus;
import com.ERP.models.supplier.Supplier;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record PurchaseOrderRecordDto(
        Supplier supplier,
        @NotBlank List<PurchaseOrderItem> items,
        @PastOrPresent LocalDate purchase_date,
        BigDecimal total_price,
        PurchaseStatus status) {
}
