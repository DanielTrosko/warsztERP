package com.example.warszterp.mapper;

import com.example.warszterp.dto.MessageDTO;
import com.example.warszterp.model.entities.Message;

public class MessageMapper {

    public static MessageDTO toDTO(Message message){
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setTitle(message.getTitle());
        messageDTO.setMessage(message.getMessage());
        messageDTO.setIp(message.getIp());
        return messageDTO;
    }

    public static Message toEntity(MessageDTO messageDTO){
        Message message = new Message();
        message.setTitle(messageDTO.getTitle());
        message.setMessage(messageDTO.getMessage());
        message.setIp(messageDTO.getIp());
        return message;
    }
}
