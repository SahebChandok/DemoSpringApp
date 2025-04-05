package com.SpringDemo.joblisting.controller;
import java.util.*;

import com.SpringDemo.joblisting.Repository.PostRepository;
import com.SpringDemo.joblisting.Repository.SearchRepository;
import com.SpringDemo.joblisting.model.JobPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {
    @Autowired
    PostRepository repo;
    @Autowired
    SearchRepository srepo;
    @GetMapping("/posts")
    public List<JobPost> getAllPosts(){
        return repo.findAll();
    }

    @GetMapping("/posts/{text}")
    public List<JobPost> search(@PathVariable String text){
        return srepo.findByText(text);
    }
    @PostMapping("/addPost")
    public JobPost addPost(@RequestBody JobPost post){
        return repo.save(post);
    }
}
