package com.example.subwayhistory.external;

import com.example.subwayhistory.domain.StationPassengerHistory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class SeoulDataApi {
    private final RestTemplate restTemplate;
    @Value("${seoul.api.host}")
    private String seoulApiHost;
    @Value("${seoul.api.key}")
    private String seoulApiKey;

    public List<StationPassengerHistory> getStationPassengerHistories(String date) {
        String uri = String.format("%s/%s/json/CardSubwayStatsNew/0/999/%s", seoulApiHost, seoulApiKey, date);
        CardSubwayStates cardSubwayStates = requestCardSubwayState(uri);
        if (cardSubwayStates == null) {
            return Collections.emptyList();
        }
        return cardSubwayStates.getStationPassengerHistories();
    }

    private CardSubwayStates requestCardSubwayState(String uri) {
        try {
            return restTemplate.getForObject(uri, CardSubwayStates.class);
        } catch (Exception e) {
            log.error("서울시 지하철 승하차 정보 API 통신 Error, uri >>> {}", uri, e);
            throw e;
        }
    }
}