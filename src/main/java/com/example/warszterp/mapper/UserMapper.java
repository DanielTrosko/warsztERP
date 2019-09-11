package com.example.warszterp.mapper;

import com.example.warszterp.dto.UserDTO;
import com.example.warszterp.model.entities.Address;
import com.example.warszterp.model.entities.User;

public class UserMapper {
    public static User userToEntity(UserDTO userDTO){
        Address address = new Address();
        address.setId(userDTO.getAddressId());
        address.setApartmentNumber(userDTO.getApartamentNumber());
        address.setCity(userDTO.getCity());
        address.setHouseNumber(userDTO.getHouseNumber());
        address.setPostCode(userDTO.getPostCode());
        address.setStreet(userDTO.getStreet());

        User user = new User();
        user.setAddress(address);
        user.setEmail(userDTO.getEmail());
        user.setId(userDTO.getId());
        user.setFirstName(userDTO.getName());
        user.setPassword(userDTO.getPassword());
        user.setSurname(userDTO.getSurname());
        user.setUsername(userDTO.getUsername());

        return user;
        }

        public static UserDTO toDTO (User user){
        UserDTO userDTO = new UserDTO();
        Address address = user.getAddress();
        userDTO.setApartamentNumber(address.getApartmentNumber());
        userDTO.setCity(address.getCity());
        userDTO.setHouseNumber(address.getHouseNumber());
        userDTO.setPostCode(address.getPostCode());
        userDTO.setStreet(address.getStreet());

        userDTO.setEmail(user.getEmail());
        userDTO.setId(user.getId());
        userDTO.setName(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setSurname(user.getSurname());
        userDTO.setUsername(user.getUsername());
        userDTO.setEnabled(true);

        return userDTO;
        }

}
