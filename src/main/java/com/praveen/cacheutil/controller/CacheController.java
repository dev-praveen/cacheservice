package com.praveen.cacheutil.controller;

import com.praveen.cacheutil.CacheUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CacheController {

  private final CacheUtil cacheUtil;

  @GetMapping("/numbers")
  public ResponseEntity<List<Integer>> getNumbers() {

    final var numbers = cacheUtil.getNumbers();
    log.info("From CacheController, numbers size " + numbers.size());
    return ResponseEntity.ok(numbers);
  }
}
