package com.example.warszterp.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@Setter @Getter
public class Car extends BaseEntity {

    @Column
    @NotBlank
    private String mark;
    @Column
    @NotBlank
    private String model;
    @Column
    @NotNull
    private Integer year;
    @Column
    @NotBlank
    private Fuel fuel;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull
    private User user;
}
