package com.brandonporter.portfoliobackend.services;

import com.brandonporter.portfoliobackend.models.Blog;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface BlogService {
    //C
    Blog save(Blog blog);

    //R
    List<Blog> findAll();
    List<Blog> findAll(Pageable pageable);
    Blog getPost(long id);

    //U
    Blog update(Blog blog, long id);

    //D
    void delete(long id);
}
