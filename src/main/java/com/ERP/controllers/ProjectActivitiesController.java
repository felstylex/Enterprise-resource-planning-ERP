package com.ERP.controllers;

import com.ERP.repositories.ProjectActivitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectActivitiesController {

    @Autowired
    ProjectActivitiesRepository activitiesRepository;
}
