package com.brandonporter.portfoliobackend.controllers;

import com.brandonporter.portfoliobackend.models.Blog;
import com.brandonporter.portfoliobackend.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping(value = "/allFull",produces = {"application/json"})
    public ResponseEntity<?> allFull(){
        List<Blog> Blogs = blogService.findAll();
        return new ResponseEntity<>(Blogs, HttpStatus.OK);
    }

    @GetMapping(value = "/list", produces = {"application/json"})
    public ResponseEntity<?> all(@PageableDefault Pageable pageable){
        List<Blog> Blogs = blogService.findAll(pageable);
        return new ResponseEntity<>(Blogs,HttpStatus.OK);
    }

    @GetMapping(value = "/{id}",produces = {"application/json"})
    public ResponseEntity<?> find(@PathVariable long id){
        Blog Blog = blogService.getPost(id);
        return new ResponseEntity<>(Blog,HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping(value = "/", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<?> insertBlog(@Valid @RequestBody Blog blog){
        Blog temp = blogService.save(blog);
        return new ResponseEntity<>(temp,HttpStatus.CREATED);
    }
}
