package com.github.DominasPL.CarRental.domain.repositories;

import com.github.DominasPL.CarRental.domain.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Long> {


}
