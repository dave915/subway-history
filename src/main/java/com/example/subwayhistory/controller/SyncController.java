package com.example.subwayhistory.controller;

import com.example.subwayhistory.scheduler.SyncTask;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SyncController {
    private final SyncTask syncTask;

    @GetMapping("/subway/histories/sync")
    public void sync() {
        syncTask.syncData();
    }
}
