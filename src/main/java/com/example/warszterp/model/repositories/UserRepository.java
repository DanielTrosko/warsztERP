package com.example.warszterp.model.repositories;

import com.example.warszterp.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Long, User> {
}
