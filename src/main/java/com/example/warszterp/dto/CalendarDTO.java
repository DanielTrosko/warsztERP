package com.example.warszterp.dto;

import com.example.warszterp.model.entities.Repair;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class CalendarDTO {
    private Long id;
    @NotBlank(message = "wpisz nazwe event'u")
    private String name;
    @NotNull
    private LocalDateTime startDate;
    @NotNull
    private LocalDateTime stopDate;
    private String description;
    @NotBlank
    private String employee;
    private Repair repair;

}
