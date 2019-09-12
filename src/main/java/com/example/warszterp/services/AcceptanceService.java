package com.example.warszterp.services;

import com.example.warszterp.dto.AcceptanceDataDto;
import com.example.warszterp.dto.RepairDto;
import com.example.warszterp.model.entities.Car;
import com.example.warszterp.model.entities.Repair;
import com.example.warszterp.model.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcceptanceService {


    private CarService carService;
    private RepairService repairService;
    private UserService userService;

    @Autowired
    public AcceptanceService(CarService carService, RepairService repairService, UserService userService) {
        this.carService = carService;
        this.repairService = repairService;
        this.userService = userService;
    }


    public void save(AcceptanceDataDto dataDto){

         User user = userService.getDataAndSave(dataDto);
         Car car = carService.getDataAndSave(dataDto, user);
         repairService.getDataAndSave(dataDto, user, car);
    }

    public List<RepairDto> getAll(){
       return repairService.getAll();
    }

    public AcceptanceDataDto getById(Long id){
        AcceptanceDataDto dataDto = new AcceptanceDataDto();
        dataDto = repairService.getDatafromRepair(id);
        dataDto = carService.getDataFromCar(dataDto);
        dataDto = userService.getDataFromUser(dataDto);

        return dataDto;
    }
}
