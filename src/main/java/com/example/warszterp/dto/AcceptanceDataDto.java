package com.example.warszterp.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class AcceptanceDataDto {

    private Long id_repair;
    private LocalDateTime dateOfAdmission;
    private LocalDateTime dataOfPickup;
    private Integer estimatedRepairCost;
    private String scopeOfWork;
}
