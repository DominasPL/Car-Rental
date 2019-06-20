package com.github.DominasPL.CarRental.domain.repositories;

import com.github.DominasPL.CarRental.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}

