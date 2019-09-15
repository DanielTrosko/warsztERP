package com.example.warszterp.controller;

import com.example.warszterp.dto.AcceptanceDataDto;
import com.example.warszterp.dto.RepairDto;
import com.example.warszterp.model.entities.CarType;
import com.example.warszterp.model.entities.Fuel;
import com.example.warszterp.services.AcceptanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/car")
public class CarController {


    private AcceptanceService acceptanceService;

    @Autowired
    public CarController(AcceptanceService acceptanceService) {
        this.acceptanceService = acceptanceService;
    }

    @GetMapping("/acceptance/add")
    public String displayAcceptanceForm(Model model) {

        model.addAttribute("data", new AcceptanceDataDto());
        model.addAttribute("fuels", Stream.of(Fuel.values()).map(Fuel::name).collect(Collectors.toSet()));
        model.addAttribute("cars", Stream.of(CarType.values()).map(CarType::name).collect(Collectors.toSet()));
        return "acceptance_form";
    }

    @PostMapping("/acceptance/add")
    public String processAcceptanceForm(@Valid @ModelAttribute("data") AcceptanceDataDto dataDto, BindingResult errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("fuels", Stream.of(Fuel.values()).map(Fuel::name).collect(Collectors.toSet()));
            model.addAttribute("cars", Stream.of(CarType.values()).map(CarType::name).collect(Collectors.toSet()));
            return "acceptance_form";
        } if (dataDto.getRepairId() == null){
            acceptanceService.save(dataDto);
            return "redirect:/car/acceptance/all";
        }
        acceptanceService.update(dataDto);
        return "redirect:/car/acceptance/all";
    }

    @GetMapping("/acceptance/all")
    public String displayAcceptanceList(Model model) {

        List<RepairDto> list = acceptanceService.getAll();
        model.addAttribute("list", list);
        return "acceptance_list";
    }
    @GetMapping("/acceptance/one")
    public String displayChosenAcceptance(@RequestParam("id") Long id, Model model){

        AcceptanceDataDto data = new AcceptanceDataDto();
        data = acceptanceService.getById(id);
        model.addAttribute("data", data);
    return "acceptance_single";
    }

    @GetMapping("/acceptance/edit")
    public String editAcceptance(Model model, @RequestParam("id") Long id){
        AcceptanceDataDto data = new AcceptanceDataDto();
        data = acceptanceService.getById(id);
        model.addAttribute("data", data);
        model.addAttribute("fuels", Stream.of(Fuel.values()).map(Fuel::name).collect(Collectors.toSet()));
        model.addAttribute("cars", Stream.of(CarType.values()).map(CarType::name).collect(Collectors.toSet()));
        return "acceptance_form";
    }
}
