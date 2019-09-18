package com.example.warszterp.model.repositories;

import com.example.warszterp.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByPhoneNumberAndSurnameAndFirstName(String phoneNumber, String surname, String firstName);
    User getByUsername(String username);
    Optional<User> findByUsername(String username);
}
