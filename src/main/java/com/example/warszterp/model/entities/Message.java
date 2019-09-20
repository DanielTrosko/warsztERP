package com.example.warszterp.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
@Entity
@Getter
@Setter
public class Message extends BaseEntity{
    @NotBlank
    private String title;
    @NotBlank
    private String message;
    @NotBlank
    private String ip;
}
