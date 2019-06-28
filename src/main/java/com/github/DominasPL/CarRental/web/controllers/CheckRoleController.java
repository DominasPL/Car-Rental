package com.github.DominasPL.CarRental.web.controllers;

import com.github.DominasPL.CarRental.dtos.UserDTO;
import com.github.DominasPL.CarRental.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/check-role")
public class CheckRoleController {

    private UserService userService;

    public CheckRoleController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String redirectAccordingToRole(Principal principal) {

        UserDTO userDTO = userService.findUserByUsername(principal.getName());

        if (userDTO.getRole().equals("ROLE_ADMIN")) {
            return "redirect:/admin";
        }

        return "redirect:/user";

    }

}
