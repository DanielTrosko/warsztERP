package com.example.warszterp.dto;

import com.example.warszterp.model.entities.Repair;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarPhotoDTO {
    private Long id;
    private Repair repair;
    private String contentType;
    private String fileName;
    private byte[] data;
}
