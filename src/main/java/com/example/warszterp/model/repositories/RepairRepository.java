package com.example.warszterp.model.repositories;

import com.example.warszterp.model.entities.Repair;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepairRepository extends JpaRepository<Repair, Long> {
    //TODO
    //Change String to Integer or Long
    Repair getByAcceptanceNumber(String number);
    Repair getByIdIs(String number);

}
