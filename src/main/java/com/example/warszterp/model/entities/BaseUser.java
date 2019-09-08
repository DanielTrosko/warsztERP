package com.example.warszterp.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public abstract class BaseUser {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "created_on")
    private LocalDateTime createdOn;
    @Column(name = "updated_on")
    private LocalDateTime updateOn;
    @Column
    @NotNull
    private String email;
    @Column
    @NotNull
    private String password;
    @Column
    @NotNull
    private String name;
    @Column
    @NotNull
    private String surname;
    @NotNull
    @Column(name = "enabled")
    private boolean enabled;
}
