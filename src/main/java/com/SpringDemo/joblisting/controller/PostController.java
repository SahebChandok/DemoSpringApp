package com.SpringDemo.joblisting.controller;
import java.util.*;

import com.SpringDemo.joblisting.PostRepository;
import com.SpringDemo.joblisting.model.JobPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
    @Autowired
    PostRepository repo;
    @GetMapping("/posts")
    public List<JobPost> getAllPosts(){
        return repo.findAll();
    }

    @PostMapping("/addPost")
    public JobPost addPost(@RequestBody JobPost post){
        return repo.save(post);
    }
}
