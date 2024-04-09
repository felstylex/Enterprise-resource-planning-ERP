package com.ERP.controllers;

import com.ERP.dtos.ProjectActivitiesRecordDto;
import com.ERP.models.project.ProjectActivities;
import com.ERP.repositories.ProjectActivitiesRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProjectActivitiesController {

    @Autowired
    ProjectActivitiesRepository activitiesRepository;

    @PostMapping("/project-activity")
    public ResponseEntity<ProjectActivities> saveProjectActivity(@RequestBody @Valid ProjectActivitiesRecordDto projectActivitiesRecordDto) {
        var projectActivityModel = new ProjectActivities();
        BeanUtils.copyProperties(projectActivitiesRecordDto, projectActivityModel);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(activitiesRepository.save(projectActivityModel));
    }

    @GetMapping("/project-activity")
    public ResponseEntity<List<ProjectActivities>> getAllProjectActivities() {
        return ResponseEntity.status(HttpStatus.OK).body(activitiesRepository.findAll());
    }

    @GetMapping("/project-activity/{id}")
    public ResponseEntity<Object> findProjectActivityById(@PathVariable(value = "id") Long id) {
        Optional<ProjectActivities> projectActivity = activitiesRepository.findById(id);

        return projectActivity.<ResponseEntity<Object>>map(value -> ResponseEntity.status(HttpStatus.OK)
                .body(value)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Atividade do projeto não encontrada!"));
    }

    @PutMapping("/project-activity/{id}")
    public ResponseEntity<Object> updateProjectActivity(@PathVariable(value = "id") Long id, @RequestBody @Valid ProjectActivitiesRecordDto projectActivityRecordDto) {
        Optional<ProjectActivities> projectActivity = activitiesRepository.findById(id);

        if(projectActivity.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Atividade do projeto não encontrada!");
        }

        var projectActivityModel = projectActivity.get();
        BeanUtils.copyProperties(projectActivityRecordDto, projectActivityModel);

        return ResponseEntity.status(HttpStatus.OK).body(activitiesRepository.save(projectActivityModel));
    }

    @DeleteMapping("/project-activity/{id}")
    public ResponseEntity<Object> deleteProjectActivity(@PathVariable(value = "id") Long id) {
        Optional<ProjectActivities> projectActivity = activitiesRepository.findById(id);

        if(projectActivity.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Atividade do projeto não encontrada!");
        }

        activitiesRepository.delete(projectActivity.get());

        return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso!");
    }
}
