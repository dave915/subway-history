package com.example.subwayhistory.scheduler;

import com.example.subwayhistory.domain.StationPassengerHistory;
import com.example.subwayhistory.external.SeoulDataApi;
import com.example.subwayhistory.repository.StationPassengerHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class SyncTask {
    private final SeoulDataApi seoulDataApi;
    private final StationPassengerHistoryRepository historyRepository;

    @Transactional
    @Scheduled(cron = "0 0 0 * * *") // 매일 00시에 수행
    public void syncData() {
        int beforeDay = 7;
        List<String> dates = getDatesByBeforeDay(beforeDay);
        for (String date : dates) {
            List<StationPassengerHistory> stationPassengerHistories = seoulDataApi.getStationPassengerHistories(date);
            historyRepository.saveAll(stationPassengerHistories);
        }
    }

    private List<String> getDatesByBeforeDay(int beforeDay) {
        LocalDate today = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return IntStream.range(0, beforeDay)
                .mapToObj(i -> today.minusDays(beforeDay - i).format(dateTimeFormatter)) // day - i -> 오래된 날짜부터
                .collect(Collectors.toList());
    }
}
