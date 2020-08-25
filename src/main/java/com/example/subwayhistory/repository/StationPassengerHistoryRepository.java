package com.example.subwayhistory.repository;

import com.example.subwayhistory.domain.StationPassengerHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationPassengerHistoryRepository extends JpaRepository<StationPassengerHistory, Long> {
}
