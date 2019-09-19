package com.example.warszterp.mapper;

import com.example.warszterp.dto.RepairHistoryDto;
import com.example.warszterp.model.entities.RepairHistory;

import java.util.List;
import java.util.stream.Collectors;

public class RepairHistoryMapper {


    public static RepairHistory toEntity(RepairHistoryDto dto){

        RepairHistory repairHistory = new RepairHistory();
        repairHistory.setRepairId(dto.getRepairId());
        repairHistory.setMechanicId(dto.getMechanicId());
        repairHistory.setNoteDate(dto.getNoteDate());
        repairHistory.setId(dto.getId());
        repairHistory.setNote(dto.getNote());

        return repairHistory;
    }

    public static RepairHistoryDto toDto(RepairHistory repairHistory){

        RepairHistoryDto dto = new RepairHistoryDto();
        dto.setRepairId(repairHistory.getRepairId());
        dto.setMechanicId(repairHistory.getMechanicId());
        dto.setNoteDate(repairHistory.getNoteDate());
        dto.setId(repairHistory.getId());
        dto.setNote(repairHistory.getNote());

        return dto;
    }

    public static List<RepairHistoryDto> toDtoList(List<RepairHistory> list){
    return list.stream().map(repairHistory -> toDto(repairHistory)).collect(Collectors.toList());
    }
}
