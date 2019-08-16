package com.brandonporter.portfoliobackend.models;

import javax.persistence.*;

@Entity
@Table(name = "blogs")
public class Blog extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String stub;
    @Column(nullable = false)
    private String blog;

    public Blog() {
    }

    public Blog(String title, String stub, String blog) {
        this.title = title;
        this.stub = stub;
        this.blog = blog;
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

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }
}
