package com.example.warszterp.services;

import com.example.warszterp.dto.AcceptanceDataDto;
import com.example.warszterp.dto.RepairDto;
import com.example.warszterp.mapper.RepairMapper;
import com.example.warszterp.model.entities.Car;
import com.example.warszterp.model.entities.Repair;
import com.example.warszterp.model.entities.RepairHistory;
import com.example.warszterp.model.entities.User;
import com.example.warszterp.model.repositories.RepairHistoryRepository;
import com.example.warszterp.model.repositories.RepairRepository;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.FetchProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class RepairService {

    private final RepairRepository repairRepository;
    private final RepairHistoryRepository repairHistoryRepository;
    private final UserService userService;

    public RepairService(RepairRepository repairRepository, RepairHistoryRepository repairHistoryRepository, UserService userService) {
        this.repairRepository = repairRepository;
        this.repairHistoryRepository = repairHistoryRepository;
        this.userService = userService;
    }

    public void getDataAndSave(AcceptanceDataDto data, User user, Car car){
        Repair repair = new Repair();
        repair = RepairMapper.acceptanceDataToEntity(data);
        repair.setCar(car);
        repair.setUser(user);
        Repair savedRepair = repairRepository.save(repair);
        RepairHistory initialNote = new RepairHistory();
        initialNote.setRepairId(savedRepair);
        initialNote.setMechanicId(userService.getByUsername(data.getMechanicUsername()));
        initialNote.setNoteDate(LocalDate.now());
        initialNote.setNote("Przyjęcie pojazdu na warsztat");
        repairHistoryRepository.save(initialNote);
     }

     public List<RepairDto> getAll(){
        List<Repair> list = repairRepository.findAll();
        return RepairMapper.toDtoList(list);
    }

    public AcceptanceDataDto getDataFromRepair(Long id){
        Repair repair =  new Repair();
        repair = repairRepository.findById(id).get();
        return RepairMapper.entityToAcceptanceData(repair);
    }

    public void getDataAndUpdate(AcceptanceDataDto data, User user, Car car){
        Repair repair = new Repair();
        repair = RepairMapper.acceptanceDataToEntity(data);
        repair.setCar(car);
        repair.setUser(user);
        repairRepository.save(repair);
    }
}
