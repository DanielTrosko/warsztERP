package com.example.warszterp.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
@Getter
@Setter
public class MessageDTO {
    @NotBlank
    private String title;
    @NotBlank
    private String message;
    @NotBlank
    private String ip;
}
