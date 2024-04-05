package com.ERP.dtos;

import java.time.LocalDate;

public record ProjectRecordDto(String name, String description, LocalDate start_date, LocalDate end_date) {
}
