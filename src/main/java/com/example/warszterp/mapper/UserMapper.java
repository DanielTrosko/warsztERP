package com.example.warszterp.mapper;

import com.example.warszterp.dto.AcceptanceDataDto;
import com.example.warszterp.dto.UserDto;
import com.example.warszterp.model.entities.Address;
import com.example.warszterp.model.entities.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {
    public static User userToEntity(UserDto userDTO) {
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
        user.setFirstName(userDTO.getFirstName());
        user.setSurname(userDTO.getSurname());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setCompany(userDTO.getCompany());

        return user;
    }

    public static UserDto toDTO(User user) {
        UserDto userDTO = new UserDto();
        Address address = user.getAddress();
        userDTO.setCity(address.getCity());
        userDTO.setHouseNumber(address.getHouseNumber());
        userDTO.setPostCode(address.getPostCode());
        userDTO.setStreet(address.getStreet());
        userDTO.setAddressId(address.getId());

        userDTO.setEmail(user.getEmail());
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setPassword(user.getPassword());
        userDTO.setSurname(user.getSurname());
        userDTO.setUsername(user.getUsername());
        userDTO.setEnabled(true);
        userDTO.setCompany(user.getCompany());
        userDTO.setPhoneNumber(user.getPhoneNumber());

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

    public static AcceptanceDataDto entityToAcceptanceData(AcceptanceDataDto data, User user) {
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


    public static List<UserDto> toDtoList(List<User> list){
    return list.stream().map(user -> toDTO(user)).collect(Collectors.toList());
    }
}
