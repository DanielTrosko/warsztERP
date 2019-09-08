package com.example.warszterp.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter @Setter
public class Repair extends BaseEntity {

    @Column
    @NotNull
    private LocalDate dateOfAdmission;
    @Column
    @NotNull
    private LocalDate dataOfPickup;
    @Column
    @NotNull
    private Integer estimatedRepairCost;
    @Column
    @NotBlank
    private String scopeOfWork;
    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;



}
