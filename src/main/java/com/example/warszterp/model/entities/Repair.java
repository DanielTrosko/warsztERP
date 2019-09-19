package com.example.warszterp.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@NoArgsConstructor
@Getter @Setter
public class Repair extends BaseEntity {

    @Column(name = "acceptance_no")
    private String acceptanceNumber;
    @Column(name ="date_of_admission", nullable = false, columnDefinition = "DATE NOT NULL")
    private LocalDate dateOfAdmission;
    @Column(name = "date_of_pickup", nullable = false, columnDefinition = "DATE NOT NULL")
    private LocalDate dataOfPickup;
    @Column(name = "estimated_repair_cost", nullable = false)
    private Integer estimatedRepairCost;
    @Column(name = "scope_of_work", nullable = false)
    private String scopeOfWork;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mechanic_id", nullable = false)
    private User mechanic;
    @OneToMany(mappedBy = "repairId", cascade = CascadeType.ALL)
    private List<RepairHistory> repairHistory;
}
