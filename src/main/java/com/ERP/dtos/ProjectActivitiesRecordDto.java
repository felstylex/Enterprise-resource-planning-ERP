package com.ERP.dtos;

import com.ERP.models.project.Project;
import com.ERP.models.project.ProjectStatus;

import java.time.LocalDate;

public record ProjectActivitiesRecordDto(Project project, String name, LocalDate start_date, LocalDate end_date, ProjectStatus status) {
}
