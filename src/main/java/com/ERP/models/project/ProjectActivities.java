package com.ERP.models.project;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity(name="projectActivities")
@Table(name="projectActivities")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ProjectActivities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String projectId;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    @Enumerated(EnumType.STRING)
    private ProjectStatus status;
}
