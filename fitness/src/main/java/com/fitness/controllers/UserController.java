package com.fitness.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fitness.models.User;
import com.fitness.services.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	
	 	@Autowired
	    private UserService userService;

	    @GetMapping
	    public String listUsers(Model model) {
	        model.addAttribute("users", userService.getAllUsers());
	        return "user_profile";
	    }

	    @GetMapping("/new")
	    public String showNewUserForm(Model model) {
	        model.addAttribute("user", new User());
	        return "user_form";
	    }

	    @PostMapping
	    public String saveUser(@ModelAttribute("user") User user) {
	        userService.saveUser(user);
	        return "redirect:/users";
	    }

	    @GetMapping("/edit/{id}")
	    public String showEditUserForm(@PathVariable Long id, Model model) {
	        model.addAttribute("user", userService.getUserById(id));
	        return "user_form";
	    }

	    @GetMapping("/delete/{id}")
	    public String deleteUser(@PathVariable Long id) {
	        userService.deleteUser(id);
	        return "redirect:/users";
	    }

}
