package com.brandonporter.portfoliobackend.repository;

import com.brandonporter.portfoliobackend.models.Project;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProjectRepository extends PagingAndSortingRepository<Project,Long> {
    List<Project> findAll();
}