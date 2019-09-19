package com.example.warszterp.services;

import com.example.warszterp.model.entities.Calendar;
import com.example.warszterp.model.entities.Repair;
import com.example.warszterp.model.entities.User;
import com.example.warszterp.model.repositories.CalendarRepository;
import com.example.warszterp.model.repositories.RepairRepository;
import com.example.warszterp.model.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class CalendarService {
    private UserRepository userRepository;
    private RepairRepository repairRepository;
    private CalendarRepository calendarRepository;

    @Autowired
    public CalendarService(UserRepository userRepository, RepairRepository repairRepository, CalendarRepository calendarRepository) {
        this.userRepository = userRepository;
        this.repairRepository = repairRepository;
        this.calendarRepository = calendarRepository;
    }

    public List<Calendar> getAll(LocalDateTime localDateTime) {
        return calendarRepository.getAllByStopDateAfter(localDateTime);
    }
    public void saveNewEvent(Calendar calendar, User user, Repair repair){
    }
}
