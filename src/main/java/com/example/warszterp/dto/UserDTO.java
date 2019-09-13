package com.example.warszterp.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Getter @Setter
@ToString
public class UserDTO {

    private Long id;
    @NotBlank(message = "pole jest wymagane")
    private String username;
    @NotBlank(message = "pole jest wymagane") @Email
    private String email;
    @NotBlank(message = "pole jest wymagane")
    private String phoneNumber;
    @NotBlank(message = "pole jest wymagane")
    private String password;
    @NotBlank(message = "pole jest wymagane")
    private String rePassword;
    @NotBlank(message = "pole jest wymagane")
    private String firstName;
    @NotBlank(message = "pole jest wymagane")
    private String surname;
    private String company;
    private boolean enabled;
    private Long addressId;
    @NotBlank(message = "pole jest wymagane")
    private String street;
    @NotBlank(message = "pole jest wymagane")
    private String houseNumber;
    @NotBlank(message = "pole jest wymagane")
    private String postCode;
    @NotBlank(message = "pole jest wymagane")
    private String city;





}
