package com.brandonporter.portfoliobackend.services;

import com.brandonporter.portfoliobackend.models.Project;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {
    //C
    Project save(Project project);

    //R
    List<Project> findAll();
    List<Project> findAll(Pageable pagable);
    Project getProject(long id);

    //U
    Project update(Project project, long id);

    //D
    void delete(long id);
}
