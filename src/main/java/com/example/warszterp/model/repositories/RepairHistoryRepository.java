package com.example.warszterp.model.repositories;

import com.example.warszterp.model.entities.RepairHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepairHistoryRepository extends JpaRepository<RepairHistory, Long> {

    List<RepairHistory> findAllByRepairId_Id(Long repairId);
}
