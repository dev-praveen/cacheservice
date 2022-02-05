package com.praveen.cacheutil;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Slf4j
@Component
public class CacheUtil {

  public List<Integer> getNumbers() {

    Cache<String, List<Integer>> cache =
        Caffeine.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).build(key -> arrayOfNumbers());
    final var numbers = cache.getIfPresent("numbers");
    Objects.requireNonNull(numbers).forEach(number -> log.info("number " + number));
    return numbers;
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
