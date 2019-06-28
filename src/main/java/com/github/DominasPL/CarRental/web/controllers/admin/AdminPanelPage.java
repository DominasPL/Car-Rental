package com.github.DominasPL.CarRental.web.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminPanelPage {

    @GetMapping
    public String showAdminMainPage() {

        return "admin/admin-panel";
    }



}
