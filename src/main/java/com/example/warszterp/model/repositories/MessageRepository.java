package com.example.warszterp.model.repositories;

import com.example.warszterp.model.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
