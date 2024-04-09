package com.ERP.dtos;

import com.ERP.models.products.Product;
import com.ERP.models.salesOrder.SalesOrder;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record SalesOrderItemRecordDto(
        SalesOrder sales_order,
        Product product,
        @Positive int quantity,
        BigDecimal unit_price) {
}
