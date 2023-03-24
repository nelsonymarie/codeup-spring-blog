package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String postsIndex() {
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String viewPost(@PathVariable long id, Model model) {
        // Retrieve post with given ID from database and add it to model
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String viewCreateForm() {
        return "posts/create";
    }

    // Handle form submission for creating a new post
    // Redirect to "/posts/{id}" after post is created
}
