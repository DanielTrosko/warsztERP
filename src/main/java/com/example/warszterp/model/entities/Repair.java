package com.example.warszterp.model.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Repair extends BaseEntity{

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
    @Column
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;


}
