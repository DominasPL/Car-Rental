package com.github.DominasPL.CarRental.converters;

import com.github.DominasPL.CarRental.domain.entities.User;
import com.github.DominasPL.CarRental.domain.entities.UserDetails;
import com.github.DominasPL.CarRental.dtos.EditDetailsDTO;
import com.github.DominasPL.CarRental.dtos.RegistrationDTO;
import com.github.DominasPL.CarRental.dtos.UserDTO;
import com.github.DominasPL.CarRental.dtos.UserDetailsDTO;

public class Converter {

    public static User convertToUser(RegistrationDTO form) {

        User user = new User();
        user.setUsername(form.getUsername());
        user.setPassword(form.getPassword());

        return user;
    }

    public static UserDTO convertToUserDTO(User user) {

        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());

        return userDTO;
    }

    public static EditDetailsDTO convertToEditUserDTO(User user) {

        EditDetailsDTO editDetailsDTO = new EditDetailsDTO();
        UserDetails userDetails = user.getUserDetails();
        editDetailsDTO.setEmail(userDetails.getEmail());
        editDetailsDTO.setFirstName(userDetails.getFirstName());
        editDetailsDTO.setLastName(userDetails.getLastName());
        editDetailsDTO.setAddress(userDetails.getAddress());
        editDetailsDTO.setPhoneNumber(userDetails.getPhoneNumber());
        editDetailsDTO.setPostalCode(userDetails.getPostalCode());

        return editDetailsDTO;

    }

    public static UserDetailsDTO convertToUserDetailsDTO(UserDetails userDetails) {

        UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
        userDetailsDTO.setEmail(userDetails.getEmail());

        return userDetailsDTO;
    }
}
