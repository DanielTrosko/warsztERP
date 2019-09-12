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
    @Transactional
    public User getDataAndSave(AcceptanceDataDto data){

        User user = new User();
        user = UserMapper.acceptanceDataToEntity(data);

        Address clientAddress = user.getAddress();
        Address existingAddress = addressRepository.findByCityAndHouseNumberAndStreet(clientAddress.getCity(), clientAddress.getHouseNumber(), clientAddress.getStreet());

        System.out.println(existingAddress == null);
        if (existingAddress == null){
            existingAddress = addressRepository.save(clientAddress);
        }

        User existingUser = userRepository.findByPhoneNumberAndSurnameAndFirstName(user.getPhoneNumber(), user.getSurname(), user.getFirstName());
        System.out.println(existingUser == null);
        if (existingUser == null){
            user.setAddress(existingAddress);
            existingUser = userRepository.save(user);
        }
        return existingUser;
    }

    public AcceptanceDataDto getDataFromUser(AcceptanceDataDto dataDto){
        User user = userRepository.getOne(dataDto.getUserId());
        return UserMapper.entityToAcceptanceData(dataDto ,user);
    }
}
