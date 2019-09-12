package com.example.warszterp.model.repositories;

import com.example.warszterp.model.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

    Address findByCityAndHouseNumberAndStreet(String city, String houseNumber, String street);
}
