package com.codeup.codeupspringblog.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Controller
@RequestMapping(path = "/posts")
public class PostController {

    // GET /posts
    @GetMapping
    public String getPosts() {
        return "posts/show";
    }

    // GET /posts/{id}
    @GetMapping("/{id}")
    @ResponseBody
    public String viewPost(@PathVariable("id") Long id) {
        return "Viewing post with ID " + id;
    }

    // GET /posts/create
    @GetMapping("/create")
    public String createPostForm() {
        return "posts/create";
    }

    // POST /posts/create
    @PostMapping("/create")
    @ResponseBody
    public String createPost() {
        // Logic for creating a new post
        return "Successfully created a new post";
    }
}

