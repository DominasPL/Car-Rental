package com.github.DominasPL.CarRental.services;

import com.github.DominasPL.CarRental.domain.entities.Rental;
import com.github.DominasPL.CarRental.domain.entities.User;
import com.github.DominasPL.CarRental.domain.repositories.RentalRepository;
import com.github.DominasPL.CarRental.domain.repositories.UserRepository;
import com.github.DominasPL.CarRental.dtos.RentalDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class RentalService {

    private static final Logger logger = LoggerFactory.getLogger(RentalService.class);

    private RentalRepository rentalRepository;
    private UserRepository userRepository;

    public RentalService(RentalRepository rentalRepository, UserRepository userRepository) {
        this.rentalRepository = rentalRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveRental(RentalDTO form, String hireDate, String returnDate, String username) {

        Optional<User> optionalUser = userRepository.findByUsername(username);
        User user = optionalUser.orElse(null);

        if (user == null) {
            logger.info("User not found!");

        } else {

            Rental rental = new Rental();
            rental.setHirePlace(form.getHirePlace());
            rental.setReturnPlace(form.getReturnPlace());
            rental.setHireDate(hireDate);
            rental.setReturnDate(returnDate);
            rental.setUser(user);
            rentalRepository.save(rental);
        }

    }
}
