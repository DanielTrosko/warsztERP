package com.example.warszterp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/car")
public class CarController {

    @GetMapping("/acceptance")
    public String displayAcceptanceForm(){



        return "acceptance_form";
    }


}
