package dev.vrudas.glp;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.google.common.collect.Collections2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    private static final Cache<String, Integer> cache = Caffeine.newBuilder()
        .expireAfterAccess(Duration.ofMillis(1000))
        .build();

    public static void main(String[] args) throws InterruptedException {
        var numbers = List.of(
            0,
            1,
            1,
            2,
            3,
            5
        );

        Collections2.transform(numbers, number -> number * 2)
            .forEach(number -> cache.put("transformedNumber" + number, number));

        logger.info("Cache size: {}", cache.estimatedSize());

        logger.info("Sleep...");
        cache.getIfPresent("transformedNumber1");

        TimeUnit.SECONDS.sleep(5);
        cache.getIfPresent("transformedNumber2");

        logger.info("Cache size: {}", cache.estimatedSize());

        logger.info("Sleep...");
        cache.invalidate("transformedNumber3");

        TimeUnit.SECONDS.sleep(7);

        logger.info("Cache size: {}", cache.estimatedSize());
    }
}
