package com.example.warszterp.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseUser {
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_address_id", nullable = false)
    private Address address;
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Car> cars;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Repair> repairs;

}
