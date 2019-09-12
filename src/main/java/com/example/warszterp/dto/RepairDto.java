package com.example.warszterp.dto;

import com.example.warszterp.model.entities.Car;
import com.example.warszterp.model.entities.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.time.LocalDate;

@Getter
@Setter
@ToString
public class RepairDto {

    private Long id;
    private String acceptanceNumber;
    private LocalDate dateOfAdmission;
    private LocalDate dataOfPickup;
    private Integer estimatedRepairCost;
    private String scopeOfWork;
    private Car car;
    private User user;
}
