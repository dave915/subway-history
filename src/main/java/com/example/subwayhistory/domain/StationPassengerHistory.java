package com.example.subwayhistory.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "station_passenger_history")
public class StationPassengerHistory extends BaseEntity {
    @EmbeddedId
    private StationPassengerHistoryId stationPassengerHistoryId;
    private int boardedNumber;
    private int alightedNumber;

    @Builder
    public StationPassengerHistory(String useDate, String lineNumber, String stationName, int boardedNumber, int alightedNumber) {
        stationPassengerHistoryId = new StationPassengerHistoryId(useDate, lineNumber, stationName);
        this.boardedNumber = boardedNumber;
        this.alightedNumber = alightedNumber;
    }
}
