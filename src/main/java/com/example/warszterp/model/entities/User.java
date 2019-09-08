package com.example.warszterp.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
@Entity
@Getter @Setter
@NoArgsConstructor
public class User extends BaseUser {
    @Embedded
    private Address address;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id", nullable = false)
    @NotNull
    private Car car;


}
