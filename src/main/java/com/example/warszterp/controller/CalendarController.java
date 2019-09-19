package com.example.warszterp.controller;

import com.example.warszterp.dto.CalendarDTO;
import com.example.warszterp.dto.RepairDto;
import com.example.warszterp.mapper.CalendarMapper;
import com.example.warszterp.model.entities.Calendar;
import com.example.warszterp.model.entities.Repair;
import com.example.warszterp.services.CalendarService;
import com.example.warszterp.services.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/calendar")
public class CalendarController {

    private CalendarService calendarService;
    private RepairService repairService;

    @Autowired
    public CalendarController(CalendarService calendarService, RepairService repairService) {
        this.calendarService = calendarService;
        this.repairService = repairService;
    }

    @GetMapping(value = "/add")
    public String add(Model model) {
        model.addAttribute("event", new CalendarDTO());
        model.addAttribute("repair", repairService.getAll().stream().map(RepairDto::getAcceptanceNumber).collect(Collectors.toList()));
        return "calendar_event_add";
    }

    @PostMapping(value = "/add")
    public String createEvent(@Valid @ModelAttribute("/event") CalendarDTO calendarDTO, Model model) {
        calendarService.saveNewEvent(calendarDTO);
        return "redirect:/login";
    }

    @GetMapping(value = "/event/{id}")
    public String showEvent(@PathVariable Long id, Model model) {
        String number = calendarService.getOne(id).getRepair();
        model.addAttribute("event", calendarService.getOne(id));
        model.addAttribute("repair", repairService.getByAcceptanceNumber(number));
        return "";
    }

    @PostMapping(value = "/week")
    public String getWeek(Model model) {
        model.addAttribute("week", calendarService.getSevenDaysEvent(LocalDate.now(), LocalDate.now().plus(7,ChronoUnit.DAYS)));
        return "";
    }
}
