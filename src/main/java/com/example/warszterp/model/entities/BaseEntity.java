package com.example.warszterp.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class BaseEntity {
    @Id
    @GeneratedValue
    private Long id;
}
