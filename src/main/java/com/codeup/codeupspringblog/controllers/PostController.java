//package com.codeup.codeupspringblog.controllers;
//
////import com.codeup.codeupspringblog.models.Post;
//import com.codeup.codeupspringblog.Post;
//import com.codeup.codeupspringblog.repositories.PostRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//public class PostController {
//
//    private final PostRepository postDao;
//
//    @Autowired
//    public PostController(PostRepository postDao) {
//        this.postDao = postDao;
//    }
//
//    @GetMapping("/posts")
//    public String index(Model model) {
//        model.addAttribute("posts", postDao.findAll());
//        return "posts/index";
//    }
//
//    @GetMapping("/posts/{id}")
//    public String show(@PathVariable long id, Model model) {
//        model.addAttribute("post", postDao.getOne(id));
//        return "posts/show";
//    }
//
//    @GetMapping("/posts/create")
//    public String showCreateForm(Model model) {
//        model.addAttribute("post", new Post());
//        return "posts/create";
//    }
//
//    @PostMapping("/posts/create")
//    public String create(@ModelAttribute Post post) {
//        postDao.save(post);
//        return "redirect:/posts";
//    }
//}



package com.codeup.codeupspringblog.controllers;
//import com.codeup.codeupspringblog.models.Post;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Random;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;

    @Autowired
    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }

    @GetMapping("/posts")
    public String index(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.getOne(id));
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String create(@ModelAttribute Post post) {
        List<User> users = userDao.findAll();
        Random random = new Random();
        User randomUser = users.get(random.nextInt(users.size()));
        post.setUser(randomUser);
        postDao.save(post);
        return "redirect:/posts";
    }
}