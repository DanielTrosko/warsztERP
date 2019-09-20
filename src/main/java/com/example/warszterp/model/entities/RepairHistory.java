package com.example.warszterp.model.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "repair_history")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RepairHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "note_date")
    private LocalDate noteDate;
    @Column(name = "note")
    private String note;
    @ManyToOne
    @JoinColumn(name = "mechanic_id")
    private User mechanicId;
    @ManyToOne
    @JoinColumn(name = "repair_id")
    private Repair repairId;

}
