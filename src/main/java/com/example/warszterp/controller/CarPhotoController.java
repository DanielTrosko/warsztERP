package com.example.warszterp.controller;

import com.example.warszterp.dto.CarPhotoDTO;
import com.example.warszterp.model.entities.CarPhoto;
import com.example.warszterp.model.repositories.RepairRepository;
import com.example.warszterp.services.CarPhotoService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping(value = "/car/photo")
public class CarPhotoController {
    private CarPhotoService carPhotoService;
    private RepairRepository repairRepository;


    public CarPhotoController(CarPhotoService carPhotoService, RepairRepository repairRepository) {
        this.carPhotoService = carPhotoService;
        this.repairRepository = repairRepository;
    }

    @GetMapping(value = "/add{lId}")
    public String preparePhotos(Long id, Model model) {
        model.addAttribute("id", id.toString());
        return "/views/add_photo";
    }

    @PostMapping("/add/{id}")
    public String uploadFiles(@RequestParam MultipartFile file, Model model, @PathVariable Long id) throws IOException {
        if (file == null || file.getBytes().length == 0) {
            model.addAttribute("error", "Brak pliku");
            return "redirect:/views/cos";
        } else if (file.getContentType().startsWith("image")) {
            CarPhotoDTO carPhotoDTO = new CarPhotoDTO();
            carPhotoDTO.setFileName(file.getOriginalFilename());
            carPhotoDTO.setContentType(file.getContentType());
            carPhotoDTO.setData(file.getBytes());
            carPhotoDTO.setRepair(repairRepository.getOne(id));
            carPhotoService.addRepairPhoto(id, carPhotoDTO);
            model.addAttribute("add", "Photo was add");
            model.addAttribute("files", carPhotoService.getRepairPhotos(id));
            return "/views/add_photo";
        }
        model.addAttribute("photo", "Only image");
        return "/views/add_photo";
    }

    @GetMapping(value = "/show/{photoId}")
    @ResponseBody
    public ResponseEntity<Resource> loadPhoto(@PathVariable Long photoId){
        CarPhotoDTO carPhotoDTO = carPhotoService.getPhotoData(photoId);
        ByteArrayResource resource = new ByteArrayResource(carPhotoDTO.getData());
        return ResponseEntity
                .ok()
                .contentType(MediaType.valueOf(carPhotoDTO.getContentType()))
                .body(resource);
    }
}
