package com.example.warszterp.services;

import com.example.warszterp.dto.AcceptanceDataDto;
import com.example.warszterp.dto.RepairDto;
import com.example.warszterp.dto.RepairHistoryDto;
import com.example.warszterp.mapper.RepairHistoryMapper;
import com.example.warszterp.mapper.RepairMapper;
import com.example.warszterp.model.entities.Car;
import com.example.warszterp.model.entities.Repair;
import com.example.warszterp.model.entities.RepairHistory;
import com.example.warszterp.model.entities.User;
import com.example.warszterp.model.repositories.RepairHistoryRepository;
import com.example.warszterp.model.repositories.RepairRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public void getDataAndSave(AcceptanceDataDto data, Car car){
        Repair repair = new Repair();
        repair = RepairMapper.acceptanceDataToEntity(data);
        repair.setCar(car);
        User mechanic = userService.getByUsername(data.getMechanicUsername());
        repair.setMechanic(mechanic);
        Repair savedRepair = repairRepository.save(repair);
        RepairHistory initialNote = new RepairHistory();
        initialNote.setRepairId(savedRepair);
        initialNote.setMechanicId(mechanic);
        initialNote.setNoteDate(LocalDate.now());
        initialNote.setNote("Przyjęcie pojazdu na warsztat");
        repairHistoryRepository.save(initialNote);
     }

     public List<RepairDto> getAll(){
        List<Repair> list = repairRepository.findAll();
        return RepairMapper.toDtoList(list);

    }

    public List<RepairDto> getAllByUsername(String username){
        List<Repair> list = repairRepository.findAllByCar_Owner_Username(username);
        return RepairMapper.toDtoList(list);
    }

    public RepairHistoryDto getFilledRepairHistoryObjectWithNoNote(String mechanicUsername, Long repairId){

        RepairHistory repairHistory = new RepairHistory();
        repairHistory.setNoteDate(LocalDate.now());
        repairHistory.setMechanicId(userService.getByUsername(mechanicUsername));
        repairHistory.setRepairId(repairRepository.getOne(repairId));
        return RepairHistoryMapper.toDto(repairHistory);
    }

    public RepairHistoryDto getRepairHistoryElemById(Long id){
      return   RepairHistoryMapper.toDto(repairHistoryRepository.getOne(id));
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
        repair.setMechanic(user);
        repairRepository.save(repair);
    }

    public List<RepairHistoryDto> getAllRepairHistoryByRepairId(Long repairId){
       return RepairHistoryMapper.toDtoList(repairHistoryRepository.findAllByRepairId_Id(repairId));
    }

    public void saveRepairHistoryElem(RepairHistoryDto repairHistory){
        repairHistoryRepository.save(RepairHistoryMapper.toEntity(repairHistory));
    }

    public void deleteRepairHistoryElem(Long elemId){
        repairHistoryRepository.deleteById(elemId);
    }
}
