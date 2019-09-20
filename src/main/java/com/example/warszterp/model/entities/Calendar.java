package com.example.warszterp.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Calendar extends BaseEntity {
    private String name;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "stop_date")
    private LocalDate stopDate;
    private String description;
    private String employee;
    private String repair;
}
