package com.ERP.controllers;

import com.ERP.dtos.ProjectRecordDto;
import com.ERP.models.project.Project;
import com.ERP.repositories.ProjectRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @PostMapping("/project")
    public ResponseEntity<Project> saveProject(@RequestBody ProjectRecordDto projectRecordDto) {
        var projectModel = new Project();
        BeanUtils.copyProperties(projectRecordDto, projectModel);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(projectRepository.save(projectModel));
    }
}
