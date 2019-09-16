package com.brandonporter.portfoliobackend.services;

import com.brandonporter.portfoliobackend.exceptions.ResourceNotFoundException;
import com.brandonporter.portfoliobackend.models.Project;
import com.brandonporter.portfoliobackend.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "projectService")
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepo;

    @Override
    public Project save(Project project) {
        Project temp=new Project();
        if(project.getPost()==null){
            throw new ResourceNotFoundException("Not Enough Information");
        }else{
            temp.setPost(project.getPost());
        }
        if(project.getStub()==null){
            temp.setStub(project.getPost().substring(0,100)+"...");
        }else {
            temp.setStub(project.getStub());
        }
        if(project.getTitle()==null){
            throw new ResourceNotFoundException("Not Enough Information");
        }else{
            temp.setTitle(project.getTitle());
        }
        return projectRepo.save(temp);
    }

    @Override
    public List<Project> findAll() {
        List<Project> list=new ArrayList<>();
        projectRepo.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public List<Project> findAll(Pageable pagable) {
        List<Project> list = new ArrayList<>();
        projectRepo.findAll(pagable).iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Project getProject(long id) {
        return projectRepo.findById(id).orElseThrow(()->new ResourceNotFoundException(Long.toString(id)));
    }

    @Override
    public Project update(Project project, long id) {
        Project temp = projectRepo.findById(id).orElseThrow(()->new ResourceNotFoundException(Long.toString(id)));

        if(project.getPost()==null){
            throw new ResourceNotFoundException("No post");
        }else{
            temp.setPost(project.getPost());
        }
        if(project.getStub()==null){
            temp.setStub(project.getPost().substring(0,100)+"...");
        }else {
            temp.setStub(project.getStub());
        }
        if(project.getTitle()==null){
            throw new ResourceNotFoundException("No title");
        }else{
            temp.setTitle(project.getTitle());
        }
        return projectRepo.save(temp);
    }

    @Override
    public void delete(long id) {
        if(projectRepo.findById(id).isPresent()){
            projectRepo.deleteById(id);
        }else {
            throw new ResourceNotFoundException(Long.toString(id));
        }
    }
}
