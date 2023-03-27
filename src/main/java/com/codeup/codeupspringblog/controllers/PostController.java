package com.codeup.codeupspringblog.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    // GET /posts
    @GetMapping("/posts")
    public String getPosts() {
        return "This is the posts index page";
    }

    // GET /posts/{id}
    @GetMapping("/posts/{id}")
    public String viewPost(@PathVariable("id") Long id) {
        return "Viewing post with ID " + id;
    }

    // GET /posts/create
    @GetMapping("/posts/create")
    public String createPostForm() {
        return "posts/create";
    }

    // POST /posts/create
    @PostMapping("/posts/create")
    public String createPost() {
        // Logic for creating a new post
        return "Successfully created a new post";
    }
}

