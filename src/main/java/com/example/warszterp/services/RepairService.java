package com.example.warszterp.services;

import com.example.warszterp.model.repositories.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
@Service
public class RepairService {

    private RepairRepository repairRepository;
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public RepairService(RepairRepository repairRepository) {
        this.repairRepository = repairRepository;
    }
}
