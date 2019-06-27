package com.github.DominasPL.CarRental.web.controllers;

import com.github.DominasPL.CarRental.dtos.EditDetailsDTO;
import com.github.DominasPL.CarRental.dtos.UserDetailsDTO;
import com.github.DominasPL.CarRental.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/edit")
public class EditUserDetailsController {

    private UserService userService;

    public EditUserDetailsController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String prepareEditDetailsForm(Model model, Principal principal) {

        EditDetailsDTO editDetailsDTO = userService.findUserDetails(principal.getName());

        model.addAttribute("form", editDetailsDTO);

        return "edit-details";
    }

    @PostMapping
    public String editUserDetails(@Valid @ModelAttribute("form") EditDetailsDTO form, Principal principal, BindingResult result) {

        if (result.hasErrors()) {
            return "edit-details";
        }

        if (checkUserCurrentEmail(form)) {


        } else if (!checkIsEmailAvailable(form)) {
            result.rejectValue("email", null, "Email is already in database!");
            return "edit-details";
        }

        userService.editUserDetails(form, principal.getName());

        return "redirect:/";

    }

    public boolean checkIsEmailAvailable(EditDetailsDTO form) {

        UserDetailsDTO userDetailsDTO = userService.checkIsEmailInDatabase(form.getEmail());


        if (userDetailsDTO == null) {
            return true;
        }

        return false;
    }

    public boolean checkUserCurrentEmail(EditDetailsDTO form) {

        UserDetailsDTO userDetailsDTO = userService.checkIsEmailInDatabase(form.getEmail());

        if (userDetailsDTO == null) {
            return true;
        }

        if (userDetailsDTO.getEmail().equals(form.getEmail())) {
            return true;
        }

        return false;

    }

}
