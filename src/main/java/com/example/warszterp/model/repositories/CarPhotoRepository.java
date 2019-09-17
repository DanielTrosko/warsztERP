package com.example.warszterp.model.repositories;

import com.example.warszterp.model.entities.CarPhoto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CarPhotoRepository extends JpaRepository<CarPhoto, Long> {
    List<CarPhoto> findAllByRepairId(Long id);
    Optional<CarPhoto> findById(Long id);
}
