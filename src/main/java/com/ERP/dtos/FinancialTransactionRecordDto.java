package com.ERP.dtos;

import com.ERP.models.client.Client;
import com.ERP.models.supplier.Supplier;
import com.ERP.models.transactions.TransactionType;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record FinancialTransactionRecordDto(
        @Positive BigDecimal value,
        @PastOrPresent LocalDateTime date,
        TransactionType type,
        Client client,
        Supplier supplier) {
}
