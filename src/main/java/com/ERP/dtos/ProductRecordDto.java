package com.ERP.dtos;

import com.ERP.models.supplier.Supplier;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record ProductRecordDto(
        @NotBlank String name,
        String description,
        @PositiveOrZero BigDecimal price,
        @PositiveOrZero int stock,
        Supplier supplier) {
}
