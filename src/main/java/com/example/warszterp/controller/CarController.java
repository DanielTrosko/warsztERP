package com.example.warszterp.controller;

import com.example.warszterp.dto.AcceptanceDataDto;
import com.example.warszterp.dto.RepairDto;
import com.example.warszterp.model.entities.CarType;
import com.example.warszterp.model.entities.Fuel;
import com.example.warszterp.model.entities.Repair;
import com.example.warszterp.services.AcceptanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/car")
public class CarController {


    private AcceptanceService acceptanceService;

    @Autowired
    public CarController(AcceptanceService acceptanceService) {
        this.acceptanceService = acceptanceService;
    }

    @GetMapping("/acceptance")
    public String displayAcceptanceForm(Model model) {

        model.addAttribute("data", new AcceptanceDataDto());
        model.addAttribute("fuels", Fuel.values());
        model.addAttribute("cars", CarType.values());
        return "acceptance_form";
    }

    @PostMapping("/acceptance")
    public String processAcceptanceForm(@Valid @ModelAttribute("data") AcceptanceDataDto dataDto, BindingResult errors, Model model) {

        System.out.println(dataDto.toString());
        System.out.println(errors.hasErrors());
        if (errors.hasErrors()) {
            model.addAttribute("fuels", Fuel.values());
            model.addAttribute("cars", CarType.values());
            return "acceptance_form";
        }
        acceptanceService.save(dataDto);
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
        System.out.println(data.toString());
    return "acceptance_single";
    }
}
