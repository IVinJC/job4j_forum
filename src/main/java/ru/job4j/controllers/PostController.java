package ru.job4j.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.model.Post;
import ru.job4j.service.PostService;

import java.util.GregorianCalendar;

@Controller
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }
    @PostMapping("/create")
    public String create(Model model, @ModelAttribute("post") Post post) {
        model.addAttribute("post", post);
        return "index";
    }

    @GetMapping("/post/{id}")
    public String post(Model model, @PathVariable("id") int id) {
        model.addAttribute("post", postService.findById(id));
        return "post";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("post", postService.findById(id));
        return "edit";
    }

    @PostMapping("/post/{id}")
    public String editPost(@ModelAttribute("post") Post post, @PathVariable("id") int id) {
        post.setCreated(new GregorianCalendar());
        postService.edit(post, id);
        return "redirect:/index";
    }
}
