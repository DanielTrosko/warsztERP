package com.example.warszterp.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Calendar extends BaseEntity {
    private String name;
    @Column(name = "start_date")
    private LocalDateTime startDate;
    @Column(name = "stop_date")
    private LocalDateTime stopDate;
    private String description;
    private String employee;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "repair_id", nullable = false)
    private Repair repair;
}
