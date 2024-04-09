package com.ERP.controllers;

import com.ERP.dtos.ProjectRecordDto;
import com.ERP.models.project.Project;
import com.ERP.repositories.ProjectRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @PostMapping("/project")
    public ResponseEntity<Project> saveProject(@RequestBody @Valid ProjectRecordDto projectRecordDto) {
        var projectModel = new Project();
        BeanUtils.copyProperties(projectRecordDto, projectModel);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(projectRepository.save(projectModel));
    }

    @GetMapping("/project")
    public ResponseEntity<List<Project>> getAllProjects() {
        return ResponseEntity.status(HttpStatus.OK).body(projectRepository.findAll());
    }

    @GetMapping("/project/{id}")
    public ResponseEntity<Object> findProjectById(@PathVariable(value = "id") Long id) {
        Optional<Project> project = projectRepository.findById(id);

        return project.<ResponseEntity<Object>>map(value -> ResponseEntity.status(HttpStatus.OK)
                .body(value)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Projeto não encontrado!"));
    }

    @PutMapping("/project/{id}")
    public ResponseEntity<Object> updateProject(@PathVariable(value = "id") Long id, @RequestBody @Valid ProjectRecordDto projectRecordDto) {
        Optional<Project> project = projectRepository.findById(id);

        if(project.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Projeto não encontrado!");
        }

        var projectModel = project.get();
        BeanUtils.copyProperties(projectRecordDto, projectModel);

        return ResponseEntity.status(HttpStatus.OK).body(projectRepository.save(projectModel));
    }

    @DeleteMapping("/project/{id}")
    public ResponseEntity<Object> deleteProject(@PathVariable(value = "id") Long id) {
        Optional<Project> project = projectRepository.findById(id);

        if(project.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Projeto não encontrado!");
        }

        projectRepository.delete(project.get());

        return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso!");
    }

}
