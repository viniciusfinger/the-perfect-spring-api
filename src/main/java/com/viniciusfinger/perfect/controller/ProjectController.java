package com.viniciusfinger.perfect.controller;

import com.viniciusfinger.perfect.controller.documentation.IProjectController;
import com.viniciusfinger.perfect.model.Project;
import com.viniciusfinger.perfect.service.ProjectService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/projects")
public class ProjectController implements IProjectController {

    //to-do: change return type to ProjectDTO

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public ResponseEntity<Project> create(Project project) {
        //to-do: change response to created and add URI location
        return ResponseEntity.ok(this.projectService.save(project));
    }

    @PutMapping
    public ResponseEntity<Project> update(Project project) {
        //to-do: change response to created and add URI location
        return ResponseEntity.ok(this.projectService.save(project));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Project> delete(@PathVariable Long id) {
        this.projectService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<Project>> findAll(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = "ASC", required = false) String direction
    ) {
        return ResponseEntity.ok(this.projectService.findAll(pageNo, pageSize, sortBy, direction));
    }
}
