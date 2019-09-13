package com.example.warszterp.services;

import com.example.warszterp.dto.AcceptanceDataDto;
import com.example.warszterp.dto.UserDto;
import com.example.warszterp.mapper.UserMapper;
import com.example.warszterp.model.entities.Address;
import com.example.warszterp.model.entities.User;
import com.example.warszterp.model.repositories.AddressRepository;
import com.example.warszterp.model.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static com.example.warszterp.mapper.UserMapper.userToEntity;

@Service
@Transactional
public class UserService {

    private UserRepository userRepository;
    private AddressRepository addressRepository;
    private PasswordEncoder passwordEncoder;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public UserService(UserRepository userRepository, AddressRepository addressRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void createUser(UserDto userDTO) {
        User user = userToEntity(userDTO);
        user.setEnabled(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        addressRepository.save(user.getAddress());
        userRepository.save(user);
        insertWithQuery(user.getUsername());
    }

    public void updateUser(UserDto userDTO){
        User user = userToEntity(userDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public void insertWithQuery(String username) {
        entityManager.createNativeQuery("INSERT INTO `authorities`(`username`, `authority`) VALUES (?,'ROLE_USER')")
                .setParameter(1, username)
                .executeUpdate();
    }
    public User getDataAndSave(AcceptanceDataDto data){

        User user = new User();
        user = UserMapper.acceptanceDataToEntity(data);

        Address clientAddress = user.getAddress();
        Address existingAddress = addressRepository.findByCityAndHouseNumberAndStreet(clientAddress.getCity(), clientAddress.getHouseNumber(), clientAddress.getStreet());

        if (existingAddress == null){
            existingAddress = addressRepository.save(clientAddress);
        }

        User existingUser = userRepository.findByPhoneNumberAndSurnameAndFirstName(user.getPhoneNumber(), user.getSurname(), user.getFirstName());
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

    public User getDataAndUpdate(AcceptanceDataDto data){

        User user = new User();
        user = UserMapper.acceptanceDataToEntity(data);
        return userRepository.save(user);
    }

    public List<UserDto> getAll(){
      return UserMapper.toDtoList(userRepository.findAll());
    }

    public List<User> getAllraw(){
        return userRepository.findAll();
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public UserDto getById(Long id){
       return UserMapper.toDTO(userRepository.findById(id).get());
    }
}
