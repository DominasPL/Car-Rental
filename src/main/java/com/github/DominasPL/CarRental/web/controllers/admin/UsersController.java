package com.github.DominasPL.CarRental.web.controllers.admin;

import com.github.DominasPL.CarRental.dtos.UserDTO;
import com.github.DominasPL.CarRental.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.Entity;
import java.util.List;

@Controller
@RequestMapping("/admin/users")
public class UsersController {

    private UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String displayAllUsers(Model model) {

        List<UserDTO> allUsers = userService.loadAllUsers();

        model.addAttribute("users", allUsers);

        return "/admin/show-users";

    }

}
