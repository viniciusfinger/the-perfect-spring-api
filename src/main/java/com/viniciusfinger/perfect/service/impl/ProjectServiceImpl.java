package com.viniciusfinger.perfect.service.impl;

import com.viniciusfinger.perfect.model.Project;
import com.viniciusfinger.perfect.repository.ProjectRepository;
import com.viniciusfinger.perfect.service.ProjectService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public void deleteById(Long id){
        this.projectRepository.deleteById(id);
    }

    public Page<Project> findAll(int pageNo, int pageSize, String sortBy, String direction) {
        Sort sort = Sort.by(Sort.Direction.fromString(direction), sortBy);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        return this.projectRepository.findAll(pageable);
    }
}
