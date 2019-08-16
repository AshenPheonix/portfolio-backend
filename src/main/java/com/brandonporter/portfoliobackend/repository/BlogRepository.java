package com.brandonporter.portfoliobackend.repository;

import com.brandonporter.portfoliobackend.models.Blog;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BlogRepository extends PagingAndSortingRepository<Blog,Long> {
    List<Blog> findAll();
}
