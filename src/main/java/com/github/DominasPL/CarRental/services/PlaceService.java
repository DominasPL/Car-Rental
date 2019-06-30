package com.github.DominasPL.CarRental.services;

import com.github.DominasPL.CarRental.converters.Converter;
import com.github.DominasPL.CarRental.domain.entities.Place;
import com.github.DominasPL.CarRental.domain.repositories.PlaceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService {

    private static final Logger logger = LoggerFactory.getLogger(PlaceService.class);

    private PlaceRepository placeRepository;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }


    public List<Place> getAllPlaces() {

        List<Place> allPlaces = placeRepository.findAll();

        if (allPlaces == null) {
            logger.info("Places not found!");
            return null;
        }


        return allPlaces;

    }
}
