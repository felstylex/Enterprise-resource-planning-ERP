package com.ERP.controllers;

import com.ERP.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;
}
