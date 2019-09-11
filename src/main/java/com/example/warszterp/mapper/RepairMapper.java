package com.example.warszterp.mapper;

import com.example.warszterp.dto.AcceptanceDataDto;
import com.example.warszterp.model.entities.Car;
import com.example.warszterp.model.entities.Repair;
import com.example.warszterp.model.repositories.RepairRepository;

public class RepairMapper {

    public static AcceptanceDataDto entityToAcceptanceData(Repair repair) {
        AcceptanceDataDto data = new AcceptanceDataDto();
        data.setAcceptanceNumber(repair.getAcceptanceNumber());
        data.setDataOfPickup(repair.getDataOfPickup());
        data.setDateOfAdmission(repair.getDateOfAdmission());
        data.setEstimatedRepairCost(repair.getEstimatedRepairCost());
        data.setScopeOfWork(repair.getScopeOfWork());
        data.setRepairId(repair.getId());
        data.setUserId(repair.getUser().getId());
        data.setCarId(repair.getCar().getId());

        return data;
    }

    public static Repair acceptanceDataToEntity(AcceptanceDataDto data) {
        Repair repair = new Repair();
        repair.setAcceptanceNumber(data.getAcceptanceNumber());
        repair.setDataOfPickup(data.getDataOfPickup());
        repair.setDateOfAdmission(data.getDateOfAdmission());
        repair.setEstimatedRepairCost(data.getEstimatedRepairCost());
        repair.setScopeOfWork(data.getScopeOfWork());
        repair.setId(data.getRepairId());

        return repair;
    }
}
