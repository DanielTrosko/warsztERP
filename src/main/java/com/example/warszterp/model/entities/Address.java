package com.example.warszterp.model.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Embeddable
public class Address extends BaseEntity{

    @Column
    @NotBlank
    private String street;
    @Column
    @NotNull
    private Integer houseNumber;
    @Column
    @NotNull
    private Integer apartmentNumber;
    @Column
    @NotBlank
    private String city;
    @Column
    @NotBlank
    private String postCode;
}
