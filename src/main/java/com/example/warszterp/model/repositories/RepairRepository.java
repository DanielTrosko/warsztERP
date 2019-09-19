package com.example.warszterp.model.repositories;

import com.example.warszterp.model.entities.Repair;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepairRepository extends JpaRepository<Repair, Long> {

    List<Repair> findAllByUser_Username(String user);
    List<Repair> findAllByCar_Owner_Username(String user);
}
