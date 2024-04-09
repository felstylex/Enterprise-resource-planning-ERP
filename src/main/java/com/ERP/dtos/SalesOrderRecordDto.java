package com.ERP.dtos;

import com.ERP.models.client.Client;
import com.ERP.models.salesOrder.OrderStatus;
import com.ERP.models.salesOrder.SalesOrderItem;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record SalesOrderRecordDto(
        Client client,
        @NotBlank List<SalesOrderItem> items,
        @PastOrPresent LocalDate order_date,
        BigDecimal total_price,
        OrderStatus status) {
}
