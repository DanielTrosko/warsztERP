package com.example.warszterp.dto;

import com.example.warszterp.model.entities.Car;
import com.example.warszterp.model.entities.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@ToString
public class RepairDto {

    private Long id;
    private String acceptanceNumber;
    private LocalDate dateOfAdmission;
    private LocalDate dataOfPickup;
    @NotNull(message = "pole jest wymagane")
    private Integer estimatedRepairCost;
    @NotBlank(message = "pole jest wymagane")
    private String scopeOfWork;
    private Car car;
    private User user;
}
