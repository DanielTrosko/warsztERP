package com.example.warszterp.services;

import com.example.warszterp.dto.AcceptanceDataDto;
import com.example.warszterp.dto.UserDTO;
import com.example.warszterp.mapper.UserMapper;
import com.example.warszterp.model.entities.Address;
import com.example.warszterp.model.entities.User;
import com.example.warszterp.model.repositories.AddressRepository;
import com.example.warszterp.model.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static com.example.warszterp.mapper.UserMapper.userToEntity;

@Service
@Transactional
public class UserService {

    private UserRepository userRepository;
    private AddressRepository addressRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public UserService(UserRepository userRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    public void createUser(UserDTO userDTO) {
        User user = userToEntity(userDTO);
        user.setEnabled(true);
        addressRepository.save(user.getAddress());
        userRepository.save(user);
        insertWithQuery(user.getUsername());
    }

    public void updateUser(UserDTO userDTO){
        userRepository.save(userToEntity(userDTO));
    }

    public void insertWithQuery(String username) {
        entityManager.createNativeQuery("INSERT INTO `authorities`(`username`, `authority`) VALUES (?,'ROLE_USER')")
                .setParameter(1, username)
                .executeUpdate();
    }

    public User getDataAndSave(AcceptanceDataDto data){

        User user = new User();
        user =UserMapper.acceptanceDataToEntity(data);
        Address clientAddress = user.getAddress();
        Address existingAddress = addressRepository.findByCityAndHouseNumberAndStreet(clientAddress.getCity(), clientAddress.getHouseNumber(), clientAddress.getStreet());
        if (existingAddress == null){
           clientAddress = addressRepository.save(clientAddress);
        }
        User existingUser = userRepository.findByPhoneNumberAndSurnameAndFirstName(user.getPhoneNumber(), user.getSurname(), user.getFirstName());
        if (existingUser == null){
            user.setAddress(clientAddress);
           user = userRepository.save(user);
        }
        return user;
    }
}
