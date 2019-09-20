package com.example.warszterp.services;

import com.example.warszterp.dto.CalendarDTO;

import com.example.warszterp.dto.RepairDto;
import com.example.warszterp.mapper.CalendarMapper;
import com.example.warszterp.model.entities.Calendar;

import com.example.warszterp.model.repositories.CalendarRepository;
import com.example.warszterp.model.repositories.RepairRepository;
import com.example.warszterp.model.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


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

    public void saveNewEvent(CalendarDTO calendarDTO) {
        Calendar calendar = CalendarMapper.toEntity(calendarDTO);
        calendarRepository.save(calendar);
    }

    public CalendarDTO getOne(Long id) {
        return CalendarMapper.toDTO(calendarRepository.getOne(id));
    }

    public List<CalendarDTO> getSevenDaysEvent(LocalDate localDate, LocalDate localDate2) {
        List<Calendar> list = calendarRepository.findAll();
        return list.stream().map(CalendarMapper::toDTO).collect(Collectors.toList());
    }
}
