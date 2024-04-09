package com.ERP.dtos;

import com.ERP.models.project.Project;
import com.ERP.models.project.ProjectStatus;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record ProjectActivitiesRecordDto(
        Project project,
        @NotBlank String name,
        @NotBlank LocalDate start_date,
        LocalDate end_date,
        ProjectStatus status) {
}
