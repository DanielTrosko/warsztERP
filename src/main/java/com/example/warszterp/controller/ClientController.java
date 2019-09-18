package com.example.warszterp.controller;

import com.example.warszterp.dto.CarDto;
import com.example.warszterp.services.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {

    private final CarService carService;


    public ClientController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String displayCars(Principal principal, Model model){

       List<CarDto> cars = carService.getAllByUsername(principal.getName());
       cars.stream().forEach(dto -> System.out.println(dto.toString()));
       model.addAttribute("list", cars);
        return "cars_list";
    }

    @GetMapping("/repairs")
    public String displayRepairs(){

        return "";
    }
}
