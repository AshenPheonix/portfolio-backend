package com.brandonporter.portfoliobackend.services;

import com.brandonporter.portfoliobackend.exceptions.ResourceNotFoundException;
import com.brandonporter.portfoliobackend.models.Blog;
import com.brandonporter.portfoliobackend.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "blogService")
public class BlogServiceImpl implements BlogService{

    @Autowired
    private BlogRepository blogRepo;

    @Override
    public Blog save(Blog blog) {
        Blog temp = new Blog();
        if(blog.getPost()==null){
            throw new ResourceNotFoundException("Missing Post");
        }else{
            temp.setPost(blog.getPost());
        }
        if(blog.getStub()==null){
            temp.setStub(blog.getPost().substring(0,100)+"...");
        }else {
            temp.setStub(blog.getStub());
        }
        if(blog.getTitle()==null){
            throw new ResourceNotFoundException("Missing Title");
        }else{
            temp.setTitle(blog.getTitle());
        }
        return blogRepo.save(temp);
    }

    @Override
    public List<Blog> findAll() {
        List<Blog> list=new ArrayList<>();
        blogRepo.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public List<Blog> findAll(Pageable pageable) {
        List<Blog> list = new ArrayList<>();
        blogRepo.findAll(pageable).iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Blog getPost(long id) {
        return blogRepo.findById(id).orElseThrow(()->new ResourceNotFoundException(Long.toString(id)));
    }

    @Override
    public Blog update(Blog blog, long id) {
        Blog temp = blogRepo.findById(id).orElseThrow(()->new ResourceNotFoundException(Long.toString(id)));
        if(blog.getPost()==null){
            throw new ResourceNotFoundException("Not Enough Information");
        }else{
            temp.setPost(blog.getPost());
        }
        if(blog.getStub()==null){
            temp.setStub(blog.getPost().substring(0,100)+"...");
        }else {
            temp.setStub(blog.getStub());
        }
        if(blog.getTitle()==null){
            throw new ResourceNotFoundException("Not Enough Information");
        }else{
            temp.setTitle(blog.getTitle());
        }
        return blogRepo.save(temp);
    }

    @Override
    public void delete(long id) {
        if(blogRepo.findById(id).isPresent()){
            blogRepo.deleteById(id);
        }else {
            throw new ResourceNotFoundException(Long.toString(id));
        }
    }
}
