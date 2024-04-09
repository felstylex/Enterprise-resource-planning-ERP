package com.ERP.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record SupplierRecordDto(
        @NotBlank String name,
        @NotBlank String cnpj,
        @NotBlank String address,
        String telephone,
        @NotBlank @Email String email) {
}
