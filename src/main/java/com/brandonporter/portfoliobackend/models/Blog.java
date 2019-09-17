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
    @Lob
    @Column(nullable = false,columnDefinition = "text")
    private String post;

    public Blog() {
    }

    public Blog(String title, String stub, String post) {
        this.title = title;
        this.stub = stub;
        this.post = post;
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

    @Override
    public String toString() {
        return this.getTitle()+ "stub:" + this.getStub()+ "Post:" +this.getPost();
    }
}
