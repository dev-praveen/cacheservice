package com.praveen.cacheutil.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Component
@CacheConfig(cacheNames = {"numbers_cache"})
public class NumbersService {

  @Cacheable
  public List<Integer> getNumbers() {

    final var integers = arrayOfNumbers();
    Objects.requireNonNull(integers).forEach(number -> log.info("number " + number));
    return integers;
  }

  private List<Integer> arrayOfNumbers() {

    final var arr = new int[10];

    for (var i = 0; i < arr.length; i++) {
      arr[i] = i;
    }
    log.info("from arrayOfNumbers() method ");
    return Arrays.stream(arr).boxed().collect(Collectors.toList());
  }
}
