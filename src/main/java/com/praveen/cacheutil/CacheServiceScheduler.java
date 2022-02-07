package com.praveen.cacheutil;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Slf4j
@Configuration
@EnableScheduling
@RequiredArgsConstructor
public class CacheServiceScheduler {

  private final NumbersService numbersService;

  @Scheduled(fixedRateString = "${scheduler.duration}")
  public void scheduler() {

    log.info("Initiating scheduler.... ");
    numbersService.getNumbers();
  }
}
