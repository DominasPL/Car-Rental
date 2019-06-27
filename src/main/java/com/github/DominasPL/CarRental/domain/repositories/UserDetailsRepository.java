package com.github.DominasPL.CarRental.domain.repositories;

import com.github.DominasPL.CarRental.domain.entities.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {

    Optional<UserDetails> findByEmail(String email);
}
