package com.ERP.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

public record EmployeeRecordDto(String name, String office, String department, LocalDate admission_date, BigDecimal salary) {
}
