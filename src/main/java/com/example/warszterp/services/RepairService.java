package com.example.warszterp.services;

import com.example.warszterp.dto.AcceptanceDataDto;
import com.example.warszterp.mapper.RepairMapper;
import com.example.warszterp.model.entities.Car;
import com.example.warszterp.model.entities.Repair;
import com.example.warszterp.model.entities.User;
import com.example.warszterp.model.repositories.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
@Service
@Transactional
public class RepairService {

    private RepairRepository repairRepository;
//    @PersistenceContext
//    private EntityManager entityManager;

    @Autowired
    public RepairService(RepairRepository repairRepository) {
        this.repairRepository = repairRepository;
    }



     public void getDataAndSave(AcceptanceDataDto data, User user, Car car){

        Repair repair = new Repair();
        repair = RepairMapper.acceptanceDataToEntity(data);
        repair.setCar(car);
        repair.setUser(user);

        repairRepository.save(repair);

     }
}
