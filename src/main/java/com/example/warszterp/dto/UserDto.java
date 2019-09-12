package com.example.warszterp.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter @Setter
public class UserDto {

    private Long id;

    @NotBlank
    private String username;

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;
    private boolean enabled;

    private Long addressId;

    private String houseNumber;

    private String city;

    private String postCode;

    private String street;



}
