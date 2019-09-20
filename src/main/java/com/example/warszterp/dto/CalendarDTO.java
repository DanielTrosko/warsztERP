package com.example.warszterp.dto;

import com.example.warszterp.model.entities.Repair;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class CalendarDTO {
    private Long id;
    @NotBlank(message = "wpisz nazwe event'u")
    private String name;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate startDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate stopDate;
    private String description;
    @NotBlank
    private String employee;
    private String repair;

}
