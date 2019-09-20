package com.example.warszterp.controller;

import com.example.warszterp.dto.CarDto;
import com.example.warszterp.dto.RepairHistoryDto;
import com.example.warszterp.services.CarService;
import com.example.warszterp.services.RepairService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmployeeController {

    private final CarService carService;
    private final RepairService repairService;


    public EmployeeController(CarService carService, RepairService repairService) {
        this.carService = carService;
        this.repairService = repairService;
    }

    @GetMapping("/cars")
    public String displayCars(Model model){

        List<CarDto> cars = carService.getAll();
        model.addAttribute("list", cars);
        return "cars_list";
    }

    @GetMapping("/repairs")
    public String displayRepairs(Model model){
       model.addAttribute("repairs", repairService.getAll());
        return "repair_list";
    }

    @GetMapping("/history/{repairId}")
    public String displayRepairHistory(Model model, @PathVariable("repairId") Long id){
        model.addAttribute("history", repairService.getAllRepairHistoryByRepairId(id));
        return "repair_history_single";
    }

    @GetMapping("/history/add/{repairId}")
    public String displayRepairHistoryNoteForm(@PathVariable("repairId") Long id, Model model, Principal principal){
        RepairHistoryDto note = repairService.getFilledRepairHistoryObjectWithNoNote(principal.getName(), id);
        model.addAttribute("historyNote", note);
        return "repair_history_add";
    }

    @PostMapping("/history/add")
    public String processRepairHistoryNote(@ModelAttribute("historyNote") RepairHistoryDto note, Model model){
        repairService.saveRepairHistoryElem(note);
        model.addAttribute("history", repairService.getAllRepairHistoryByRepairId(note.getRepairId().getId()));
        return "repair_history_single";
    }
}
