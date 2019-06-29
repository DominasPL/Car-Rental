package com.github.DominasPL.CarRental.web.controllers.admin;

import com.github.DominasPL.CarRental.dtos.UserDTO;
import com.github.DominasPL.CarRental.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.Table;
import java.util.List;

@Controller
@RequestMapping("/admin/admins")
public class AdminsController {

    private UserService userService;

    public AdminsController(UserService userService) {
        this.userService = userService;
    }
//
    @GetMapping
    public String displayAllAdmins(Model model) {

        List<UserDTO> allAdmins = userService.loadAllAdmins();

        model.addAttribute("admins",allAdmins);

        return "admin/show-admins";

    }

}
