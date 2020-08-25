package com.example.subwayhistory.external;

import com.example.subwayhistory.domain.StationPassengerHistory;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CardSubwayStates {
    @JsonProperty(value = "CardSubwayStatsNew")
    private CardSubwayStatsNew cardSubwayStatsNew;

    public List<StationPassengerHistory> getStationPassengerHistories() {
        if (cardSubwayStatsNew == null) {
            return Collections.emptyList();
        }

        return cardSubwayStatsNew.getItems().stream()
                .map(Item::convertStationPassengerHistory)
                .collect(Collectors.toList());
    }

    @Getter
    private static class CardSubwayStatsNew {
        @JsonProperty(value = "list_total_count")
        private int listTotalCount;
        @JsonProperty(value = "RESULT")
        private Result result;
        @JsonProperty(value = "row")
        private List<Item> items;
    }

    @Getter
    private static class Result {
        @JsonProperty(value = "CODE")
        private String code;
        @JsonProperty(value = "MESSAGE")
        private String message;
    }

    @Getter
    private static class Item {
        @JsonProperty(value = "USE_DT")
        private String useDate;
        @JsonProperty(value = "LINE_NUM")
        private String lineNumber;
        @JsonProperty(value = "SUB_STA_NM")
        private String subwayStationName;
        @JsonProperty(value = "RIDE_PASGR_NUM")
        private int ridePassengerNumber;
        @JsonProperty(value = "ALIGHT_PASGR_NUM")
        private int alightPassengerNumber;

        public StationPassengerHistory convertStationPassengerHistory() {
            return StationPassengerHistory.builder()
                    .useDate(useDate)
                    .lineNumber(lineNumber)
                    .stationName(subwayStationName)
                    .boardedNumber(ridePassengerNumber)
                    .alightedNumber(alightPassengerNumber)
                    .build();
        }
    }
}
