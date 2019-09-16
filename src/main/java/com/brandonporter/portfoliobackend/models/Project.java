package com.brandonporter.portfoliobackend.models;

import javax.persistence.*;

@Entity
@Table(name = "projects")
public class Project extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String stub;

    @Column(nullable = false)
    private String post;

    public Project() {
    }

    public Project(String title, String stub, String blog) {
        this.title = title;
        this.stub = stub;
        this.post = blog;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStub() {
        return stub;
    }

    public void setStub(String stub) {
        this.stub = stub;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
