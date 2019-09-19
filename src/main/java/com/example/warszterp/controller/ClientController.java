package com.example.warszterp.controller;

import com.example.warszterp.dto.CarDto;
import com.example.warszterp.dto.RepairDto;
import com.example.warszterp.services.CarService;
import com.example.warszterp.services.RepairService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {

    private final CarService carService;
    private final RepairService repairService;


    public ClientController(CarService carService, RepairService repairService) {
        this.carService = carService;
        this.repairService = repairService;
    }

    @GetMapping("/cars")
    public String displayCars(Principal principal, Model model){

       List<CarDto> cars = carService.getAllByUsername(principal.getName());
       model.addAttribute("list", cars);
        return "cars_list";
    }

    @GetMapping("/repairs")
    public String displayRepairs(Model model, Principal principal){

       List<RepairDto> repairs = repairService.getAllByUsername(principal.getName());
        model.addAttribute("repairs", repairs);
        return "repair_list";
    }

    @GetMapping("/history/{repairId}")
    public String displayRepairHistory(Model model, @PathVariable("repairId") Long id){

        model.addAttribute("history", repairService.getRepairHistoryByRepairId(id));
        return "repair_history_single";
    }
}
