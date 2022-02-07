package com.praveen.cacheutil.controller;

import com.praveen.cacheutil.NumbersService;
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

  private final NumbersService numbersService;

  @GetMapping("/numbers")
  public ResponseEntity<List<Integer>> getNumbers() {

    final var numbers = numbersService.getNumbers();
    log.info("From CacheController, numbers size " + numbers.size());
    return ResponseEntity.ok(numbers);
  }
}
