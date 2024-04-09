package com.ERP.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ClientRecordDto(
        @NotBlank String name,
        @NotBlank String cpf,
        @NotBlank String address,
        String telephone,
        @NotBlank @Email String email) {
}
