package org.labexercise.simplemvc.controller;

import org.labexercise.simplemvc.model.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LiteController {


    @GetMapping("/")
    public String displayMessage(Model model) {
        String message = "Welcome to Simple MVC!";
        UserForm userForm = UserForm.builder().build();

        model.addAttribute("message", message);
        model.addAttribute("userForm", userForm);
        return "index";
    }

    @PostMapping("/register")
    public String displayRegisterForm(Model model, @ModelAttribute UserForm userForm) {
        System.out.println(userForm.toString());
        model.addAttribute("userForm", userForm);
        return "register";
    }

}
