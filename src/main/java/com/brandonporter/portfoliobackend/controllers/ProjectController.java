package com.brandonporter.portfoliobackend.controllers;

import com.brandonporter.portfoliobackend.models.Project;
import com.brandonporter.portfoliobackend.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectService projServ;

    @GetMapping(value = "/allFull",produces = {"application/json"})
    public ResponseEntity<?> allFull(){
        List<Project> projects = projServ.findAll();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @GetMapping(value = "/list", produces = {"application/json"})
    public ResponseEntity<?> all(@PageableDefault Pageable pageable){
        List<Project> projects = projServ.findAll(pageable);
        return new ResponseEntity<>(projects,HttpStatus.OK);
    }

    @GetMapping(value = "/{id}",produces = {"application/json"})
    public ResponseEntity<?> find(@PathVariable long id){
        Project project = projServ.getProject(id);
        return new ResponseEntity<>(project,HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping(value = "/",consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<?> insertProject(@RequestBody Project project){
        Project temp = projServ.save(project);
        return new ResponseEntity<>(temp,HttpStatus.CREATED);
    }

}
