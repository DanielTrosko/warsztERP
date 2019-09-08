package com.example.warszterp.mapper;

import com.example.warszterp.dto.UserDTO;
import com.example.warszterp.model.entities.Address;
import com.example.warszterp.model.entities.User;

public class UserMapper {
    public static User userToEntity(UserDTO userDTO){
        Address address = new Address();
        address.setApartmentNumber(userDTO.getApartamentNumber());
        address.setCity(userDTO.getCity());
        address.setHouseNumber(userDTO.getHouseNumber());
        address.setPostCode(userDTO.getPostCode());
        address.setStreet(userDTO.getStreet());

        User user = new User();
        user.setAddress(address);
        user.setEmail(userDTO.getEmail());
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setPassword(userDTO.getPassword());
        user.setSurname(userDTO.getSurname());
        user.setUsername(userDTO.getUsername());

        return user;
        }


}
