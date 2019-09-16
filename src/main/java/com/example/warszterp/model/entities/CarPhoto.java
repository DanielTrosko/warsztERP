package com.example.warszterp.model.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "car_photo")
@NoArgsConstructor
public class CarPhoto extends BaseEntity{

    @ManyToOne(optional = false)
    @JoinColumn(name = "repair_id")
    private Repair repair;
    @Column(name = "content_type")
    private String contentType;
    @Column(name = "file_name")
    private String fileName;
    @Lob
    @Column(name = "file_data", columnDefinition = "MEDIUMBLOB")
    private byte[] fileData;

}
