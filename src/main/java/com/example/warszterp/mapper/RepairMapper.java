package com.example.warszterp.mapper;

import com.example.warszterp.dto.AcceptanceDataDto;
import com.example.warszterp.dto.RepairDto;
import com.example.warszterp.model.entities.Repair;

import java.util.List;
import java.util.stream.Collectors;

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


    public static Repair toEntity(RepairDto dto){
        Repair repair = new Repair();
        repair.setUser(dto.getUser());
        repair.setCar(dto.getCar());
        repair.setId(dto.getId());
        repair.setScopeOfWork(dto.getScopeOfWork());
        repair.setEstimatedRepairCost(dto.getEstimatedRepairCost());
        repair.setDateOfAdmission(dto.getDateOfAdmission());
        repair.setDataOfPickup(dto.getDataOfPickup());
        repair.setAcceptanceNumber(dto.getAcceptanceNumber());

        return repair;
    }

    public static RepairDto toDto(Repair repair){
        RepairDto dto = new RepairDto();
        dto.setUser(repair.getUser());
        dto.setCar(repair.getCar());
        dto.setId(repair.getId());
        dto.setScopeOfWork(repair.getScopeOfWork());
        dto.setEstimatedRepairCost(repair.getEstimatedRepairCost());
        dto.setDateOfAdmission(repair.getDateOfAdmission());
        dto.setDataOfPickup(repair.getDataOfPickup());
        dto.setAcceptanceNumber(repair.getAcceptanceNumber());

        return dto;
    }

    public static List<RepairDto> toDtoList(List<Repair> list){
        return list.stream().map(repair -> toDto(repair)).collect(Collectors.toList());
    }
}
