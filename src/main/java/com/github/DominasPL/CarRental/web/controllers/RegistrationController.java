package com.github.DominasPL.CarRental.web.controllers;

import com.github.DominasPL.CarRental.dtos.RegistrationDTO;
import com.github.DominasPL.CarRental.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String displayRegistrationForm(Model model) {

        model.addAttribute("form", new RegistrationDTO());

        return "registration";

    }

    @PostMapping
    public String registerUser(@Valid @ModelAttribute("form") RegistrationDTO form, BindingResult result) {

        if (result.hasErrors()) {
            return "registration";
        }

        userService.registerUser(form);

        return "redirect:/";

    }

}
