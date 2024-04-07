package com.ERP.controllers;

import com.ERP.dtos.ProjectActivitiesRecordDto;
import com.ERP.models.project.ProjectActivities;
import com.ERP.repositories.ProjectActivitiesRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectActivitiesController {

    @Autowired
    ProjectActivitiesRepository activitiesRepository;

    @PostMapping("/project-activity")
    public ResponseEntity<ProjectActivities> saveProjectActivity(@RequestBody ProjectActivitiesRecordDto projectActivitiesRecordDto) {
        var projectActivityModel = new ProjectActivities();
        BeanUtils.copyProperties(projectActivitiesRecordDto, projectActivityModel);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(activitiesRepository.save(projectActivityModel));
    }
}
