package com.example.warszterp.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
@Entity
@Getter @Setter
@NoArgsConstructor
public class User extends BaseEntity{
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
