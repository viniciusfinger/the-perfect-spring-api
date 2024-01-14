package com.viniciusfinger.perfect.controller;

import com.viniciusfinger.perfect.controller.documentation.IProjectController;
import com.viniciusfinger.perfect.model.Project;
import com.viniciusfinger.perfect.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projects")
public class ProjectController implements IProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService){
        this.projectService = projectService;
    }

    //to-do: change return type to ProjectDTO (search if are the best practices)
    @PostMapping
    public ResponseEntity<Project> create(Project project) {
        //to-do: change response to created and add URI location
        return ResponseEntity.ok(this.projectService.save(project));
    }

}
