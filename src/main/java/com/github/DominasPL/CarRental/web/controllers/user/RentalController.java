package com.github.DominasPL.CarRental.web.controllers.user;

import com.github.DominasPL.CarRental.dtos.RentalDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user/rental")
public class RentalController {

    @GetMapping
    public String displayRentalForm(Model model) {

        model.addAttribute("form", new RentalDTO());

        return "rental-form";

    }


}
