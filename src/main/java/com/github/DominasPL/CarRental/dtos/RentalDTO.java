package com.github.DominasPL.CarRental.dtos;

import com.github.DominasPL.CarRental.domain.entities.Place;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentalDTO {

    //TODO validation
    private Place hirePlace;
    private Place returnPlace;
    private String hireDate;
    private String returnDate;

}
