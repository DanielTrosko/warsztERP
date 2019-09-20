package com.example.warszterp.mapper;

import com.example.warszterp.dto.CalendarDTO;
import com.example.warszterp.model.entities.Calendar;

public class CalendarMapper {

    public static CalendarDTO toDTO(Calendar calendar) {
        CalendarDTO calendarDTO = new CalendarDTO();
        calendarDTO.setId(calendar.getId());
        calendarDTO.setName(calendar.getName());
        calendarDTO.setStartDate(calendar.getStartDate());
        calendarDTO.setStopDate(calendar.getStopDate());
        calendarDTO.setDescription(calendar.getDescription());
        calendarDTO.setEmployee(calendar.getEmployee());
        calendarDTO.setRepair(calendar.getRepair());
        return calendarDTO;
    }

    public static Calendar toEntity(CalendarDTO calendarDTO) {
        Calendar calendar = new Calendar();
        calendar.setId(calendarDTO.getId());
        calendar.setName(calendarDTO.getName());
        calendar.setStartDate(calendarDTO.getStartDate());
        calendar.setStopDate(calendarDTO.getStopDate());
        calendar.setDescription(calendarDTO.getDescription());
        calendar.setEmployee(calendarDTO.getEmployee());
        calendar.setRepair(calendarDTO.getRepair());
        return calendar;
    }
}
