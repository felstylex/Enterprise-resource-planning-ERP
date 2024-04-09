package com.ERP.dtos;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record ProjectRecordDto(
        @NotBlank String name,
        String description,
        @NotBlank LocalDate start_date,
        LocalDate end_date) {
}
