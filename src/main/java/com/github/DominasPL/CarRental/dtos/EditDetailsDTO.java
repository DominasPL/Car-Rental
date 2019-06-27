package com.github.DominasPL.CarRental.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.parameters.P;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditDetailsDTO {

    @Size(max = 20)
    private String firstName;

    @Size(max = 20)
    private String lastName;

    @Email
    private String email;

    @Pattern(regexp="(^$|[0-9]{9})")
    private String phoneNumber;

    @Size(max = 100)
    private String address;

    @Pattern(regexp = ("\\d{2}-\\d{3}"))
    private String postalCode;

}
