package com.github.DominasPL.CarRental.services;

import com.github.DominasPL.CarRental.converters.Converter;
import com.github.DominasPL.CarRental.domain.entities.Role;
import com.github.DominasPL.CarRental.domain.entities.User;
import com.github.DominasPL.CarRental.domain.entities.UserDetails;
import com.github.DominasPL.CarRental.domain.repositories.UserDetailsRepository;
import com.github.DominasPL.CarRental.domain.repositories.UserRepository;
import com.github.DominasPL.CarRental.dtos.EditDetailsDTO;
import com.github.DominasPL.CarRental.dtos.RegistrationDTO;
import com.github.DominasPL.CarRental.dtos.UserDTO;
import com.github.DominasPL.CarRental.dtos.UserDetailsDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private UserDetailsRepository userDetailsRepository;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserDetailsRepository userDetailsRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsRepository = userDetailsRepository;
    }

    @Transactional
    public void registerUser(RegistrationDTO form) {

        List<User> allUsers = userRepository.findAll();

        if (allUsers.size() < 1) {
            //AddAdmin
            User user = Converter.convertToAdmin(form);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            UserDetails userDetails = new UserDetails();
            userDetails.setId(user.getId());
            user.setUserDetails(userDetails);

        } else {
            //AddUser
            User user = Converter.convertToUser(form);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            UserDetails userDetails = new UserDetails();
            userDetails.setId(user.getId());
            user.setUserDetails(userDetails);

        }

    }

    @Transactional
    public void editUserDetails(EditDetailsDTO form, String username) {

        Optional<User> optionalUser = userRepository.findByUsername(username);
        User user = optionalUser.orElse(null);

        if (user == null) {
            logger.info("User not found!");

        } else {

            UserDetails userDetails = user.getUserDetails();
            userDetails.setEmail(form.getEmail());
            userDetails.setFirstName(form.getFirstName());
            userDetails.setLastName(form.getLastName());
            userDetails.setAddress(form.getAddress());
            userDetails.setPhoneNumber(form.getPhoneNumber());
            userDetails.setPostalCode(form.getPostalCode());
        }


    }

    public UserDTO findUserByUsername(String username) {

        if (username == null) {
            throw new IllegalArgumentException("Username has to be given!");
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

    public EditDetailsDTO findUserDetails(String username) {

        if (username == null) {
            throw new IllegalArgumentException("Username has to be given!");
        }

        Optional<User> optionalUser = userRepository.findByUsername(username);
        User user = optionalUser.orElse(null);

        if (user == null) {
            logger.info("User not found!");
            return null;
        }

        EditDetailsDTO editDetailsDTO = Converter.convertToEditUserDTO(user);

        return editDetailsDTO;

    }

    public UserDetailsDTO checkIsEmailInDatabase(String email) {

        if (email == null) {
            throw new IllegalArgumentException("Username has to be given!");
        }

        Optional<UserDetails> optionalUserDetails = userDetailsRepository.findByEmail(email);
        UserDetails userDetails = optionalUserDetails.orElse(null);

        if (userDetails == null) {
            logger.info("UserDetails not found!");
            return null;
        }

        UserDetailsDTO userDetailsDTO = Converter.convertToUserDetailsDTO(userDetails);

        return userDetailsDTO;

    }

    public List<UserDTO> loadAllUsers() {

        List<User> allUsers = userRepository.findUsers();

        if (allUsers == null) {
            logger.info("Users not found!");
            return null;
        }

        List<UserDTO> usersDTO = Converter.convertToListUserDTO(allUsers);

        return usersDTO;

    }

    public List<UserDTO> loadAllAdmins() {
        List<User> allAdmins = userRepository.findAdmins();

        if (allAdmins == null) {
            logger.info("Admins not found!");
            return null;
        }

        List<UserDTO> adminsDTO = Converter.convertToListUserDTO(allAdmins);

        return adminsDTO;


    }
}
