package com.example.warszterp.controller;

import com.example.warszterp.dto.CarDto;
import com.example.warszterp.dto.UserDto;
import com.example.warszterp.model.entities.CarType;
import com.example.warszterp.model.entities.Fuel;
import com.example.warszterp.services.CarService;
import com.example.warszterp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping
    public String displayAdminPanel() {
        return "admin_panel";
    }


    @GetMapping("/user")
    public String displayUsers(Model model) {
        List<UserDto> list = userService.getAll();
        list.stream().forEach(userDto -> System.out.println(userDto.toString()));
        model.addAttribute("list", list);
        return "users_list";
    }

    @GetMapping("/user/add")
    public String displayAddUserForm(Model model) {
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "add_user_form";
    }

    @PostMapping("/user/add")
    public String processAddUserForm(@Valid @ModelAttribute("user") UserDto userDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "add_user_form";
        }

        if (userDTO.getId() == null) {
            userService.createUser(userDTO);
            return "redirect:/admin/user";
        }
        userService.updateUser(userDTO);
        return "redirect:/admin/user";
    }

    @GetMapping("/user/delete")
    public String deleteUser(@RequestParam("id") Long id, Model model) {
        userService.deleteUser(id);
        return "redirect:/admin/user";
    }

    @GetMapping("/user/edit")
    public String editUser(@RequestParam("id") Long id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "add_user_form";
    }

    @GetMapping("/car")
    public String displayCars(Model model) {
        model.addAttribute("list", carService.getAll());
        return "cars_list";
    }

    @GetMapping("/car/add")
    public String displayAddCarForm(Model model) {
        model.addAttribute("car", new CarDto());
        model.addAttribute("fuels", Fuel.values());
        model.addAttribute("types", CarType.values());
        model.addAttribute("users", userService.getAllraw());

        return "add_car_form";
    }

    @PostMapping("/car/add")
    public String processAddCarForm(@Valid @ModelAttribute("car") CarDto carDto, BindingResult errors, Model model) {

        if (errors.hasErrors()){
            model.addAttribute("fuels", Fuel.values());
            model.addAttribute("types", CarType.values());
            model.addAttribute("users", userService.getAllraw());
            return "add_car_form";
        }
        if (carDto.getId() == null){
            carService.save(carDto);
            return "redirect:/admin/car";
        }
        carService.update(carDto);
        return "redirect:/admin/car";
    }

    @GetMapping("/car/delete")
    public String deleteCar(@RequestParam("id") Long id, Model model) {
        carService.deleteCar(id);
        return "redirect:/admin/car";
    }

    @GetMapping("/car/edit")
    public String editCar(@RequestParam("id") Long id, Model model){
        model.addAttribute("car", carService.getById(id));
        model.addAttribute("fuels", Fuel.values());
        model.addAttribute("types", CarType.values());
        model.addAttribute("users", userService.getAllraw());
        return  "add_car_form";
    }
}
