package com.github.DominasPL.CarRental.web.controllers.admin;

import com.github.DominasPL.CarRental.dtos.RentalDTO;
import com.github.DominasPL.CarRental.services.RentalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/rentals")
public class RentalsController {

    private RentalService rentalService;

    public RentalsController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping
    public String displayAllRentals(Model model) {

        List<RentalDTO> allRentals = rentalService.findAllRentals();

        model.addAttribute("rentals", allRentals);

        return "admin/show-rentals";

    }


}
