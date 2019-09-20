package com.example.warszterp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainMenuController {

    @GetMapping
    public String displayMainMenu(){
        return "main_menu";
    }
}
