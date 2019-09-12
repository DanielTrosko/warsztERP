package com.example.warszterp.model.repositories;

import com.example.warszterp.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByPhoneNumberAndSurnameAndFirstName(String phoneNumber, String surname, String firstName);
}
