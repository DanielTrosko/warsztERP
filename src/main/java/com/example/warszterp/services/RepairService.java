package com.example.warszterp.services;

import com.example.warszterp.model.repositories.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class RepairService {

    private RepairRepository repairRepository;
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public RepairService(RepairRepository repairRepository) {
        this.repairRepository = repairRepository;
    }
}
