package com.example.warszterp.controller;

import com.example.warszterp.dto.CarDto;
import com.example.warszterp.dto.UserDto;
import com.example.warszterp.services.CarService;
import com.example.warszterp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {


    private UserService userService;
    private CarService carService;

    @Autowired
    public AdminController(UserService userService, CarService carService) {
        this.userService = userService;
        this.carService = carService;
    }

    @GetMapping("/user")
    public String displayUsers(Model model) {
        model.addAttribute("list", userService.getAll());
        return "users_list";
    }

    @GetMapping("/user/add")
    public String displayAddUserForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "add_user_form";
    }

    @PostMapping("/user/add")
    public String processAddUserForm(@Valid @ModelAttribute("user") UserDto userDTO, Model model) {
        return "redirect:/admin/user";
    }

    @GetMapping("/user/delete")
    public String deleteUser(@RequestParam("id") Long id,  Model model) {
        userService.deleteUser(id);
        return "redirect:/admin/user";
    }

    @GetMapping("/car")
    public String displayCars(Model model) {
        model.addAttribute("list", carService.getAll());
        return "cars_list";
    }

    @GetMapping("/car/add")
    public String displayAddCarForm(Model model) {
        model.addAttribute("car", new CarDto());
        return "add_car_form";
    }

    @PostMapping("/car/add")
    public String processAddCarForm(@Valid @ModelAttribute("car") CarDto carDto , Model model) {
        return "redirect:/admin/car";
    }

    @GetMapping("/car/delete")
    public String deleteCar(@RequestParam("id") Long id,  Model model) {
        carService.deleteCar(id);
        return "redirect:/admin/car";
    }
}
