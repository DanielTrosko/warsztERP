package com.example.warszterp.controller;

import com.example.warszterp.dto.UserDTO;
import com.example.warszterp.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String addUser(Model model) {
        model.addAttribute("user", new UserDTO());
        return "add_user_form";
    }

    @PostMapping(value = "/createuser")
    public String createUser(@Valid @ModelAttribute("UserDTO") UserDTO userDTO, Model model) {
        if (userDTO.getId() == null) {
            userService.createUser(userDTO);
            log.info("Create user:" + userDTO.getUsername());
        } else {
            this.userService.updateUser(userDTO);
            log.info("Update user:" + userDTO.getUsername());
        }
        model.addAttribute("msg", "wiadomosc");
        return "index";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "successlogin")
    public String successLogin() {
        return "successlogin";
    }

    @RequestMapping(value = "/failurelogin")
    public String failureLogin() {
        return "failurelogin";
    }

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @GetMapping("/edit")
    public String editUser(Model model, Principal principal){

        model.addAttribute("user", userService.getUserDtoByUsername(principal.getName()));
        return "add_user_form";
    }

}
