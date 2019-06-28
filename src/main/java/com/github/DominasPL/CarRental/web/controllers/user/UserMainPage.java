package com.github.DominasPL.CarRental.web.controllers.user;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserMainPage {

    @GetMapping
    public String displayMainPage() {
        return "index";
    }

}
