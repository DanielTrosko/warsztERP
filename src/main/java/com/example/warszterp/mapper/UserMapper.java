package com.example.warszterp.mapper;

import com.example.warszterp.dto.AcceptanceDataDto;
import com.example.warszterp.dto.UserDTO;
import com.example.warszterp.model.entities.Address;
import com.example.warszterp.model.entities.User;

public class UserMapper {
    public static User userToEntity(UserDTO userDTO) {
        Address address = new Address();
        address.setId(userDTO.getAddressId());
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

    public static UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        Address address = user.getAddress();
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

    public static User acceptanceDataToEntity(AcceptanceDataDto data) {

        User user = new User();
        Address address = new Address();
        address.setCity(data.getCity());
        address.setHouseNumber(data.getHouseNumber());
        address.setId(data.getAddressId());
        address.setPostCode(data.getPostCode());
        address.setStreet(data.getStreet());

        user.setAddress(address);
        user.setFirstName(data.getFirstName());
        user.setCompany(data.getCompany());
        user.setEmail(data.getEmail());
        user.setEnabled(true);
        user.setId(data.getUserId());
        user.setPassword(data.getPassword());
        user.setSurname(data.getSurname());
        user.setUsername(data.getUsername());
        user.setPhoneNumber(data.getPhoneNumber());

        return user;
    }

    public static AcceptanceDataDto entityToAcceptanceData(User user) {

        AcceptanceDataDto data = new AcceptanceDataDto();
        Address address = user.getAddress();
        data.setCity(address.getCity());
        data.setHouseNumber(address.getHouseNumber());
        data.setAddressId(address.getId());
        data.setPostCode(address.getPostCode());
        data.setStreet(address.getStreet());

        data.setFirstName(user.getFirstName());
        data.setCompany(user.getCompany());
        data.setEmail(user.getEmail());
        data.setEnabled(user.isEnabled());
        data.setUserId(user.getId());
        data.setPassword(user.getPassword());
        data.setSurname(user.getSurname());
        data.setUsername(user.getUsername());
        data.setPhoneNumber(user.getPhoneNumber());

        return data;
    }

}
