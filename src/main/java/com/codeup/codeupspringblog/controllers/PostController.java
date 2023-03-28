package com.codeup.codeupspringblog.controllers;


import com.codeup.codeupspringblog.models.Post;

import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping(path = "/posts")
public class PostController {

    @Autowired
    private final PostRepository postDao;

    @Autowired
    private final UserRepository userDao;


    @GetMapping
    public String getPosts(Model model) {
        List<Post> posts = postDao.findAll();

        model.addAttribute("posts", posts);

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
    public String createPost(@RequestParam String title, @RequestParam String description) {
        // Logic for creating a new post
        Post post = new Post();
        post.setTitle(title);
        post.setDescription(description);

        User user = userDao.findById(2L).get();
        post.setUser(user);


        postDao.save(post);

        return "redirect:/posts";
    }
}

