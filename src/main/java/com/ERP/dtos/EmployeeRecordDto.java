package com.ERP.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;

public record EmployeeRecordDto(
        @NotBlank String name,
        @NotBlank String office,
        @NotBlank String department,
        @PastOrPresent LocalDate admission_date,
        @Positive BigDecimal salary) {
}
