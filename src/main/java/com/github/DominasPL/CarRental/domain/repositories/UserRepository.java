package com.github.DominasPL.CarRental.domain.repositories;

import com.github.DominasPL.CarRental.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    @Query(value = "SELECT id, password, username FROM users\n" +
            "JOIN users_roles ON users.id = users_roles.user_id\n" +
            "WHERE role_id = 1;", nativeQuery = true)
    List<User> findAdmins();

    @Query(value = "SELECT id, password, username FROM users\n" +
            "JOIN users_roles ON users.id = users_roles.user_id\n" +
            "WHERE role_id = 2;", nativeQuery = true)
    List<User> findUsers();
}

