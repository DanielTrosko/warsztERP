package com.example.warszterp.model.repositories;

import com.example.warszterp.model.entities.Repair;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepairRepository extends JpaRepository<Repair, Long> {
    //TODO
    //Change String to Integer or Long
    Repair getByAcceptanceNumber(String number);
    Repair getByIdIs(String number);


    List<Repair> findAllByCar_Owner_Username(String user);
}
