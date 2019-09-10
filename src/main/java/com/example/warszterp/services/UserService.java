package com.example.warszterp.services;

import com.example.warszterp.dto.UserDTO;
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

    @Transactional
    public void createUser(UserDTO userDTO) {
        User user = userToEntity(userDTO);
        user.setEnabled(true);
        addressRepository.save(user.getAddress());
        userRepository.save(user);
        insertWithQuery(user.getUsername());
    }

    @Transactional
    public void updateUser(UserDTO userDTO){
        userRepository.save(userToEntity(userDTO));
    }

    @Transactional
    public void insertWithQuery(String username) {
        entityManager.createNativeQuery("INSERT INTO `authorities`(`username`, `authority`) VALUES (?,'ROLE_USER')")
                .setParameter(1, username)
                .executeUpdate();
    }
}
