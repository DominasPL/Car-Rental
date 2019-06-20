package com.github.DominasPL.CarRental.converters;

import com.github.DominasPL.CarRental.domain.entities.User;
import com.github.DominasPL.CarRental.dtos.RegistrationDTO;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Converter {

    public static User convertToUser(RegistrationDTO form) {

        User user = new User();
        user.setUsername(form.getUsername());
        user.setPassword(form.getPassword());

        return user;
    }
}
