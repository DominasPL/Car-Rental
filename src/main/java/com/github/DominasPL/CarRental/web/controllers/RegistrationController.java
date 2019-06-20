package com.github.DominasPL.CarRental.web.controllers;

import com.github.DominasPL.CarRental.dtos.RegistrationDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @GetMapping
    public String displayRegistrationForm(Model model) {

        model.addAttribute("form", new RegistrationDTO());

        return "registration";

    }

}
