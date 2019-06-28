package com.github.DominasPL.CarRental.web.controllers.user;

import com.github.DominasPL.CarRental.dtos.RegistrationDTO;
import com.github.DominasPL.CarRental.dtos.UserDTO;
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

        return "registration-form";

    }

    @PostMapping
    public String registerUser(@Valid @ModelAttribute("form") RegistrationDTO form, BindingResult result) {

        if (result.hasErrors()) {
            return "registration-form";
        }

        if (!checkPasswordEquality(form)) {
            result.rejectValue("password", null, "Passwords are not equals!");
            return "registration-form";
        }

        if (!checkIsUsernameAvailable(form)) {
            result.rejectValue("username", null, "Username is already in database!");
            return "registration-form";
        }


        userService.registerUser(form);

        return "redirect:/user";

    }

    public boolean checkIsUsernameAvailable(RegistrationDTO form) {

        UserDTO userDTO = userService.findUserByUsername(form.getUsername());

        if (userDTO == null) {
            return true;
        }

        return false;

    }

    public boolean checkPasswordEquality(RegistrationDTO form) {

        if (form.getPassword().equals(form.getConfirmedPassword())) {
            return true;
        }

        return false;

    }




}
