package com.example.warszterp.model.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @NotNull
    private String email;
    @Column
    @NotNull
    private String password;
    @Column
    @NotNull
    private String name;
    @Column
    @NotNull
    private String surname;
    @Embedded
    private Address address;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id", nullable = false)
    @NotNull
    private Car car;
    @NotNull
    @Column(name = "enabled")
    private boolean enabled;


}
