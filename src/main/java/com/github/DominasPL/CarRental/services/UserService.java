package com.github.DominasPL.CarRental.services;

import com.github.DominasPL.CarRental.converters.Converter;
import com.github.DominasPL.CarRental.domain.entities.User;
import com.github.DominasPL.CarRental.domain.repositories.UserRepository;
import com.github.DominasPL.CarRental.dtos.RegistrationDTO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(RegistrationDTO form) {

        User user = Converter.convertToUser(form);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

    }
}
