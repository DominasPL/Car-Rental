package com.github.DominasPL.CarRental.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDTO {

    @Size(min = 3, max = 20)
    @NotBlank
    private String username;

    @Size(min = 8, max = 30)
    @NotBlank
    private String password;

    @Size(min = 8, max = 30)
    @NotBlank
    private String confirmedPassword;

    //TODO DODAC REGEXP DO PASSWORD
}
