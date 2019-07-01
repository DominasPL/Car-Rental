package com.github.DominasPL.CarRental.services;

import com.github.DominasPL.CarRental.domain.entities.Car;
import com.github.DominasPL.CarRental.domain.repositories.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private static final Logger logger = LoggerFactory.getLogger(CarService.class);

    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    public List<Car> getAllCars() {

        List<Car> allCars = carRepository.findAll();

        if (allCars == null) {
            logger.info("Cars not found!");
            return null;
        }

        return allCars;

    }
}
