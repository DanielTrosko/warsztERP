package com.example.warszterp.controller;

import com.example.warszterp.dto.CalendarDTO;
import com.example.warszterp.services.CalendarService;
import com.example.warszterp.services.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.Stream;

@Controller
@RequestMapping(name = "/calendar")
public class CalendarController {

    private CalendarService calendarService;
    private RepairService repairService;

    @Autowired
    public CalendarController(CalendarService calendarService, RepairService repairService) {
        this.calendarService = calendarService;
        this.repairService = repairService;
    }

    @GetMapping(value ="/add")
    public String add(Model model) {
        model.addAttribute("event", new CalendarDTO());
        model.addAttribute("repair", Stream.of(repairService.getAll()));
        return "calendar_event_add";
    }
}
