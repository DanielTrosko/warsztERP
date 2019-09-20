package com.example.warszterp.controller;

import com.example.warszterp.dto.MessageDTO;
import com.example.warszterp.mapper.MessageMapper;
import com.example.warszterp.model.repositories.MessageRepository;
import org.dom4j.rule.Mode;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/message")
public class MessageController {

    private MessageRepository messageRepository;


    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping(value = "/add")
    public String add(Model model){
        model.addAttribute("msg", new MessageDTO());
        return "message_add";
    }

    @PostMapping(value = "/add")
    public String createMessage(@Valid @ModelAttribute MessageDTO messageDTO, Model model){
        messageRepository.save(MessageMapper.toEntity(messageDTO));
        return "message_add";
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(value = "/admin/showall")
    public String showAllMessage(Model model){
        model.addAttribute("msg", messageRepository.findAll());
        return "show_message";
    }

}
