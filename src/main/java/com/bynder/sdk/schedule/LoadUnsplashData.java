package com.bynder.sdk.schedule;

import com.bynder.sdk.rest.PhotosClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class LoadUnsplashData {
    @Autowired
    private PhotosClient factory;

    @Scheduled(fixedRate = 86400000)
    public void scheduleFixedDelayTask() {
         factory.loadPhotos();
    }
}
