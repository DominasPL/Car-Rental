package com.github.DominasPL.CarRental.web.controllers.user;

import com.github.DominasPL.CarRental.domain.entities.Place;
import com.github.DominasPL.CarRental.dtos.RentalDTO;
import com.github.DominasPL.CarRental.services.PlaceService;
import com.github.DominasPL.CarRental.services.RentalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;


@Controller
@RequestMapping("/user/rental")
public class RentalController {

    private PlaceService placeService;
    private RentalService rentalService;

    public RentalController(PlaceService placeService, RentalService rentalService) {
        this.placeService = placeService;
        this.rentalService = rentalService;
    }

    @GetMapping
    public String displayRentalForm(Model model) {

        model.addAttribute("form", new RentalDTO());

        return "rental-form";

    }

    @PostMapping
    public String saveRental(@Valid @ModelAttribute("form") RentalDTO form,
                             @RequestParam("hire-date") String hireDate,
                             @RequestParam("return-date") String returnDate,
                             Principal principal, BindingResult result) {

        if (result.hasErrors()) {
            return "rental-form";
        }

        rentalService.saveRental(form, hireDate, returnDate, principal.getName());

        return "redirect:/user";
    }

    @ModelAttribute("places")
    public List<Place> getPlaces() {

       return placeService.getAllPlaces();
    }


}
