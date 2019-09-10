package com.example.warszterp.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseUser {
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_address_id", nullable = false)
    @NotNull
    private Address address;


}
