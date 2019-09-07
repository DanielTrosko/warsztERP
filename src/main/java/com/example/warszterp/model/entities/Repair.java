package com.example.warszterp.model.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Repair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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


}
