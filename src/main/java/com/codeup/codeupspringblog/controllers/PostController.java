package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String index(Model model) {
        List<Post> posts = new ArrayList<>(); // create an empty list of posts
        posts.add(new Post(1L, "Sample Post 1", "This is the body of sample post 1."));
        posts.add(new Post(2L, "Sample Post 2", "This is the body of sample post 2."));
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model model) {
        Post post = new Post(id, "Sample Post", "This is the body of a sample post.");
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String createForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts")
    public String create(@ModelAttribute Post post) {
        // Add your logic to save the post and redirect as needed
        return "redirect:/posts";
    }
}












//package com.codeup.codeupspringblog.controllers;
//
//package com.codeup.codeupspringblog.controllers;//package com.codeup.codeupspringblog.controllers;//package com.codeup.codeupspringblog.controllers;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//@Controller
//public class PostController {
//
//    @GetMapping("/posts")
//    public String postsIndex() {
//        return "posts/index";
//    }
//
//    @GetMapping("/posts/{id}")
//    public String viewPost(@PathVariable long id, Model model) {
//        // Retrieve post with given ID from database and add it to model
//        return "posts/show";
//    }
//
//    @GetMapping("/posts/create")
//    public String viewCreateForm() {
//        return "posts/create";
//    }
//
//    // Handle form submission for creating a new post
//    // Redirect to "/posts/{id}" after post is created
//}
//
