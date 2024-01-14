package com.viniciusfinger.perfect.service;

import com.viniciusfinger.perfect.model.Project;
import org.springframework.data.domain.Page;

public interface ProjectService {
    Project save(Project project);

    void deleteById(Long id);

    Page<Project> findAll(int pageNo, int pageSize, String sortBy, String direction);

}
