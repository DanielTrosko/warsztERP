package com.example.warszterp.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Setter @Getter
public class Car extends BaseEntity {

    @Column(nullable = false)
    private String make;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private Integer year;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Fuel fuel;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
