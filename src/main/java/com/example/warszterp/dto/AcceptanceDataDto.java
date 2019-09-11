package com.example.warszterp.dto;

import com.example.warszterp.model.entities.CarType;
import com.example.warszterp.model.entities.Fuel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@ToString
public class AcceptanceDataDto {

    @NotBlank
    private String acceptanceNumber;
    private Long repairId;
    @NotBlank
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateOfAdmission;
    @NotBlank
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataOfPickup;
    @NotNull
    private Integer estimatedRepairCost;
    @NotBlank
    private String scopeOfWork;

    private Long userId;
    @NotBlank
    private String firstName;
    @NotBlank
    private String surname;
    private String company;
    private boolean enabled;
    @NotBlank
    private String phoneNumber;
    private String username;
    private String password;
    private String email;

    private Long carId;
    @NotBlank
    private String make;
    @NotBlank
    private String model;
    @NotBlank
    private Integer year;
    @NotBlank
    private Fuel fuel;
    @NotBlank
    private CarType type;
    @NotBlank
    private String plateNumber;
    @NotBlank
    private String vinNo;

    private Long addressId;
    @NotBlank
    private String street;
    @NotBlank
    private String houseNumber;
    @NotBlank
    private String city;
    @NotBlank
    private String postCode;

}
