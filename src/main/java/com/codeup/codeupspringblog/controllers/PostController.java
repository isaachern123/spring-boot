package com.codeup.codeupspringblog.controllers;


import com.codeup.codeupspringblog.models.Post;

import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
        Post originalPost = postDao.findById(id).get();

        Post post = new Post(originalPost.getId(), originalPost.getTitle(), originalPost.getDescription(), originalPost.getUser());

        return "Viewing post with ID " + id + ". Title: " + post.getTitle() + " Description: " + post.getDescription();
    }

    // GET /posts/create
    @GetMapping("/create")
    public String createPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    // POST /posts/create
    @PostMapping("/create")
    public String createPost(@ModelAttribute Post post) {


        User user = userDao.findById(2L).get();
        post.setUser(user);

        postDao.save(post);

        return "redirect:/posts";
    }

    @GetMapping("/{id}/edit")
    public String showUpdatePost(@PathVariable("id") long id, Model model) {
        Post post = postDao.findById(id).get();
        model.addAttribute("post", post);
        return "posts/update";
    }

    @PostMapping("/{id}/edit")
    public String updatePost(@PathVariable("id") long id, @ModelAttribute Post post) {
        Post originalPost = postDao.findById(id).get();
        post.setId(id);
        post.setUser(originalPost.getUser());

        postDao.save(post);
        return "redirect:/posts/" + id;


    }
}

