package com.github.DominasPL.CarRental.converters;

import com.github.DominasPL.CarRental.domain.entities.*;
import com.github.DominasPL.CarRental.dtos.*;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    public static User convertToAdmin(RegistrationDTO form) {

        User user = new User();
        user.setUsername(form.getUsername());
        user.setPassword(form.getPassword());
        List<Role> roles = user.getRoles();
        Role role = new Role();
        role.setId(1L);
        role.setRole("ROLE_ADMIN");
        roles.add(role);

        return user;

    }

    public static User convertToUser(RegistrationDTO form) {

        User user = new User();
        user.setUsername(form.getUsername());
        user.setPassword(form.getPassword());
        List<Role> roles = user.getRoles();
        Role role = new Role();
        role.setId(2L);
        role.setRole("ROLE_USER");
        roles.add(role);

        return user;
    }


    public static UserDTO convertToUserDTO(User user) {

        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        List<Role> roles = user.getRoles();
        userDTO.setRole(roles.get(0).getRole());

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


    public static List<UserDTO> convertToListUserDTO(List<User> allUsers) {

        List<UserDTO> usersDTO = new ArrayList<>();
        for (User user : allUsers) {
            UserDTO userDTO = new UserDTO();
            userDTO.setUsername(user.getUsername());
            usersDTO.add(userDTO);
        }

        return usersDTO;

    }

    public static List<RentalDTO> convertToRentalsDTO(List<Rental> allRentals) {

        List<RentalDTO> rentalsDTO = new ArrayList<>();

        for (Rental rental : allRentals) {
            RentalDTO rentalDTO = new RentalDTO();
            rentalDTO.setHireDate(rental.getHireDate());
            rentalDTO.setReturnDate(rental.getReturnDate());
            rentalDTO.setHirePlace(rental.getHirePlace());
            rentalDTO.setReturnPlace(rental.getReturnPlace());
            rentalDTO.setUsername(rental.getUser().getUsername());

            rentalsDTO.add(rentalDTO);
        }

        return rentalsDTO;

    }
}
