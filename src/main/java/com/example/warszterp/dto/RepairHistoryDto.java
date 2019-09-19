package com.example.warszterp.dto;

import com.example.warszterp.model.entities.Repair;
import com.example.warszterp.model.entities.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class RepairHistoryDto {

    private Long id;
    private LocalDate noteDate;
    private String note;
    private User mechanicId;
    private Repair repairId;

}
