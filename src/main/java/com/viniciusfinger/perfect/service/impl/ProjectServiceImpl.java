package com.viniciusfinger.perfect.service.impl;

import com.viniciusfinger.perfect.model.Project;
import com.viniciusfinger.perfect.repository.ProjectRepository;
import com.viniciusfinger.perfect.service.ProjectService;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

    public Project save(Project project){
        return this.projectRepository.save(project);
    }

}
