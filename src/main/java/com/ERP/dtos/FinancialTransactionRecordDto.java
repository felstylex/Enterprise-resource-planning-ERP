package com.ERP.dtos;

import com.ERP.models.client.Client;
import com.ERP.models.supplier.Supplier;
import com.ERP.models.transactions.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record FinancialTransactionRecordDto(BigDecimal value, LocalDateTime date, TransactionType type, Client client, Supplier supplier) {
}
