package com.example.warszterp.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class UserDTO {

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

    private Integer apartamentNumber;

    private Integer houseNumber;

    private String city;

    private String postCode;

    private String street;


}
