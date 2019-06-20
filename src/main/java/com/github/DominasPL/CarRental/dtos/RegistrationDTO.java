package com.github.DominasPL.CarRental.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDTO {

    private String username;

    private String password;

    private String confirmedPassword;

}