package com.github.DominasPL.CarRental.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentalDTO {

    private String hirePlace;
    private String returnPlace;
    private String hireDate;
    private String returnDate;

}
