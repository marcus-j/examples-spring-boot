package de.marcusjanke.examples.springboot.test;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import java.time.Duration;

@TestConfiguration
class OuterTestConfig {

    @Bean
    public Duration timeout() {
        return Duration.ofSeconds(5);
    }
}
