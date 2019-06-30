package com.github.DominasPL.CarRental.domain.repositories;

import com.github.DominasPL.CarRental.domain.entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Long> {


}
