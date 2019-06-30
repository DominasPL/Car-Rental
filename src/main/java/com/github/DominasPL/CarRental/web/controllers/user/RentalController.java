package com.github.DominasPL.CarRental.web.controllers.user;

import com.github.DominasPL.CarRental.domain.entities.Place;
import com.github.DominasPL.CarRental.dtos.PlaceDTO;
import com.github.DominasPL.CarRental.dtos.RentalDTO;
import com.github.DominasPL.CarRental.services.PlaceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/user/rental")
public class RentalController {

    private PlaceService placeService;

    public RentalController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping
    public String displayRentalForm(Model model) {

        model.addAttribute("form", new RentalDTO());

        return "rental-form";

    }

    @ModelAttribute("places")
    public List<Place> getPlaces() {

       return placeService.getAllPlaces();
    }


}
