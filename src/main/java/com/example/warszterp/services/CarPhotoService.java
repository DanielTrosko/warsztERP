package com.example.warszterp.services;

import com.example.warszterp.dto.CarPhotoDTO;
import com.example.warszterp.model.entities.CarPhoto;
import com.example.warszterp.model.entities.Repair;
import com.example.warszterp.model.repositories.CarPhotoRepository;
import com.example.warszterp.model.repositories.RepairRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarPhotoService {
    private RepairRepository repairRepository;
    private CarPhotoRepository carPhotoRepository;

    public CarPhotoService(RepairRepository repairRepository, CarPhotoRepository carPhotoRepository) {
        this.repairRepository = repairRepository;
        this.carPhotoRepository = carPhotoRepository;
    }

    public void addRepairPhoto(Long id, CarPhotoDTO carPhotoDTO) {
        Repair result = repairRepository.getOne(id);
        CarPhoto carPhoto = new CarPhoto();
        carPhoto.setContentType(carPhotoDTO.getContentType());
        carPhoto.setFileData(carPhotoDTO.getData());
        carPhoto.setFileName(carPhotoDTO.getFileName());
        carPhoto.setRepair(result);
        carPhotoRepository.save(carPhoto);
    }

    public List<CarPhotoDTO> getRepairPhotos(Long id) {
        List<CarPhoto> carPhotos = carPhotoRepository.findAllByRepairId(id);
        return carPhotos.stream()
                .map(entity -> {
                    CarPhotoDTO dto = new CarPhotoDTO();
                    dto.setId(entity.getRepair().getId());
                    dto.setContentType(entity.getContentType());
                    dto.setFileName(entity.getFileName());
                    return dto;
                }).collect(Collectors.toList());
    }

    public CarPhotoDTO getPhotoData(Long id) {
        return carPhotoRepository.findById(id).map(entity -> {
            CarPhotoDTO dto = new CarPhotoDTO();
            dto.setFileName(entity.getFileName());
            dto.setContentType(entity.getContentType());
            dto.setData(entity.getFileData());
            return dto;
        }).orElseGet(() -> {
            CarPhotoDTO dto = new CarPhotoDTO();
            dto.setFileName("notFound");
            dto.setContentType("application/octet-stream");
            dto.setData(new byte[0]);
            return dto;
        });
    }
}
