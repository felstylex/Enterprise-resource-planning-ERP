package com.ERP.dtos;

import com.ERP.models.supplier.Supplier;

import java.math.BigDecimal;

public record ProductRecordDto(String name, String description, BigDecimal price, int stock, Supplier supplier) {
}
