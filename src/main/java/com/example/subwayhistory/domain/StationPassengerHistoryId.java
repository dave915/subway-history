package com.example.subwayhistory.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class StationPassengerHistoryId implements Serializable {
    private String useDate;
    private String lineNumber;
    private String stationName;
}
