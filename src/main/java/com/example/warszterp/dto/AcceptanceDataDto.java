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

    @NotBlank(message = "pole jest wymagane")
    private String acceptanceNumber;
    private Long repairId;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateOfAdmission;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataOfPickup;
    @NotNull(message = "pole jest wymagane")
    private Integer estimatedRepairCost;
    @NotBlank(message = "pole jest wymagane")
    private String scopeOfWork;

    private Long userId;
    @NotBlank(message = "pole jest wymagane")
    private String firstName;
    @NotBlank(message = "pole jest wymagane")
    private String surname;
    private String company;
    private boolean enabled;
    @NotBlank(message = "pole jest wymagane")
    private String phoneNumber;
    private String username;
    private String password;
    private String email;

    private Long carId;
    @NotBlank(message = "pole jest wymagane")
    private String make;
    @NotBlank(message = "pole jest wymagane")
    private String model;
    private Integer year;
    private Fuel fuel;
    private CarType type;
    @NotBlank(message = "pole jest wymagane")
    private String plateNumber;
    @NotBlank(message = "pole jest wymagane")
    private String vinNo;

    private Long addressId;
    @NotBlank(message = "pole jest wymagane")
    private String street;
    @NotBlank(message = "pole jest wymagane")
    private String houseNumber;
    @NotBlank(message = "pole jest wymagane")
    private String city;
    @NotBlank(message = "pole jest wymagane")
    private String postCode;

    private String mechanicUsername;

}
