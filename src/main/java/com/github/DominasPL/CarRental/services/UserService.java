package com.github.DominasPL.CarRental.services;

import com.github.DominasPL.CarRental.converters.Converter;
import com.github.DominasPL.CarRental.domain.entities.User;
import com.github.DominasPL.CarRental.domain.entities.UserDetails;
import com.github.DominasPL.CarRental.domain.repositories.UserRepository;
import com.github.DominasPL.CarRental.dtos.RegistrationDTO;
import com.github.DominasPL.CarRental.dtos.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void registerUser(RegistrationDTO form) {

        User user = Converter.convertToUser(form);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        UserDetails userDetails = new UserDetails();
        userDetails.setId(user.getId());
        user.setUserDetails(userDetails);

    }

    public UserDTO findUserByUsername(String username) {

        if (username == null) {
            throw new IllegalArgumentException("Email has to be given!");
        }

        Optional<User> optionalUser = userRepository.findByUsername(username);
        User user = optionalUser.orElse(null);

        if (user == null) {
            logger.info("User not found!");
            return null;
        }

        UserDTO userDTO = Converter.convertToUserDTO(user);

        return userDTO;

    }
}
