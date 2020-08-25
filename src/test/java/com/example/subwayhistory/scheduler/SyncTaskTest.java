package com.example.subwayhistory.scheduler;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SyncTaskTest {
    @Autowired
    private SyncTask syncTask;

    @Test
    void sync() {
        syncTask.syncData();
    }
}