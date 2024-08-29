package com.fitness.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fitness.models.CommunityPost;
import com.fitness.services.CommunityPostService;

@Controller
@RequestMapping("/community")
public class CommunityController {
	
	@Autowired
    private CommunityPostService communityPostService;

    @GetMapping
    public String listCommunityPosts(Model model) {
        model.addAttribute("posts", communityPostService.getAllPosts());
        return "community";
    }

    @GetMapping("/new")
    public String showNewCommunityPostForm(Model model) {
        model.addAttribute("post", new CommunityPost());
        return "community_post_form";
    }

    @PostMapping
    public String saveCommunityPost(@ModelAttribute("post") CommunityPost post) {
        communityPostService.savePost(post);
        return "redirect:/community";
    }

    @GetMapping("/edit/{id}")
    public String showEditCommunityPostForm(@PathVariable Long id, Model model) {
        model.addAttribute("post", communityPostService.getPostById(id));
        return "community_post_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteCommunityPost(@PathVariable Long id) {
        communityPostService.deletePost(id);
        return "redirect:/community";
    }

}
