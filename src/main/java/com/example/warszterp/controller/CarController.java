package com.example.warszterp.controller;

import com.example.warszterp.dto.AcceptanceDataDto;
import com.example.warszterp.model.entities.CarType;
import com.example.warszterp.model.entities.Fuel;
import com.example.warszterp.services.AcceptanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/car")
public class CarController {


    private AcceptanceService acceptanceService;

    @Autowired
    public CarController(AcceptanceService acceptanceService) {
        this.acceptanceService = acceptanceService;
    }

    @GetMapping("/acceptance")
    public String displayAcceptanceForm(Model model){

        model.addAttribute("data", new AcceptanceDataDto());
        model.addAttribute("fuels", Fuel.values());
        model.addAttribute("cars",CarType.values());
        return "acceptance_form";
    }

    @PostMapping("/acceptance")
    public String processAcceptanceForm(@ModelAttribute("data") AcceptanceDataDto dataDto, BindingResult errors){

        System.out.println(dataDto.toString());
        if (errors.hasErrors()){return "acceptance_form";}
        acceptanceService.save(dataDto);
        return "acceptance_list";
    }
}
