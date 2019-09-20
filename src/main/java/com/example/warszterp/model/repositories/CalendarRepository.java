package com.example.warszterp.model.repositories;

import com.example.warszterp.model.entities.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface CalendarRepository extends JpaRepository<Calendar, Long> {
    List<Calendar> getAllByStopDateAfter(LocalDateTime localDateTime);
//    List<Calendar> getAllByStartDateOrStopDateIsBetween(LocalDate startDate, LocalDate stopDate);
    List<Calendar> findAllByStopDateBetween(LocalDate startDate, LocalDate stopDate);
}
